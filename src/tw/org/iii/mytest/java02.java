package tw.org.iii.mytest;

public class java02 {
	public static void main(String[] args) {
		int a1=10, a2=3;
		int a3=a1/a2; //"a1/a2"這裡已經是整數了
		System.out.println(a3);
		byte b1=10, b2=3;
		
		//byte,short,int三種變數作運算後結果為int型別
		//byte b3=b1/b2; 大範圍型別指定成小範圍型別=>錯誤! 
		//short b5=b1/b2; 大範圍型別指定成小範圍型別=>錯誤! 
		short b4=(byte)(b1/b2); //小範圍型別指定成大範圍型別=>ok!
		byte b6=(byte)(b1/b2);
		int b3=b1/b2;
		
		//byte b7=b1+3;錯誤=>byte,short,int變數和常數作運算也還是int型別
		byte b8=10+3;//常數間作運算出來是值,再指定給byte=>ok!
		byte b9=127;
		b9++;
		System.out.println(b9);//移位後變成-128還是在範圍內
		b9--;
		System.out.println(b9);//移位後變成+127還是在範圍內
		//b9=b9+1;錯誤 (出來是int) 不等於b9++
		b9+=4;
		System.out.println(b9);//移位後還是在範圍內
		b9-=4;
		System.out.println(b9);//移位後還是在範圍內
		
	}

}
