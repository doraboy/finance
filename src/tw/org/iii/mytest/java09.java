package tw.org.iii.mytest;

public class java09 {
	public static void main(String[] args) {
		int a = 10, b = 3;
		//&&和||代表邏輯比對,代表二進位運算
		if(a++ >=10 || b--<=3) {//前半已經是true,故不用執行後半
			System.out.println("OK:a="+ a + ";b="+b);//a=11;b=3
		}else {
			System.out.println("XX:a="+ a + ";b="+b);		
		}
		
		
		int c = 10, d = 3;
		 {//&和|和^代表二進位運算
		if(--c >=10 & ++d<=3) {//二進位運算,前後都會執行
			System.out.println("OK:c="+ c + ";d="+d);//c=9;d=4
		}else {
			System.out.println("XX:c="+ c + ";d="+d);		
		}
		
		//以下為二進位運算
		System.out.println(3 & 2);//1 1 and 1 0=1 0 =2^1+0*2^0=2
		System.out.println(3 | 2);//1 1 or 1 0=1 1 =2^1+2^0=3
		System.out.println(3 ^ 2);//1 1 xor 1 0=0 1 =0*2^1+2^0=1
		
		//JAVA是以;或{}這兩種做結尾(分隔敘述句)
		//以下編譯沒問題(兩個敘述句),但邏輯錯誤
		if(a>100);{
			System.out.println("III");
		}
		
		 
		 }
	}

}
