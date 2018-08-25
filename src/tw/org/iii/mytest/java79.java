package tw.org.iii.mytest;

public class java79 {

	public static void main(String[] args) {
		Brad791 obj1 = new Brad791("A");
		
		
		obj1.start();
		//主緒派完obj1的工作後跑去睡覺一秒鐘
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		//一秒之後,B的工作被安排進來等待執行
		Brad791 obj2 = new Brad791("B");
		obj2.start();
		System.out.println("OK1");
		try {
			obj2.join(2000);//主緒中呼叫某執行緒的join方法
			//會將該物件run方法併入主緒中
			//若放入參數(單位為毫秒),則在讓obj2於該時間內優先執行
			//之後主緒會和其他所有執行緒同時排隊等待執行
		} catch (InterruptedException e) {}
		
		System.out.println("OK2");
		
	}	

}

class Brad791 extends Thread {
	String name;
	Brad791(String name){this.name = name;}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(name + ":" +i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
	
}
