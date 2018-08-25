package tw.org.iii.mytest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//序列化是將物件轉成資料存入
public class java56 {//解序列化,非常重要

	public static void main(String[] args) {
		try(ObjectInputStream oin =
				new ObjectInputStream(
						new FileInputStream("dir1/brad.object"))){
			Object obj = oin.readObject();//解序列化
			//這裡已經自動建立物件實體,其骨子裡已經是Student類別
			
			//類別Student的資訊已經存在brad.object檔案中,所以可以識別
			Student s1 = (Student)obj;//Student類別的eng成績屬性沒被序列化,所以沒有存入(未計算)
			System.out.println(s1.calSum()+":"+s1.calAvg());//(90+24)/3.0=38.0
			
			//Bike b1 = (Bike)oin.readObject();
			System.out.println(s1.bike.getSpeed());
		
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
