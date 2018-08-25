package tw.org.iii.mytest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class java60 {
	public static void main(String[] args) {
		
		while(true) {
			byte[] buf = new byte[1024];
			//盡量設定>1024 ,當然要小於port號上限65535
			try {//建立接收方的資料插座socket
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				//System.out.println("Before:");
				socket.receive(packet);	
				//System.out.println("After:");
				socket.close();
				
				byte[] data = packet.getData();
				int len = packet.getLength();
				InetAddress ip = packet.getAddress();
				String mesg = new String(data,0,len);
				
				System.out.println(ip.getHostAddress()+" : "+len+" : "+mesg);
				
				if(mesg.equals("stop")) {
					System.out.println("will stop");
					break;
				}
				
			} catch (IOException e) {
				System.out.println(e);
				break;
			}
		
		}
	}

}
