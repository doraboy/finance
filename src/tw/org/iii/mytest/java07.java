package tw.org.iii.mytest;

public class java07 {
	public static void main(String[] args) {
		int score = (int)(Math.random()*101);
		//Math.random()隨機範圍[0，1), 包含0,不含1
		//但如果是(int)Math.random()*101出來會是0*101=0
		
		//int score = (int)(Math.random()*6+1);骰子6個數字及位移+1
		//int score = (int)(Math.random()*49+1);//樂透49個數字及位移+1
		//int score = (int)(Math.random()*40+30);//分數30~69 40個數字及位移+30

		System.out.println(score);
		if(score>=90) System.out.println("A");//單列敘述句可免{}
		
		
		if(score>60) {
			System.out.println("pass!");
		}
		else {
			System.out.println("down!");
		}
		
		
		if(score>=90) { //if...else if...else 裡面都只限單列敘述句
			System.out.println("A");
		}
		else if (score>=80) {
			System.out.println("B");
		}
		else if (score>=70) {
			System.out.println("C");
			score=58;
		}
		else if (score>=60) {
			System.out.println("D");
		}
		else {
			System.out.println("E");
		}
		System.out.println("after:"+score);

	}

}
