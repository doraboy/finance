package tw.org.iii.mytest;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

//網路不同網站抓多檔案,利用多執行緒平行處理
public class java78 {

	public static void main(String[] args) {
		System.out.println("Start:"+ System.currentTimeMillis());
		String[] urls= {
			"",
			"",
			"",
			"",		
		};
		String[] targets = {"brad7801.png","brad7802.jpg","brad7803.jpg","brad7804.jpg"};
		for (int i=0; i<urls.length;i++) {
			//每個抓檔動作開出一個新的thread,作平行處理(較快速)
			//要做的事情還是定義在run()裡面
			new FetchURLImage(urls[i], targets[i]).start();
			//run為該物件的普通方法,沒生命表現,一個接著一個執行(慢很多)
			//new FetchURLImage(urls[i], targets[i]).run();
		}
	}

}

class FetchURLImage extends Thread {
	private String url, target;
	public FetchURLImage(String url,String target) {
		this.url = url;
		this.target = target;
	}
	
	@Override
	public void run() {
		try {
			URL source = new URL(url);
			HttpURLConnection conn = 
					(HttpURLConnection)source.openConnection();
			conn.connect();
			//輸入串流物件bin
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			//輸出串流物件fout
			FileOutputStream fout = new FileOutputStream("dir1/"+target);
			//宣告緩衝資料區4
			byte[] buf = new byte[4096*1024];int len = 0;
			//當輸入資料還有時(len!=-1),將資料從輸入串流bin讀到放在緩衝區buf內
			while((len = bin.read(buf))!=-1) {
				//利用輸出串流物件fout 將buf資料寫入
				fout.write(buf,0,len);
			}
			fout.flush();
			fout.close();
			bin.close();
			System.out.println(target + ":OK");
			
		} catch (Exception e) {
			System.out.println(target + ":ERROR");
		}
		System.out.println(System.currentTimeMillis());
	}
}
