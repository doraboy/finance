package tw.org.iii.mytest;

import java.io.FileInputStream;//input file's byte streams
//An InputStreamReader is a bridge from byte streams to character streams
import java.io.InputStreamReader;
import java.io.BufferedReader;//接收 character streams

public class java52 {//模擬網際網路的串流(進行串接)
	public static void main(String[] args) {
		try {
			
			FileInputStream fin = new FileInputStream("dir1/book1.csv");//讀檔進來
			InputStreamReader isr = new InputStreamReader(fin,"big5");//以big5編碼解析資料
			BufferedReader reader = new BufferedReader(isr);
			
			String line = null;
//BufferedReader的readLine()方法:傳回一整行的文字(不包含換行字元)
			while((line = reader.readLine())!=null) {
				String[] data = line.split(",");//指定用","隔開
				String name = data[0];	
				String tel = data[1];
				String addr = data[2];
				System.out.println("Name="+name);
				//System.out.println(line);
			}
			
			fin.close();
		} catch (Exception e) {

		}

	}

}
