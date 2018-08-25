package tw.org.iii.mytest;

public class java28 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();//是何用在字串內容經常變動時
		//StringBuffer用法與 StringBuilder原則上相同
		
		System.out.println(sb1);//物件型別印toString(記憶體位置),基本型別印其值
		//override toString印其值
		System.out.println(sb1.capacity());//容量
		System.out.println(sb1.length());//字串長度
		
		StringBuffer sb2 = sb1.append("123456789012345");
		System.out.println("sb1:"+sb1);
		System.out.println("sb1:"+sb1.length());
		System.out.println("sb1:"+sb1.capacity());
		System.out.println("sb2:"+sb2);
		System.out.println("sb2:"+sb2.length());
		System.out.println("sb2:"+sb2.capacity());
		System.out.println(sb1==sb2);//sb2和sb1指向同一個物件實體
		
		sb1.append("6");
		System.out.println("sb1:"+sb1);
		System.out.println("sb1:"+sb1.length());
		System.out.println("sb1:"+sb1.capacity());
		
		sb1.append("7");//字串容量會自動增加,不需要去煩惱這個
		System.out.println("sb1:"+sb1);
		System.out.println("sb1:"+sb1.length());
		System.out.println("sb1:"+sb1.capacity());
		
		//因為StringBuffer的方法是傳回自己物件的實體,才可以如下方連續呼叫方法使用
		sb1.append("8").append("9").replace(0, 3, "Brad").append("OK");
		System.out.println(sb1);
		
		Brad281 obj1=new Brad281();
		System.out.println(obj1.calSum());//預設s1,s2,s3皆為0
		obj1.setS1(12)
			.setS2(34)
			.setS1(48);//後面覆蓋的48前面的12
		System.out.println(obj1.calSum());//48+34+0=82
		
		StringBuffer sb3 = new StringBuffer();
		StringBuffer sb4 = new StringBuffer();
		Bike b1=new Bike();
		System.out.println(sb3.equals(sb4));//no override => same as == (對比記憶體位址)
		System.out.println(sb3.toString().equals(sb4));//false :String比StringBuffer
		//物件型別不相同且非直系血親,無法直接互轉(String,StringBuffer)
		//相比值一定是false
		System.out.println(sb3.toString().equals(b1));
		//與上面一句敘述句相同,無法直接互轉作比較(Bike和String)

		System.out.println(sb3.toString().equals(sb4.toString()));
		//String和String相同型別,可以比對,故為true
		
		
	}

}

class Brad281 {
	int s1,s2,s3;
	Brad281 setS1(int s1) {this.s1=s1;return this;}//將物件實體傳回
	Brad281 setS2(int s2) {this.s2=s2;return this;}
	Brad281 setS3(int s3) {this.s3=s3;return this;}
	int calSum(){return s1+s2+s3;}
}
