package tw.org.iii.mytest;

import java.io.IOException;
import java.text.ParseException;

public class java43 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
	try {//既然Bird類別有對外宣稱其方法setLeg()有可能拋出例外
		 //這邊就一定要用try...catch來做事前(預防)處理
		b1.setLeg(2);
	}catch(ParseException e){
		
	}catch(IOException e){
		
	}//既然Bird類別有宣告兩種可能例外,則寫法一是兩種都要處理
	
	//寫法二,直接用大範圍宣告,
//    catch(Exception e){
//		
//	}//
	


	}

}

class Bird{
	private int leg;
	void setLeg(int leg) throws ParseException, IOException {//對外部使用者來說,只看的到宣告部分
		//所以在宣告時就要對外宣稱有拋出(throws)兩種例外的可能
		if(leg<0) {//異常處理
			throw new ParseException("XXX",3);//對外宣稱例外範圍一定要大於等於實際拋出的例外範圍
			//這樣才能應付較多種情況(反過來寫會編譯錯誤)
		}else if(leg>2) {
			throw new IOException();
		}else {
			this.leg = leg;
		}
		
	}
}

class BirdV2 extends Bird{
	@Override
	void setLeg(int leg) throws ParseException, IOException{
	//子類別override拋出的例外,一定要小於等於父類別的範圍
	//如果大於的話,那就換個名稱,不要用override
		super.setLeg(leg);
		System.out.println("XXX");
	}
}
