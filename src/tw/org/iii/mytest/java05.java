package tw.org.iii.mytest;

public class java05 {

	public static void main(String[] args) {
		char c1='a';//字元要用' '包夾住,裡面只能放一個字元
		System.out.println(c1);
		char c2='資'; //一個中文字是一個字元 in UTF-8
		System.out.println(c2);
		char c3=65; //ASCII A對應到65
		System.out.println(c3);
		System.out.println(0012);//0開頭為8進位
		System.out.println(0x0031);//0x開頭為16進位
		
		int a1=c1+4;//chat與常數運算結果為int
		System.out.println(a1);

	}

}
