package tw.org.iii.mytest;

public class java10 {
	public static void main(String[] args) {
		int month=(int)(Math.random()*12)+1;
		
		//以下為switch...case...用法,case後面的值不能重複,可做運算
		switch(month) {
		case 1:case 3*1:case 5:case 7:case 8:case 10:case 12:
			System.out.println(month+"月有31天");
			break;//跳脫switch區塊,若無則繼續執行下去,不管case值
		case 4:case 6:case 9:case 11:
			System.out.println(month+"月有30天");
			break;
		case 2:
			System.out.println(month+"月有28天(假設非閏年)");
			break;
		default://除錯用,怕前面計算出錯
			System.out.println("錯誤例外");
			//break;//default的break可省略,但後面若還有case則繼續執行下去
		case 168:
			System.out.println("錯誤例外(繼續執行)");
		}

	}

}
