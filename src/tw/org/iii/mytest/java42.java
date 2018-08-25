package tw.org.iii.mytest;

public class java42 {

	public static void main(String[] args) {
		m1();

	}
	
	static void m1() {
		int a = 10, b = 3;
		try {
			System.out.println(a/b);
		}catch(Exception e) {
			System.out.println("OK");
			return;
		}finally {//無論是否有拋出例外,最後都會被執行的區塊(就算前面有return也一樣)
			System.out.println("OK2");
		}
		System.out.println("OK3");//(若前面有return則不會執行)
		
	}

}
