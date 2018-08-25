package tw.org.iii.mytest;

import java.io.File;//File類別不涉及檔案內容的修改
import java.io.IOException;

public class java45 {

	public static void main(String[] args) {
		File f1 = new File("./dir1");//本路徑下"./其實可省略
		File f2 = new File("dir2");
		File f3 = new File("dir3");
		File f4 = new File("dir3/dir4/dir5/dir6");
		File f5 = new File("dir3/dir4/dir5/dir6/file1");
		//物件實體作的出來,不代表該路徑一定存在
		//該物件實體只是要用來呼叫其擁有的方法來判斷而以
		

		
		if(f1.exists()) {
			System.out.println("f1 exist");
		}
		
		
		if(f3.exists()) {
			System.out.println("f3 exist");
		}else {
			f3.mkdir();//只建立單一目錄
		}
		
		if(f4.exists()) {
			System.out.println("f4 exist");
		}else {
			f4.mkdirs();//建立該目錄dir6及其所有父以上目錄
		}
		
		if(!f5.exists()) {//檔案不存在時,建立新空白檔案
			try {
				f5.createNewFile();
			}catch(IOException ie){
				System.out.println("XX");
			}
			
		}
		
		File f6 = new File("dir7");
		File f7 = new File("dir8/../dir1");
		File f8 = new File("dir3/dir4/../../dir1");
		File f9 = new File("dir7");
		System.out.println(f6 == f7);//false 不同物件實體
		System.out.println(f6.equals(f7));//false(實質相同,很沒意義) 
		System.out.println(f6.equals(f8));//false(實質相同,很沒意義)
		System.out.println(f6.equals(f9));//true
	}

}
