package tw.org.iii.mytest;

public class java41 {

	public static void main(String[] args) {
//		double a = 10, b = 0;//double不精確,故0其實是極接近0的數字
//		double c = a/b; //無限大
	
		int a = 10, b = 0;//若為double不精確,故0其實是極接近0的數字	
		int c;
		
		int[] d= new int[3];
		try {
			c = a/b;
			System.out.println(c);//若沒try catch,在這一行拋出例外後,程式中止執行
			System.out.println("before");//本行(含)以下不會被執行(前面已處理例外,跳出try區塊)
			System.out.println(d[13]);
			System.out.println("after");
		} catch (ArrayIndexOutOfBoundsException e) {
			//例外也是個物件實體,被自動產出了,並拋出,被try catch捕捉到
			System.out.println("Ooop1");
		}catch (ArithmeticException e) {//例外的捕捉是從上到下,捕捉到後就不會執行剩下的捕捉
		//}catch (RuntimeException e) {//上行也可這樣寫,因為任何執行中的例外都是RuntimeException
		//但若有直系血親關係的Exception,一定要把處理範圍較大的寫下面
		//不然一顛倒,剩下的子exception就會變成多餘的
		//Unreachable catch block...(編譯錯誤)
			System.out.println("Ooop2");
		}
		
		System.out.println("Game Over");

	}

}
