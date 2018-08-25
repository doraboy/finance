package tw.org.iii.mytest;

public class java34 {
	public static void main(String[] args) {
		//Brad341 obj1 = new Brad341();//錯誤,此類別為抽象不能實作出物件實體
		Brad341 obj2 = new Brad342();//ok,可以用子類別來實作出物件實體
		Brad341 obj3 = new Brad343();
		obj2.m2();
		obj3.m2();
		
		//例如m2()是父類別擁有的"按鈕",但按鈕實作由各子類別來實作出來
	}
}

abstract class Brad341{
	void m1() {System.out.println("Brad341:m1()");}
	abstract void m2();//java只能用分號或大括號作為結束
	//abstract:有定義但無實作
	//只要該類別有任何abstract的方法,則該類別也要宣告為abstract類別
	
	//並由其子類別來實作此抽象方法,每個子類別都要實作自己的方法
}

class Brad342 extends Brad341{
	void m2() {System.out.println("Brad342:m2()");}//作為其父類別抽象方法的實作,但內容也可為空
}

class Brad343 extends Brad341{
	void m2() {System.out.println("Brad343:m2()");}//作為其父類別抽象方法的實作,但內容也可為空
}