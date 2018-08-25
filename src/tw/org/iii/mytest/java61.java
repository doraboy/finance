package tw.org.iii.mytest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class java61 {
	public static void main(String[] args) {
		byte[] buf ="Hello, 資策會".getBytes();
		//要發送資料的插座,port號隨便就好
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(
					buf, buf.length,
					InetAddress.getByName("192.168.201.195"),
					8888);
			socket.send(packet);
			
			socket.close();
			
			System.out.println("資料傳輸完成");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
