package tw.org.iii.mytest;

public class java21 {

	public static void main(String[] args) {

		Bike b1;//純宣告,尚未建立實體
		b1=new Bike();//已建立新的實體,該物件的記憶體區塊已產生
	    //真正作物件是在new,並於建立物件時呼叫該類別建構式作初始化
		
		System.out.println(b1.getSpeed());
		
		Bike b2;
		b2=new Bike(1.4);
		b2.upSpeed(2);//使用者傳入檔位1-10,決定加速度
		System.out.println(b2.getSpeed());

	}

}
