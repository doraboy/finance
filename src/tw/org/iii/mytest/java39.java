package tw.org.iii.mytest;

public class java39 {

	public static void main(String[] args) {
		Brad391 obj1 = new Brad391();//要先建立外部物件實體Brad391
	    Brad391.Brad392 obj2=obj1.new Brad392();//才能做出其內部的物件實體Brad392
	    obj2.m1();
	    Brad391.Brad393 obj3=new Brad391.Brad393();//先建立內部的物件實體Brad393
	    obj3.m1();//不需要用obj1來new(因為是static)
	}

}

class Brad391{
	private int a = 10;
	class Brad392{
		Brad391 m1() {
			System.out.println("Brad391:Brad392:m1()");
			System.out.println(a);
			return Brad391.this;//此寫法很常見,由內部類別的工廠
			//生產(return)出外部類別的物件實體
		}
	}
	
	static class Brad393{
		void m1() {
			System.out.println("Brad391:Brad393:m1()");
		}
	}
	
}
