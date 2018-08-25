package tw.org.iii.mytest;

import java.util.Timer;
import java.util.TimerTask;

public class java75 {
	public static void main(String[] args) {
		//Timer的物件會是另外一個執行緒(跟主緒平行)
		
		//false代表不是背景程式,不會相依於主緒,不會自動同主緒一起結束
		Timer timer = new Timer(false);
		MyTask myTask  = new MyTask();
		StopTimer stopTask  = new StopTimer(timer);
		timer.schedule(myTask, 1*1000, 1*1000);
		timer.schedule(stopTask, 5*1000);
		System.out.println("here");
		//timer.cancel();

	}

}

class MyTask extends TimerTask{
	@Override
	public void run() {
		System.out.println("OK");
		
	}
}

class StopTimer extends TimerTask{
	Timer timer;
	public StopTimer(Timer timer) {this.timer = timer;}
	@Override
	public void run() {
		timer.cancel();
		//以下這個方法也行
		//System.exit(0);		
	}

}