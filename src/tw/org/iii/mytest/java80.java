package tw.org.iii.mytest;

public class java80 {//ATM存提款
	public static void main(String[] args) {
		ATM atm = new ATM();
		//維護atm的銀行也是一個執行緒
		Bank bank = new Bank(atm);
		//每個領錢的人都是一個執行緒
		Person pA = new Person(atm, "A");
		Person pB = new Person(atm, "B");
		Person pC = new Person(atm, "C");
		Person pD = new Person(atm, "D");
		bank.start();//銀行開始運作執行
		pA.start();
		pB.start();
		pC.start();
		pD.start();
	}
}

class ATM{
	private int limit = 1000;
	private int money;
	
	//只有一個物件實體會補錢,不需要synchronized
	void add(int add) {
		if(money+add>limit) {
			//xx
			System.out.println("add:xx");
		}else {
			money += add;
			System.out.println("add:"+add+" => "+money);
		}
	}
	
	//可能會同時有多物件實體來領錢,需要synchronized
	//也可如下鎖定方法任何時候只能給一個物件存取
	//synchronized void get(int get,String name) {
	void get(int get,String name) {
		if(money<get) {
			//xx
			System.out.println(name+":get:xx");
		}else {
			money -= get;
			System.out.println(name+":get:"+get+" => "+money);
		}
	}
}


class Bank extends Thread{//銀行端行員會來補錢
	private ATM atm;
	Bank(ATM atm){this.atm = atm;}
	@Override
	public void run() {
		for(int i=0; i<10;i++){
			
			//鎖定atm補錢時,不能讓人來領錢
			synchronized(atm) {
			atm.add(500);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}

class Person extends Thread{//領錢的人也要認識某台實體atm
	private ATM atm;
	private String name;//領錢的人的姓名
	Person(ATM atm,String name){this.atm = atm;this.name=name;}
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
