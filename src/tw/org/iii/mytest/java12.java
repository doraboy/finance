package tw.org.iii.mytest;

public class java12 {
	public static void main(String[] args) {
		byte a=10;//基本型別中只有byte,short,int,char可以放入switch
		//long,boolean,flaot,double都不可以放入switch
		
		switch(a) {
		case 1:System.out.println("1");break;
		case 10:System.out.println("10");break;
		case 'a':System.out.println("a");break;//char值為97
		case 'A':System.out.println("A");break;
		//case 97:System.out.println("1");break;//跟'a'重複,錯誤
		default:System.out.println("D");break;
		}
		
		//SE7之後 字串String可以放入switch,但case後面只能放字串作選擇
		String b="Brad";//常數
		switch(b) {
		case "B":System.out.println("1");break;
		//case 'B':System.out.println("1");break;//不能放char會錯誤
		case "Bradd":System.out.println("2");break;
		case "Brad":System.out.println("3");break;
		default:System.out.println("D");break;
		}

	}

}
