package tw.org.iii.mytest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class java67 {//取得網頁原始碼訊息(文字訊息),可網路爬蟲

	public static void main(String[] args) {
		try {
			URL url = new URL("https://s.yimg.com/ny/api/res/1.2/iTq9GvgHNYL5zK2au5bITQ--~A/YXBwaWQ9aGlnaGxhbmRlcjtzbT0xO3c9MTI3OTtoPTcyMA--/http://media.zenfs.com/zh-Hant-TW/homerun/udn.com/8f758b9d195f8caea99940ceecf461af");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.connect();
			//一次性連接取得原始碼
			
			FileOutputStream fout = new FileOutputStream("dir3/ok.jpg");
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] bur = new byte[4096];
			int len;
			
			while((len = bin.read(bur))!=-1) {
				fout.write(bur,0,len);
			}
			
			bin.close();
			fout.flush();
			fout.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}


	}

}
