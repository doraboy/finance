package tw.org.iii.mytest;

public class java15 {

	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			if(i%2==0) {//是否被2整除
				continue;//以下不做,回到迴圈,繼續下一圈
			}
			System.out.println(i);
		}
		
	System.out.println("---");
	
	brad:  //下標籤名為brad,後面緊跟迴圈敘述句 for,while do...while
	for(int i=0;i<10;i++) {
		for(int j=0;j<10;j++) {
			if(i+j>=10) {
				break brad;//直接脫離brad標籤的整個迴圈,continue亦同
			}
			System.out.println(i+" : "+j);
		}
	}
		

	}

}
