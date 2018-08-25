package tw.org.iii.mytest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class java63 {//建立TCP傳輸的傳送端

	public static void main(String[] args) {
		try {
			Socket socket  = new Socket("192.168.201.195",9999);
			
			//抽象的類別,故用別人來建構自己的物件實體
			OutputStream out = socket.getOutputStream();
			out.write("資1\n策2\n會3".getBytes());
			out.flush();
			out.close();
			socket.close();
			System.out.println("OK1");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
