package p2;

//public class Brad03 extends Brad01{//同package(路徑)下寫法
public class Brad03 extends p1.Brad01{//不同package(路徑)下寫法
//	int m1() {//此寫法可以,因為p1.Brad01.m1()是"沒寫"屬性,所以看不到,故非override
//
//	}
	
	void m1() {

	}
	
	protected void m2() {//這裡是override,因為p1.Brad01.m2()是protected屬性
		//可被其子類別看的到
	}

}
