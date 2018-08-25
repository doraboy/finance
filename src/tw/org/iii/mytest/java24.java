package tw.org.iii.mytest;

public class java24 {

	public static void main(String[] args) {
		Bike b1=new Bike();
		Scooter s1=new Scooter();
		System.out.println("---測原本速度---");
		System.out.println("父類別:"+b1.getSpeed());//父類別取得原本速度
		System.out.println("子類別:"+s1.getSpeed()+"(子類別重新定義:灌水測速+2)");//子類別取得原本速度+2
		//子類別的getSpeed()已被重新定義(Override)
		
		b1.upSpeed();//加速1.4倍
		System.out.println("-------父類別:加速後(1.4倍)-------");
		System.out.println(b1.getSpeed());

		
		s1.changeGear(3);//改檔位(子類別自己的新方法)
		s1.upSpeed();//子類別的upSpeed()方法,已被重新定義(Override)
		System.out.println("---子類別:改檔位為3並重新加速後再灌水測速+2---");
		System.out.println(s1.getSpeed());
		System.out.println("---(4.2*1.4)*3+2---");


	}

}
