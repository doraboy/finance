package tw.org.iii.mytest;

import java.io.File;

public class java48 {
	public static void main(String[] args) {
		File f1 = new File("dir1/brad4.txt");
		File f2 = new File("dir2/brad5.txt");
		if(f1.renameTo(f2)) {//換根目錄,不同分割區也行
			System.out.println("OK");
		}else {
			System.out.println("XX");			
		}
	}

}
