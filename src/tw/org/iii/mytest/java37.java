package tw.org.iii.mytest;

public class java37 {
	public static void main(String[] args) {


	}
}

interface Brad371{
	void m1();
}

interface Brad372{
	void m2();
}

//介面的繼承(融合)可以是多,例如一個人可以考取很多證照
interface Brad373 extends Brad371, Brad372{//融合前兩個介面規格+自己既有的規格
	void m3();
}

class Brad374 implements Brad373 {//同時符合上述介面
	public void m1() {}
	public void m2() {}
	public void m3() {}
	void m4() {}//自己自有的內容
}
