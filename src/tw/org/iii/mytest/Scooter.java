package tw.org.iii.mytest;

public class Scooter extends Bike{//繼承Bike類別 ,class xx extends(延伸) 父類別
	//任何一個類別一定都有一個父類別(也只能有一個)
	//但最源頭的類別為Object,只有Object沒有父類別
	//若對外沒有宣稱父類別,代表預設父類別為Object,即 extends Object可省略
	//只有屬性和方法(非private)可以被繼承,建構式不會被繼承
	//只要執行本類別,就會自動創造一個父類別的物件實體,在父類別那邊執行
	//超重要:任何物件只要被new出來,其類別及所有祖宗所有類別物件實體都會存在於記憶體中
	private int gear;//定義屬性:檔位
	
	void changeGear(int gear) {
		this.gear = gear;
	}
	
	int getGear() {//取得檔位的方法
		return gear;
	}
	
	void upSpeed(){
		super.upSpeed();//呼叫父類別的upSpeed()
		speed *= gear;
	}	
	
	double getSpeed(){//重新定義測速器方法:專有名詞:Override
		//Override:方法名稱要一樣,且傳回參數型別及個數都要一樣
		//以上限基本型別(含void)
	
		return speed+2;//父類別speed參數為開放,重新定義,ok
		//若父類別沒開放(privte),則無法取得speed,錯誤
		//灌水的測速器,速度自動+2
	}
}
