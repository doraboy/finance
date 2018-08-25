package tw.org.iii.mytest;

public class java14 {
	
	public static void main(String[] args) {
		
		long start=System.currentTimeMillis();//傳回目前時間(毫秒),long型態數字
		//Unix紀元,從1970/1/1 0:0:0開始起算	
		
		for(int i=1;i<=100;i++) {
			boolean isPrime=true;
			for(int j=2;j<i/2;j++) {
				if(i%j==0) {
					isPrime=false;
					break;//被整除,非質數,脫離所在的迴圈
				}
			}
			System.out.print(i+(isPrime?"* ":"  "));
			//()? : 三元運算式,true執行前面,false執行後面
			
			if(i%10==0) System.out.println();
		}
		
		
		System.out.println("總執行時間(毫秒)為:"+(System.currentTimeMillis()-start));
	}

}
