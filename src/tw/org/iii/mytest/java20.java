package tw.org.iii.mytest;

public class java20 {
	//static和public可對調
	static public void main(String[] brad) {//brad處可任意指定
		Bike b1 = new Bike();//該物件實體已建立,並有初始值
		Bike b2 = new Bike();//第二個物件實體
		System.out.println(b1);//在某路徑下該類別實體@記憶體位置

		int[] a = new int[3];//陣列即為一個物件
		System.out.println(a);//[I@記憶體位置
		
		System.out.println(b1.getSpeed());//測速
		//has-a用.來表示
		for(int i=0;i<8;i++) b1.upSpeed();//加速8次

		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
	}

}
