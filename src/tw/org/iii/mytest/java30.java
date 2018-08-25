package tw.org.iii.mytest;

public class java30 {
	public static void main(String[] args) {
		Brad304 obj1 = new Brad304();
		obj1.m1(2);//2預設為int,故呼叫303的m1方法
		obj1.m1((byte)2);//參數丟入byte,故呼叫304的m1方法
		
		Brad301 obj2 = new Brad301();	
		obj2.sayYa(new String[]{"Brad","Eric","OOO"});
		obj2.m1(1);//優先呼叫有定明確個數的同名異式(overload)

		Brad302 obj3 = new Brad302();
		obj3.m1(new int[]{1,3,7});//已被override
	}
}

class Brad301{
	Object m1() {
		return new Object();
	}
	
	//void sayYa(String[] names) {///方法一:用陣列作為參數
	void sayYa(String...names) {//方法二:不定個數的一維陣列寫法,元素型別為String
	//不定參數"..."只能寫在參數的最後面,不定參數可為0個
	//void sayYa(String fmane,String...names) {//至少要有一個參數的不定個數寫法
	//void sayYa(String[]...names) {//二維陣列寫法
		for (String name:names) {
			System.out.println(name+ " ,Ya!");
		}
	}
	
	void m1(int a) {
			System.out.println("A1");
	}
	void m1(int a,int b) {
		System.out.println("A2");
	}
	void m1(int...as) {
		System.out.println("A3");
	}
//	void m1(int[] names) {//與上述方法參數皆為陣列,不能同時並存,推薦上述寫法
//		System.out.println("A4");
//	}
	
	
	
}

class Brad302 extends Brad301{
	String m1() {//override 父類別的方法
		return "";//基本型別override型別要一樣
		//其他物件型別,return的型別要大於等於父類別
		//修飾字也要大於等於父類別(發揚光大的概念)
	}
	
	void m1(int[] names) {//寫在這邊就可override Brad301的void m1(int...as) 
	System.out.println("A4 (override)");
}
	
}

class Brad303{
	int m1(int a) {
		System.out.println("Brad303的m1方法");
		return 1;
	}
}

class Brad304 extends Brad303{
	String m1(byte a) {//overload ,傳回型別隨便
		System.out.println("Brad304的m1方法");
		return "a";
	}
}

