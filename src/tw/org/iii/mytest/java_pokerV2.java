package tw.org.iii.mytest;

public class java_pokerV2 {
	public static void main(String[] args) {
		//洗牌:一維陣列
		int poker[]=new int[52];//0-12,13-25,25-38,38-51代表四種花色
		boolean isRepeat;
		int temp;
		
		for(int i=0;i<poker.length;i++) {			
	
			do {//至少做一次
			    temp=(int)(Math.random()*52);
			
			//檢查機制
			isRepeat=false;
			for(int j=0;j<i;j++) {
				if(poker[j]==temp) {
					isRepeat=true;
					break;
				}
			}
		}while(isRepeat);//若重複則重洗
		
		//出上面迴圈代表已經洗到不重複
		poker[i]=temp;
		System.out.println(poker[i]);
		
		
		}
		

		
		//發牌給四個人:二維陣列
		//理牌:照順序
		//攤牌

		

		
		
		
		
		
		
		
		
		
	}

}

