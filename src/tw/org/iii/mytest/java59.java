package tw.org.iii.mytest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class java59 {

	public static void main(String[] args) {
		try {
			//HostName(主機名稱,FQDN):主機名稱.Domain
			InetAddress ip = InetAddress.getByName("www.microsoft.com");
			System.out.println(ip.getHostAddress());


		} catch (UnknownHostException e) {
			System.out.println(e);
		}

	}

}
