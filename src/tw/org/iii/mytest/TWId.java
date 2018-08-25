package tw.org.iii.mytest;

public class TWId {
	static final String letters= "ABCDEFGHJKLMNPQRSTUVXYWZIO";//首字大寫字母作轉換並拆解
    //以上宣告適用於本程式碼全域,且為不變(final)
	
	//以下為屬性
	private String id;
	
	//以下為建構式
	TWId(){
		this((int)(Math.random()*2)==0);//this代表呼叫本類別的建構式
	}//傳入boolean 故呼叫下面那一個建構式
	
	TWId(boolean isMale){
		this(isMale,(int)(Math.random()*26));//呼叫第24行建構式
	}	
	
	TWId(int area){
		this((int)(Math.random()*2)==0,area);//呼叫第24行建構式
	}
	
	
	TWId(boolean isMale, int area){
		//super();//呼叫並建立父類別物件實體,可省略
		String i1 = letters.substring(area,area+1);
		String i2 = isMale?"1":"2";
		//寫法1:
//		String newid=i1+i2+ //字串相加為字串 
//				(int)(Math.random()*10)+ //字串加整數還是字串
//				(int)(Math.random()*10)+
//				(int)(Math.random()*10)+
//				(int)(Math.random()*10)+
//				(int)(Math.random()*10)+
//				(int)(Math.random()*10)+
//				(int)(Math.random()*10);
		//寫法2:
		String newid = i1.concat(i2)
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)));
		for (int i=0; i<=9; i++) {
			if (checkId(newid+i)) {
				this.id = newid + i;
				break;
			}
		}
	}

	static TWId createTWId(String id){//使用者自行輸入任意身分證字號
		if(checkId(id)) {//檢查通過
			return new TWId(id);//才呼叫下方private建構式
		}else {
			return null;
		}
	}
	private TWId(String id){
		this.id=id;
	}
	
	
	
	
   //以下為方法
	
	//static方法:內容不涉及本類別任何物件的存在(不能直接呼叫下方的m1方法,未建立實體物件)
	//static方法,只能呼叫static的方法和物件
	static boolean checkId(String id) {//類別級別擁有的方法,內容不會涉及到this
	//1.長度為10
	//2.第一碼為大寫字母
	//3.第二碼為1或2
	//4.第三碼後全為數字
		boolean isRight = false;
		
		//System.out.println("id長度"+id.length());
		//System.out.println("第5個字元是"+id.charAt(5));
		
//		//寫法1:使用正規表示法matches()判斷身分證字號(尚未驗證)
//		if(id.matches("^[A-Z][12][0-9]{8}$")) {
//			isRight = true;
//		}
		
        //寫法2:自己寫,不用現有api(尚未驗證)
		char[] id2=id.toCharArray();//將String型態的id轉為char array
		//System.out.println("最後一碼(char值)為"+(int)id2[9]);	//0-9對應到char碼為48-57	
		if(id.length()==10 && ((int)id2[0]>=65 && (int)id2[0]<=90)//判斷最前面2個字元
			&& ((int)id2[1]==49 || (int)id2[1]==50)) {//前兩碼正確才會變true
			isRight = true;
			
			for(int i=2;i<10;i++) {//判斷後面8碼是否有非0-9數字,若有則變false
				if ((int)id2[i]<48 || (int)id2[i]>57) isRight = false;
			}
		}
		
		//開始驗證
		int n12 = letters.indexOf(id.charAt(0)+10);
		int n1 = n12 / 10;
		int n2 = n12 % 10;
		int n3 = Integer.parseInt(id.substring(1,2));//substring將字串切割
		int n4 = Integer.parseInt(id.substring(2,3));//再利用Integer.parseInt()
		int n5 = Integer.parseInt(id.substring(3,4));//將字串1-9轉換成int數字1-9
		int n6 = Integer.parseInt(id.substring(4,5));
		int n7 = Integer.parseInt(id.substring(5,6));
		int n8 = Integer.parseInt(id.substring(6,7));
		int n9 = Integer.parseInt(id.substring(7,8));
		int n10 = Integer.parseInt(id.substring(8,9));
		//int n11 = Integer.parseInt(id.substring(9,10));
		int n11 = (int)id2[9]-48;//另外一種寫法,與上行結果相同
		
		int sum=n1*1 +n2*9 +n3*8 +n4*7 +n5*6 +n6*5 +n7*4 +n8*3 +n9*2 +n10*1 +n11*1;

		isRight = sum % 10 ==0;
		
		return isRight;
	}
	
	String getId() {return id;}
	
	boolean isMale() {
		int n = Integer.parseInt(id.substring(1,2));
		if(n==1) return true;
		else  return false;
	}
	
	String getArea() {
		char[] id3=id.toCharArray();//將String型態的id轉為char array
		int n = (int)id3[0];
		if(n==76) return "是台中市";//L的char值為76
		else  return "不是台中市";
	}
	
//	boolean m1(String id) {
//		System.out.println("ok");
//		checkId("sa");//本行ok,因為static的方法為m1同類別,可以任意呼叫
//		return true;
//	}

}
