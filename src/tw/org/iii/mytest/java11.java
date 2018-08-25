package tw.org.iii.mytest;

public class java11 {
	public static void main(String[] args) {
		byte a=10,b=100;//為變數
		final byte c=100;//fianl只能給初始值,c為常數
		//c=100;//錯誤,不能重給值
		
		switch(a) {
		case 1:
			System.out.println("A");
			break;
		case 10:
			System.out.println("B");
			break;
		//case 100:
		//case b://case後面只能放常數
		case c-91://c已經是常數,常數相減還是常數
			System.out.println("C");
			break;
//		case 1000://超出byte範圍-128~+127
//			System.out.println("D");
//			break;
		default:
			System.out.println("X");
			break;
		
		}
	}

}
