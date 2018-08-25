package tw.org.iii.mytest;

import java.io.DataOutputStream;//將資料寫出
import java.io.FileOutputStream;

public class java53 {//將設定資料寫入.dat檔案
	public static void main(String[] args) {
		try {
			DataOutputStream dout = 
					new DataOutputStream(
							new FileOutputStream("dir1/brad.dat"));
			
			//將以下基本型別寫入資料.dat檔案
			dout.writeInt(4);
			dout.writeUTF("Brad");
			dout.writeBoolean(false);
			
			dout.flush();
			dout.close();
			System.out.println("Save OK");
		} catch (Exception e) {

		}

	}

}
