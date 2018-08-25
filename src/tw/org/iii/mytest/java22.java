package tw.org.iii.mytest;

public class java22 {

	public static void main(String[] args) {
//		TWId.checkId("aa");//有static為類別級別的方法, 無須物件,可直接呼叫方法
//		
//		TWId id1=new TWId();
//		id1.m1("aaa");//須先建立物件才能實現該方法
//		
		String b="0910-256966";
		if(b.matches("^[0][9][0-9]{2}[-][0-9]{6}$")) {//正規表示法判斷手機號碼
			System.out.println("手機號碼OK");
		}else {
			System.out.println("手機號碼XX");
		}
		System.out.println("------------------------");
		
		
		if(TWId.checkId("A123456789")) {
			System.out.println("身分證字號ok!");
		}else {
			System.out.println("身分證字號error!");
		}
		System.out.println("------------------------");
		
		TWId id1= new TWId();
		TWId id2= new TWId(true);//指定男性
		TWId id3= new TWId(14);//指定區域
		TWId id4= new TWId(false,17);//指定女性及區域
		TWId id5= TWId.createTWId("A123456789");//自己指定身分證做驗證
		
		id5.isMale();
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		System.out.println(id5.getId());
		
		System.out.println(id5.getId()+"是否為男性:"+id5.isMale());//判斷是否為男性
		System.out.println(id5.getId()+"是否為台中市:"+id5.getArea() );//判斷是否為台中市
	
		
	
		


	}

}
