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

public class java68 {//取得網頁檔案(只要是非文字的檔案皆為二進制檔案)

	public static void main(String[] args) {
		try {
			//利用pdfmyurl.com網站服務,將網頁轉成pdf
			URL url = new URL("https://pdfmyurl.com/?url=https://www.gamer.com.tw/");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.connect();
			//一次性連接取得原始碼
			
			FileOutputStream fout = new FileOutputStream("dir3/gamer.pdf");
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
