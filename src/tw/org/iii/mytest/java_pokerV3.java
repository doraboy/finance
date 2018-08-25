package tw.org.iii.mytest;
import java.util.Arrays;

public class java_pokerV3 {
	public static void main(String[] args) {
		//洗牌:一維陣列
		//作業:請用只洗51次的洗牌法(與最後一張交換)
		
		int[] poker=new int[52];
		int temp;//抽選第temp張牌,跟最後一張牌交換
		int poker_temp;//暫存第temp張牌的值
		
		for(int i=0;i<poker.length;i++) {
			poker[i]=i;
		}//將位置從第0-51張牌的值指定為0-51的值
		
		for(int i=0;i<poker.length;i++) {//進行換牌動作
			temp=(int)(Math.random()*52);
			poker_temp=poker[temp];//儲存第temp張牌的值
			poker[temp]=poker[poker.length-i-1];//第temp張指定為最後一張的值
			poker[poker.length-i-1]=poker_temp;//最後一張的值指定為第temp張原本的值
			//隨著換牌進行(i變大),已洗過的放後面,每次換牌的"最後一張"(poker.length-i-1)愈來愈前面
		}
		

		for(int i=0;i<poker.length;i++) {
			System.out.println(poker[i]);
		}
		
		System.out.println("----------洗牌完成--------");
			
		//發牌給四個人:二維陣列
		int[][] players=new int[4][13];//紀錄四位玩家所拿到的牌
		for(int i=0;i<poker.length;i++) {
			players[i%4][i/4]=poker[i];
		}
		
		
		for(int i=0;i<4;i++) {//用for迴圈的另一種寫法
		    System.out.println("以下為玩家"+(i+1)+"的牌");
			for(int j=0;j<13;j++) {
				System.out.print(players[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------發牌完成--------");
		
		//將數字換成撲克牌的花色和數字
		String[][] players_2=new String[4][13];
		
		String[] sults= {"黑桃","紅心","方塊","梅花"};//花色,分別對應0-12,13-25,26-38,39-51
		String[] values= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};//數字
		
		//理牌,練習用for each寫法
		for(int[] b:players) {
			Arrays.sort(b); 
			for(int bb:b) {
				System.out.print(sults[bb/13] + values[bb%13]+" ");
			}
			System.out.println();
		}

		System.out.println("----------理牌完成--------");

		
	}

}

