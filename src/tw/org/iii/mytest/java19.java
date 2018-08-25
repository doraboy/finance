package tw.org.iii.mytest;

public class java19 {

	public static void main(String[] args) {
		
		int a=1;
		while(a<10) {//前側迴圈
			System.out.println(a++);
		}
		
		a=1;
		do {//後側迴圈,至少執行一次
			System.out.println(a++);
		}while(a<10);
		
		a=1;
		for(;a<10;) {
			System.out.println(a++);
		}
		

	}

}
