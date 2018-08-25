package tw.org.iii.mytest;

public class java03 {
	public static void main(String[] args) {
		float f1=1.2f; //1.2 => double; 1.2f => float;
		double s1=12.3;
		System.out.println(f1);
		
		f1++;
		System.out.println(f1);
		f1+=10;
		System.out.println(f1);
		
		long a1=10;
		float a2= a1+f1;//byte,short,int,long等整數型態+float=> float

	}

}
