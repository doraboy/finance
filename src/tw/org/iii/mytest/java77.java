package tw.org.iii.mytest;

import java.util.TimerTask;

public class java77 {

	public static void main(String[] args) {
		Brad771 obj1 = new Brad771();
		//obj1 是Thread的物件實體
		Brad772 obj2 = new Brad772();	
		Brad773 obj3 = new Brad773();
		//obj2只是一個實作Runnable的自定類別的物件實體
		obj1.start();
		
		//Thread建構式其中之一:Thread(Runnable target)
		//可用任意的Runnable物件實體來建立新的Thread物件實體
//		Thread t2 = new Thread(obj2);
//		t2.start();
		
		Thread t3 = new Thread(obj3);
		t3.start();
		
		//物件實體方法的override
		Thread t4 = new Thread(obj2) {
			public void run(){
				System.out.println("t4");
			};
		};
		t4.start();
		
		//物件名稱不重要,也不需特地寫類別
		//只要執行一次(表現其生命週期) 所以可以這樣簡便的寫
		new Thread() {
			int a;//除override外,可再增加該物件的屬性
			public void run() {
				for(int i=10000; i<10020; i++) {
					System.out.println(i);
					try {
						//sleep()為static,可直接指名呼叫
						Thread.sleep(100);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
				test1();
			}
			//除override外,也可再增加該物件的方法
			public void test1() {
				System.out.println("test1");
			}
		}.start();
		
		
		
		System.out.println("主執行緒ok");
	}

}

//只要繼承Thread,就無法再繼承其他物件了
//故本方法只限於,只繼承Thread的物件
class Brad771 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

//可意任意繼承複數的類別, implements Runnable
class Brad772 implements Runnable {
	@Override
	public void run() {
		for(int i=100; i<120; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
}

//TimerTask也有實作Runnable
class Brad773 extends TimerTask {
	@Override
	public void run() {
		for(int i=1000; i<1020; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
	
}
