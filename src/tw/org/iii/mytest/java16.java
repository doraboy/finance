package tw.org.iii.mytest;

public class java16 {

	public static void main(String[] args) {
		/*
		 *Array 
		 * 1.Type為固定
		 * 2.Length固定
		 * 3.Array是一個物件(object)
		 */
		int[] a;//單純宣告(未給值,不能使用)
		a = new int[4];//new為宣告物件並初始化,長度宣告為4個,永遠從0開始
		//在Java語言中,等號一成立,絕對有初始化(有值)
		//byte,shotr,int,long初始值為0
		//float,double初始值為0.0
		//boolean初始值為false,String初始值為null
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		int[] b=new int[3];//皆為初始值
		//int[] c=new int[] {1,2,3,4,5};
		int[] c= {1,2,3,4,5};//這種簡略寫法只限宣告時同時給值
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i]);
		}
		
		int[] e;
		int[] f;
		e=new int[] {1,2,3,4,5};
		//f = {1,2,3,4,5} //本行錯誤,不能用簡略寫法

		
	}

}
