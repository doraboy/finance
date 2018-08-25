package dora.finance;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HttpsURLConnection;


public class YahooFinance {//取得網頁原始碼訊息(文字訊息),可網路爬蟲
	public static double now_price=-1;
	public static String symbol[] = new String[1];
	public static int counter = 1;
	public static void main(String[] args) {
		
		symbol[0] = "BTC-USD";
		
//		symbol[0] = "^SOX";
//		symbol[1] = "LRCX";
//		symbol[2] = "AMAT";
//		symbol[3] = "BTC-USD";
//		symbol[4] = "^DJI";
		
		Timer timer = new Timer(false);
		MyTask myTask  = new MyTask();
		StopTimer stopTask  = new StopTimer(timer);
		timer.schedule(myTask, 1*1000, 5*1000);
		timer.schedule(stopTask, 50*1000);

	}
	

}


class getNowPrice extends Thread{

	private String line, line2, line3 ,line4;
	private int point_value, point_value2, point_value3, 
				point_value4, point_value5, index;
	double now_price, previous_price;
	
	public getNowPrice(int index){this.index = index;};
//	public void setIndex () {
//		
//}
//	
	@Override
	public void run() {
		point_value = point_value2 = point_value3 = -1;
		point_value4 = point_value5 = -1;
		now_price = previous_price = -1;
		line  = null;
		
		try {
			//URL包含通訊協定(例如http)
			URL url = new URL("https://finance.yahoo.com/quote/"+YahooFinance.symbol[index]);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.connect();
			//一次性連接取得原始碼
			
			//文字訊息,故用串接傳輸bytes
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);//加上這個可以一次讀一列
			
			point_value = point_value2 = point_value3=-1;
		
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				line3 = line;
				point_value = line.indexOf("},\"currency\":\"USD\",\"regularMarketPrice\":{\"raw\":");
				if(point_value!=-1)
				{
					line2 = line.substring(point_value, point_value+75);
					point_value2 = line2.indexOf("\":{\"raw\":");
					point_value3 = line2.indexOf(",\"fmt\":\"");
					now_price =  Double.parseDouble(line2.substring(point_value2+9, point_value3));
				}
				
				point_value4 = line3.indexOf("regularMarketPreviousClose");
				if(point_value4!=-1)
				{
					line4 = line3.substring(point_value4+35, point_value4+55);
					point_value5 = line4.indexOf(",\"fmt");
					if(point_value5!=-1) {previous_price =  Double.parseDouble(line4.substring(0, point_value5));}
				}
			}
			br.close();	
		} catch (Exception e) {System.out.println(e);}

		
		
		System.out.println(YahooFinance.symbol[index]+":"+now_price+" "+previous_price);
	}
		
}


class MyTask extends TimerTask{
	@Override
	public void run() {
		System.out.println("第"+YahooFinance.counter+"次:");
		
		for(int i=0;i<YahooFinance.symbol.length;i++) {
			getNowPrice g1 = new getNowPrice(i);
			g1.start();
		}
		YahooFinance.counter++;
	}
}

class StopTimer extends TimerTask{
	Timer timer;
	public StopTimer(Timer timer) {this.timer = timer;}
	@Override
	public void run() {
		timer.cancel();
		//以下這個方法也行
		//System.exit(0);		
	}

}
