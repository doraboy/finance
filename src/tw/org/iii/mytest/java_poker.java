package tw.org.iii.mytest;

public class java_poker {
	public static void main(String[] args) {
		//洗牌:一維陣列
		int poker[]=new int[52];//0-12,13-25,25-38,38-51代表四種花色
		for(int i=0;i<poker.length;i++) {
			int temp=(int)(Math.random()*52);
			
			//檢查機制
			boolean isRepeat=false;
			
			for(int j=0;j<i;j++) {
				if(poker[j]==temp) {
					isRepeat=true;
					break;
				}
			}
			
			if(!isRepeat) {//不重複 !false=true
				poker[i]=temp;
				System.out.println(poker[i]);
			}else {
				i--;
			}
		}
		//發牌給四個人:二維陣列
		//理牌:照順序
		//攤牌

		

		
		
		
		
		
		
		
		
		
	}

}

