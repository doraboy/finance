package tw.org.iii.mytest;

public class java81 {//ATM存提款
	public static void main(String[] args) {
		ATMv2 atm = new ATMv2();
		//維護atm的銀行也是一個執行緒
		Bankv2 bank = new Bankv2(atm);
		//每個領錢的人都是一個執行緒
		Personv2 pA = new Personv2(atm, "A");
		Personv2 pB = new Personv2(atm, "B");
		Personv2 pC = new Personv2(atm, "C");
		Personv2 pD = new Personv2(atm, "D");
		bank.start();//銀行開始運作執行
		pA.start();
		pB.start();
		pC.start();
		pD.start();
	}
}

class ATMv2{
	private int limit = 1000;
	private int money;
	
	//只有一個物件實體會補錢,不需要synchronized
	void add(int add) {
		while(money+add>limit) {
			try {
				System.out.println("bank:"+add+ ":wait("+money+")");
				wait();
			} catch (InterruptedException e) {}
		}
		money += add;
		System.out.println("add:"+add+" => "+money);
		//通知所有等候領錢的人,這個ATM物件已經開放讓人領錢
		notifyAll();
		}
	
	//可能會同時有多物件實體來領錢,需要synchronized
	//鎖定方法任何時候只能給一個物件存取
	//synchronized void get(int get,String name) {
	void get(int get,String name) {	
		while(money<get) {
			try {
				System.out.println(name +":"+get+ ":wait("+money+")");
				wait();
			} catch (InterruptedException e) {}
		}
			money -= get;
			System.out.println(name+":get:"+get+" => "+money);
			notifyAll();
			//若用notify(),只有通知排隊第一個等候的人,這個ATM物件已經開放
	}
}


class Bankv2 extends Thread{//銀行端行員會來補錢
	private ATMv2 atm;
	Bankv2(ATMv2 atm){this.atm = atm;}
	@Override
	public void run() {
		for(int i=0; i<50;i++){
			
			//鎖定atm補錢時,不能讓人來領錢
			synchronized(atm) {
			atm.add(200);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}

class Personv2 extends Thread{//領錢的人也要認識某台實體atm
	private ATMv2 atm;
	private String name;//領錢的人的姓名
	Personv2(ATMv2 atm,String name){this.atm = atm;this.name=name;}
	@Override
	public void run() {
		for(int i=0; i<50;i++){
			
			//也可鎖定物件實體,不讓其他執行緒來搶該物件實體
			synchronized(atm) {
			atm.get((int)(Math.random()*100)+1,name);//一次領1-100元
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		System.out.println(name + ":stop");
		
	}
}
