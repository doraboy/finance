package tw.org.iii.mytest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class java66 {//取得網頁原始碼訊息(文字訊息),可網路爬蟲

	public static void main(String[] args) {
		try {
			//URL包含通訊協定(例如http)
			URL url = new URL("https://www.bradchao.com/");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.connect();
			//一次性連接取得原始碼
			
			//文字訊息,故用串接傳輸bytes
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);//加上這個可以一次讀一列
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}


	}

}
