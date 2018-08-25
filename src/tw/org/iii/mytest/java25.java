package tw.org.iii.mytest;

public class java25 {

	public static void main(String[] args) {
		
		System.out.println("------建立b1物件實體-----");
		//java251 b1 = new java251();//錯誤:沒傳參數
		java251 b1 = new java251(2);
		//java251 b1 = new java251();//沒有無傳參數建構式
		
		System.out.println("------建立b2物件實體(無傳參數)-----");
		java252 b2 = new java252();
		
		
		System.out.println("------建立b3物件實體(有傳參數)-----");
		java251 b3 = new java251(2);
		System.out.println("----------------");	
		
		System.out.println(b1 == b3);//兩個new,不同物件實體,false
		System.out.println(b1.equals(b3));//最源頭的類別Object
		//Object其equals比的是兩個物件實體的記憶體位置
		//故上述兩者在這邊相同意思,皆為false

	}

}

//所有類別都會有建構式,若沒寫,則預設為其父類別的無傳參數建構式
//若有寫,則不再預設有無傳參數建構式
class java251 {//同一個原始碼中定義的第二個類別
	private int a;
	java251(int a){
		//suepr();//"第一道敘述敘必為呼叫產生父類別的物件實體,可省略
		System.out.println("已執行類別java251的建構式java251()");
		this.a = a;
	}
	
	public int getA() {return a;}
	
	@Override //輔助開發者註解用,可有可無
	public boolean equals(Object obj) {

		return ((java251)obj).getA()==a;//因為作override,傳回參數型別要一樣
	}
	
}

class java252 extends java251{//同一個原始碼中定義的第二個類別
	java252() {
		//super();//預設值,但這裡錯誤,其父親沒有無傳參數建構式
		super(3);
		//不寫super()只能是以下兩種:
		//1.super(參數);
		//2.this();
		System.out.println("已執行類別java252的建構式java252()");

	}
	

}



