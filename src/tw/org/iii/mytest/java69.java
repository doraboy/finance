package tw.org.iii.mytest;

import org.json.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class java69 {//取得網頁開放資料JSON檔案,解析所需資訊出來

	public static void main(String[] args) {
		try {
			//URL包含通訊協定(例如http)
			URL url = new URL("http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			//一次性連接取得原始碼
			
			//文字訊息,故用串接傳輸bytes
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);//加上這個可以一次讀一列
			
			String line; StringBuffer sb = new StringBuffer();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
	
			br.close();
			
			//解析JSON檔案內容
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}


	}
	
	private static void parseJSON(String json) {
		try {
			JSONArray root = new JSONArray(json);
			for (int i = 0; i<root.length(); i++) {
				JSONObject obj = root.getJSONObject(i);
				String name = obj.getString("Name");
				String addr = obj.getString("Address");
				String tel = obj.getString("Tel");
				System.out.println(name+":"+addr+":"+tel);

			}
			
		}catch (Exception e){
			System.out.println(e);
		}
		
	}

}
