package tw.org.iii.mytest;

public class java27 {
	public static void main(String[] args) {
		String str1=new String("Brad");//與String str1="Brad"相同
		System.out.println(str1);
		Brad271 obj1=new Brad271();
		System.out.println(obj1);
		Brad271 obj2=new Brad271();
		System.out.println(obj2);
		System.out.println(obj1 == obj2);//兩個new出來的不同物件實體
		System.out.println(obj1.equals(obj2));
	}

}

class Brad271 {

	@Override
	public String toString() {
		return "Brad";
	}
}
