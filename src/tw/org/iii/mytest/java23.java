package tw.org.iii.mytest;

public class java23 {

	public static void main(String[] args) {
		String s1 = new String();
		byte[] b2= {97,98,99,100};
		String s2 = new String(b2);
		String s3 = new String(b2,1,2);//offset=1,length=2
		
		//一個字串的物件實體只要被建立,其內容就不再會被變更
		//若有變更=重新指向(舊的物件實體還在那邊保留)
		System.out.println(s1);//" "
		System.out.println(s2);//"abcd" asci碼
		System.out.println(s3);//"bc"
		
		s1 = new String(b2);//已經重新指向新的物件實體,舊的就變garbage
		//不建議使用
		
		String s4 = "Brad";//會在string pool尋找"Brad",若無則
		//在其中產生一個"Brad"的物件實體,並讓s4指向它
		String s5 = "Brad";//s5跟s4指向同一個"Brad"的物件實體
		String s6 = new String(s4);//new=產生某記憶體區塊並指向它  後面則是呼叫建構式初始化
		String s7 = new String(s5);
		
		
		
		
		int a=10, b=10;
		System.out.println(a==b);
		System.out.println("--------------");
		System.out.println(s4==s5);//s4和s5指向同一個記憶體位置,為同一個物件實體
		System.out.println(s4==s6);//已經new過,是別的字串物件實體
		System.out.println(s4==s7);//==比較是否為相同的物件實體
		//即比較兩者記憶體的值,所以只要用new出來的物件"=="都會得到false
		
		System.out.println("--------------");
		System.out.println(s4.equals(s5));//equals()比物件的字串"內容"是否相等
		System.out.println(s4.equals(s6));
		System.out.println(s4.equals(s7));
		System.out.println("--------------");
		s4=s6;//將s4指向s6的位置,變成指向相同的物件實體
		System.out.println(s4==s6);
		
		
		

	}

}
