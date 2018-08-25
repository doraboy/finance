package tw.org.iii.mytest;

public class java36 {
	public static void main(String[] args) {
		Brad363 obj1 = new Brad363();
		Brad362 obj2 = new Brad363();
		obj1.m3();
		//obj2.m3();//錯誤,宣告為Brad362,不認識m3()
		
	}
}

interface Brad362{//訂介面(協定/規格),永遠都是public,不用修飾字
	void m1();//內容也全都是public,大家都可實作
	void m2();
}

//規格只會有宣告,而不會有任何實作的方法
//連抽象的修飾字都可省略不用寫,即所有方法皆為抽象

//抽象和介面擺明就是要實現"多型"的概念

//介面的實作可以是多重(反之繼承只能單一繼承)

class Brad363 implements Brad362{//實作的關鍵字為implements,其介面相關方法實作要加public修飾字
	public void m1() {}
	public void m2() {}
	void m3() {}//非介面相關方法,不需加public
}

abstract class Brad364 implements Brad362{
	public void m1() {}
	public void m2() {}

}