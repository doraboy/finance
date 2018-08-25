package tw.org.iii.mytest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class java85 {
	public static void main(String[] args) {
		//Date類別不建議使用,
		Date date = new Date();
		//建議使用Calendar,方法很多,處理完再轉輸出即可
		Calendar calendar = Calendar.getInstance();
		System.out.println(date);
		System.out.println(calendar);
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(df.format(date));
		
		//format()要的參數是Date類別物件實體
		System.out.println(df.format(calendar.getTime()));
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;//MONTH從0開始算
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "/" + month + "/" + day);
		
		calendar.add(Calendar.DATE, 14);//往後14天
		System.out.println(df.format(calendar.getTime()));
		
		calendar.add(Calendar.WEEK_OF_YEAR, -2);//到退兩周
		System.out.println(df.format(calendar.getTime()));
		
	}

}
