package tw.org.iii.mytest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java46 {

	public static void main(String[] args) {
		try {
			File source = new File("dir1/brad.txt");
			FileInputStream fin=new FileInputStream(source);
			//InputStream永遠只能讀byte,所以不適合讀文字資料
			//InputStream適合用來讀binary file
			
			byte[] b = new byte[(int)source.length()];
			fin.read(b);
			fin.close();
			System.out.println(new String(b));
			
			//寫法一
//			do{
//				temp = fin.read();//一次只能讀一個byte,讀完指標到下一個
//				if (temp==-1){
//					break;
//				}else {
//				System.out.println((char)temp);
//			  }
//			} while(true);
			
			//寫法二:先進行assign,再去判斷,較簡潔
//			while((temp = fin.read(b))!=-1) {
//				System.out.print(new String(b,0,temp));
//				//System.out.print((char)temp);
//			}

			//開檔案操作完,要記得關掉
			
		}catch (FileNotFoundException fe) {

		}catch (IOException fe) {

		}
		

	}

}
