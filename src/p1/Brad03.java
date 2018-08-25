package p1;

public class Brad03 extends Brad01{
	//int m1() {//此寫法錯誤,因為方法名稱,參數型別都一樣就是override
	void m1() {//跟其父類別Brad01的override
		//super.m1();
	}
	
	@Override
	protected void m2() {
		super.m2();
	}

}
