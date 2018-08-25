package tw.org.iii.mytest;

import java.io.FileOutputStream;
import java.io.IOException;

public class java47 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("dir1/brad4.txt",true);//若沒指定append的boolean,則預設為false(自動清空後才寫入)
			fout.write("Hello,World\n".getBytes());//超重要,字串物件實體換byte使用getBytes()
			//若檔案不在,自動創建新檔
			fout.write("123\r\n4567\r\n".getBytes());

			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (IOException e) {
			//System.out.println(ie);
		}

	}

}
