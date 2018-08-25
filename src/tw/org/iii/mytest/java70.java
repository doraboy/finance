package tw.org.iii.mytest;

public class java70 {
	public static void main(String[] args) {
		int a = 10;
		Integer b = new Integer(10);
		Integer c = new Integer("10");
		Integer d = 10; // auto-boxing 自動封箱,變為整數物件實體(Integer)
		System.out.println(b+4);//unWrapper(解包) => auto-unboxing
		//將物件b的值解出來
		System.out.println(c+5);
		System.out.println(d+6);
		
		System.out.println(b==a);//true,因a為基本型別=> auto-unboxing
		System.out.println(c==a);//同上true,auto-unboxing,比的是值
		System.out.println(c==b);//比的是兩個不同物件,false
		
		System.out.println(b.equals(a));//a本來是基本型別int,
		//因為equals()要比值,故a被auto-boxing變成物件,比兩個物件的值為true
		

	}

}
