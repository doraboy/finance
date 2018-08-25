package tw.org.iii.mytest;

public class java13 {

	public static void main(String[] args) {
		int i=0;//全域變數
		
		//for(進來只做一次的敘述句;判斷是否為true;後續可重複做的敘述句 )
		//for( ; ; ){//無窮迴圈,可作不知何時結束的事件,例如伺服器
		for(m1(); i<10; System.out.println("-----")){//i為區域變數
			System.out.println(i++);	
		}
		System.out.println(i);
	}
		
		public static void m1() {
			int a = 10, b = 3;
			System.out.println(a/b);
		}

}
