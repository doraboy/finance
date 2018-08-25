package tw.org.iii.mytest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class YahooFinance {//取得網頁原始碼訊息(文字訊息),可網路爬蟲
	public static double now_price=-1;
	public static String symbol[] = new String[4];
	
	public static void main(String[] args) {
			symbol[0] = "^SOX";
			symbol[1] = "LRCX";
			symbol[2] = "AMAT";
			symbol[3] = "btc-usd";


			
		
		for(String s:symbol) {
			getNowPrice g1 = new getNowPrice(s);
			g1.start();
		}
	}
	

}


class getNowPrice extends Thread{
	private String symbol;
	private String line, line2, line3 ,line4;
	private int point_value, point_value2, point_value3, 
				point_value4, point_value5, point_value6;
	double now_price, previous_price;
	
	public getNowPrice(String symbol){
		this.symbol = symbol;
		point_value = point_value2 = point_value3 = -1;
		point_value4 = point_value5 = point_value6 = -1;
		now_price = previous_price = -1;
	};
	@Override
	public void run() {
		try {
			//URL包含通訊協定(例如http)
			URL url = new URL("https://finance.yahoo.com/quote/"+symbol);
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
				}

				point_value4 = line3.indexOf("regularMarketPreviousClose");

				if(point_value4!=-1)
				{
					line4 = line3.substring(point_value4+35, point_value4+55);
					System.out.println(line4);
//					point_value2 = line2.indexOf("\":{\"raw\":");
//					point_value3 = line2.indexOf(",\"fmt\":\"");
				}
				
				//"},"currencySymbol":"$","regularMarketPreviousClose":{"raw":

			}
			br.close();	
		} catch (Exception e) {System.out.println(e);}

		now_price =  Double.parseDouble(line2.substring(point_value2+9, point_value3));
		
		System.out.println(symbol+":"+now_price+" "+previous_price);
	}
		
}//內部類別getNowPrice{}結束
