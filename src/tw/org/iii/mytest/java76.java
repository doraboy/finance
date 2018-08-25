package tw.org.iii.mytest;

public class java76 {
	public static void main(String[] args) {
		Brad761 t1 = new Brad761("A");
		Brad761 t2 = new Brad761("B");
		
		//start()只是讓某Thread丟入run pool中候選
		//之後會由CPU決定來執行誰(若無優先順序,則隨機選擇)
		//非由程式設計者決定
		t1.start();
		t2.start();
		System.out.println("OK");
		try {
			Thread.sleep(3*1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("wake up");
		
		//t1.start();
		//若寫這樣會錯誤,因為執行緒都有其生命週期
		//執行完就結束其生命,無法再start()

		t1.run();
		t2.run();
	}
}

class Brad761 extends Thread {
	String name;
	Brad761(String name){this.name = name;}
	@Override
	public void run() {//該執行緒生命週期存在於其run方法的左括號到右括號間
		for(int i =0;i<10;i++){
			System.out.println(name + ":" + i);
			try {
				//sleep()只是讓某Thread回到run pool中候選
				//之後會由CPU決定來執行誰(若無優先順序,則隨機選擇)
				//非由程式設計者決定
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}
