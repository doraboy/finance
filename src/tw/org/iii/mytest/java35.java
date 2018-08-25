package tw.org.iii.mytest;

public class java35 {
	public static void main(String[] args) {
		Shape s1 = new Circle();
		m2(s1);
		Shape s2 = new Retangle();
		m2(s2);
	}
	
	static void m2(Shape s) {
		System.out.println(s.calArea());
	}
}

abstract class Shape {//抽象類別一定有子類別和建構式
	Shape(){
		System.out.println("I am shape");
	}
	void setName() {}//一個抽象類別也能擁有普通方法
	abstract double calLength();
	abstract double calArea();
}

class Circle extends Shape {
	double calLength() {
		return 1.0;
	}
	double calArea() {
		return 1.0;		
	}
}

class Retangle extends Shape {
	double calLength() {
		return 4.0;
	}
	double calArea() {
		return 4.0;		
	}
}


abstract class Brad351 {//抽象類別也可以不要有抽象方法
	void m1(){}//但對外還式宣稱為抽象,代表不能單純直接由父類別建立物件實體
}

final class Brad352  {//final代表Brad361絕對不會有子類別

}
