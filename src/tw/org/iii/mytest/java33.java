package tw.org.iii.mytest;

public class java33 {
	public static void main(String[] args) {
		//建構式在進行物件初始化的任務,new時就已存在建立物件實體,後面才在初始化
		//Brad331.m2();//static 代表不用建立實體物件,即可直接執行
		System.out.println("-------------");
		//Brad332.m2();//記憶體內一定要先載入其父類別331
		//Brad331 obj1 = new Brad331();
		Brad332 obj1 = new Brad332();
	}

}

class Brad331{
	static {System.out.println("Brad331{static記憶體載入父類別}");}//該類別被載入時自動執行的城市區塊
	//只要是static 不會用到this 也不會涉及到物件實體的方法和屬性
	{System.out.println("Brad331{父類別物件實體存在}");m1();}//初始化時載入該物件實體的物件區塊
	void m1() {System.out.println("Brad331:m1(物件實體呼叫方法m1(父類別))");}
	
	Brad331() {System.out.println("Brad331(父類別物件實體初始化)");}//建構式
	static void m2() {System.out.println("Brad331:m2()");}
}

class Brad332 extends Brad331{
	static {System.out.println("Brad332{static記憶體載入子類別}");}
	{System.out.println("Brad332{子類別物件實體存在}");}

	Brad332() {System.out.println("Brad332(子類別實體初始化)");}
	void m1() {System.out.println("Brad332:m1(物件實體呼叫方法m1(子類別))");}
	static void m2() {System.out.println("Brad332:m2()");}
}
