package tw.org.iii.mytest;

import java.io.DataInputStream;//讀取資料
import java.io.FileInputStream;

public class java54 {//讀取.dat檔案
//型別和順序不能改變
	
	public static void main(String[] args) {
		//try() {}...catch... try完可自動關閉檔案,括號內要符合可自動關閉介面
		try(DataInputStream din = 
				new DataInputStream(
						new FileInputStream("dir1/brad.dat"))) {
			int stage=din.readInt();
			String username = din.readUTF();
			boolean isSound = din.readBoolean();
			
			System.out.println(stage+"(關卡)"+username+"(玩家姓名)"+isSound+"(音效是否開啟)");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
