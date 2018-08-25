package p1;

public class Brad01 {
	void m1() {//其他package看不到此方法
		//Brad02 obj2 = new Brad02();//錯誤,不同package無法呼叫到非public類別
	}
	
	protected void m2() {//相同package或繼承的子類別都看的道

	}
	
	
}
