package tw.org.iii.mytest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java65 {//建立TCP傳輸檔案的接收端,傳輸非文字資料(二進制檔案)


	public static void main(String[] args) {
		try {
			
			//建立接收server
			ServerSocket server = new ServerSocket(7777);
			//在該server中建立一個資料插座
			Socket socket = server.accept();
			
			//宣告輸出檔案串流,輸出道到檔案iii.jpg
			FileOutputStream fout = new FileOutputStream("dir3/iii.jpg");
			
			//得到該插座的資料輸入串流
			InputStream in = socket.getInputStream();
			int len; byte[] buf = new byte[4096*1024];//一次讀4MB
			while((len = in.read(buf)) != -1) {
				fout.write(buf,0,len);//將資料串流以4M為buffer,全部寫入檔案iii.jpg
			}
			in.close();//關閉輸入串流(有開就要關)
			
			fout.flush();//將所有資料寫出
			fout.close();//關閉輸出檔案串流
			
			server.close();//關閉伺服器
			System.out.println("Receive OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
