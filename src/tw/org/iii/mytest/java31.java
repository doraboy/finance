package tw.org.iii.mytest;

public class java31 {

	public static void main(String[] args) {
		Brad311 obj1 = new Brad311();
		byte a = 1, b = 2;
		obj1.m1(a,b);

	}

}

class Brad311{
	void m1(byte a) {
		System.out.println("A");
	}
	void m1(byte a, int b) {//沒下面那兩個同名異式,可以執行,byte可強制轉型為較大類別int
		System.out.println("B");
	}
	void m1(int a, byte b) {//加入本方法,不知道呼叫哪個(ambiguous),編譯錯誤
		System.out.println("C");
	}
	void m1(byte a, byte b) {//加入本方法,就指定呼叫這個
		System.out.println("D");
	}
	
}
