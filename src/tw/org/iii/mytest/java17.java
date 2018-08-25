package tw.org.iii.mytest;

public class java17 {

	public static void main(String[] args) {
		int[] number = new int[7];

		for(int i=0;i<1000000;i++){//擲1000000次骰子
		int point=(int)(Math.random()*9)+1;//加鉛的骰子,4,5,6機率加大
		if(point>=1 && point<=9) {
			number[point>=7?point-3:point]++;//三元運算式
		}
		else number[0]++;
		}

		
		if(number[0]==0){
			for(int i=1;i<number.length;i++)
				System.out.println("點數"+i+"次數為"+number[i]);
		}else {
			System.out.println("XX");
		}
		
	}

}