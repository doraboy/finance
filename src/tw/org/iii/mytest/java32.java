package tw.org.iii.mytest;

public class java32 {
	public static void main(String[] args) {


	}

}

class Brad321{
	void m1() {
		System.out.println("Brad321:m1()");
	}
}

class Brad322 extends Brad321{
	void m1() {//override
		System.out.println("Brad322:m1()");
		super.m1();//通常邏輯上可能會呼叫載入父類別的方法
		//作改良(發揚光大),super這行可以不用放在第一句(非建構式的話沒有規定)
	}
}
