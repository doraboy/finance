package tw.org.iii.mytest;
//開新project時,切記要按右鍵選Projects=>Resource=>編碼請選UTF-8 (2^24個)
//千萬不要用MS950 (2^16=65536個不夠用)

public class java01 {

	public static void main(String[] args) {
		byte b1; //區域變數 byte型態為整數-128~+127 =>256個=2^8
		byte b2=12; //宣告同時給值
		byte b3=127;
		//變數命名規則[a-zA-Z$_][a-zA-Z0-9$_]*
		byte 變數1=123;
		System.out.println(變數1);
		
		short s1=128; //2^16  =>-32768~+32767
		short s2=-32768;
		
		int a1=123; //2^32 =>-2^31~+2^31-1
		long g1=123; //2^64 =>-2^63~+2^63-1
	}
	
	    /*
		 * 這是註解
		 */
		
		/**
		 * JavaDOC
		 */
}
