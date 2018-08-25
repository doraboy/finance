package tw.org.iii.mytest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class java55 {//序列化是將物件轉成資料存入

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Student s1 = new Student(90, 60, 24, b1);
		System.out.println(s1.calSum()+":"+s1.calAvg());

		s1.bike.upSpeed();s1.bike.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());		
		
		try(ObjectOutputStream oout=
				new ObjectOutputStream(
						new FileOutputStream("dir1/brad.object"))) {
			oout.writeObject(s1);//把學生這個可序列化物件實體寫入資料
			
			//oout.writeObject(b1);
			
			System.out.println("Save OK");
		
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

//interface:Serializable 該介面沒有任何實作,只要宣告即可(該類別可序列化)
class Student implements Serializable{
	int ch;//Student類別的屬性皆預設為序列化
	transient int eng;//特別指定這個屬性不要序列化
	int math;
	Bike bike;//學生擁有腳踏車,但前提是腳踏車也要可序列化,
	Student(int ch, int eng, int math, Bike bike){
		this.ch=ch;this.eng=eng;this.math=math;
		this.bike = bike;
	}
	int calSum() {
		return ch+eng+math;
	}
	double calAvg() {
		return calSum()/3.0;
	}

	
}
