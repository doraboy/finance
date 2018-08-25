package tw.org.iii.mytest;

public class java18 {

	public static void main(String[] args) {
		int[][] a=new int[2][3];//宣告並初始化,特例:2x3陣列
		int[][] b=new int[2][];
		b[0]=new int[3];
		b[1]=new int[2];
		
		//記憶體為1維,故只會看指向位置數
		System.out.println(a.length);//2
		System.out.println(a[0].length);//3
		System.out.println(b[1].length);//2
		System.out.println("---------------");
		
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++) {
				System.out.println(b[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		int[] c= {1,3,4,7,3};//一維陣列
		for(int brad:c){//for each寫法,尋訪c中所有元素的值,不在意順序和長度
				System.out.println(brad+" ");
		}
		System.out.println("---------------");
		
		for(int[] bb:b){//二維陣列=一維陣列中還有一維陣列
			for(int bbb:bb){
			System.out.print(bbb+" ");
			}
			System.out.println();
	    }
		
		
	}

}
