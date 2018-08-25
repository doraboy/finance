package tw.org.iii.mytest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class java58 {

	public static void main(String[] args) {
		try(ObjectInputStream oin =
				new ObjectInputStream(
						new FileInputStream("dir1/brad2.object"))){
			Object obj = oin.readObject();//Brad572和Brad573已經被序列化,解序列化實已經創造出這兩者的物件實體
			//但Brad571沒有序列化,所以必須自動呼叫Brad571的建構式來創出Brad571物件實體(祖宗八代的物件實體都要存在)
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
