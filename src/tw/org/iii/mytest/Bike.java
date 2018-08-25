package tw.org.iii.mytest;//代表路徑

import java.io.Serializable;

public class Bike  implements Serializable{//對外宣稱類別(通常首字大寫),括號內為類別的實作
	/*
	 *類別的實作內容(has-a)如下:
	 *1.建構式:只有執行一次(初始化),名稱跟類別名稱必相同
	 *        建構式可以有多個,每個都不同,讓使用者選擇使用
	 *        同名異式:Overload
	 *2.靜態:這個類別所擁有的東西:屬性Field
	 *       (即不同物件間,最大的差異在於屬性,最重要)
	 *       屬性一般要封裝起來(private),避免使用者直接存取
	 *3.動態:方法(Method),方法為搭配屬性來設計處理的
	 *       方法是用來修改(操作)屬性值的
	 *       方法則不一定為private
	 *4.屬性和方法有以下四種修飾詞
	 *  (1)public:大家都可存取
	 *  (2)protected:該類別外是唯讀
	 *  (3)沒有:在同路徑(package)下跟public一樣,可以任意存取
	 *  (4)private:只有該類別可存取
	 *5.overload:同名異式,方法和建構式都可能有
	 */
	double speed;//private代表該屬性只能在該類別中被存取
	
	Bike(){
		speed=4.2;
	}
	
	Bike(double speed){//當本類別參數跟外面傳入參數名稱相衝時
		this.speed=speed;//this代表為本類別的物件實體
	}
	
	
	void upSpeed(){//方法:加速度,不需要參數故用void
		speed = speed==0?1:speed*1.4;//若速度為0,代表初次呼叫
	}
	
	void upSpeed(int gear){//方法:加速度,傳入檔位1-10,對應到1.1~2.0倍的加速度
		speed = speed==0?1:speed*(1+(double)gear/10);//若速度為0,代表初次呼叫
	}
	
	void downSpeed(){//方法:減速度
		speed = speed==1?0:speed*0.7;//若速度為0,不需減速度
	}
	
	double getSpeed(){//方法:測速器
		return speed;//return的是值,別人看不到變數speed
	}
	
}
