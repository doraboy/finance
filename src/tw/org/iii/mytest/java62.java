package tw.org.iii.mytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class java62 {//建立TCP傳輸的接收端server

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept(); //three-way handshaking TCP的三方交握
			
			//抽象的類別,故用別人來建構自己的物件實體
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);//加上這個可以一次讀一列
			
			int len; String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			server.close();
			System.out.println("收到訊息");
			
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
