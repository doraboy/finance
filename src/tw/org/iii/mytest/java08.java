package tw.org.iii.mytest;

import javax.swing.JOptionPane;

public class java08 {

	public static void main(String[] args) {
		//year % 4==0 閏年 
		//但year % 100==0 非閏年 (但被year % 400==0 又是閏年)
		//int year = (int)(Math.random()*+1753);
		String a1 = JOptionPane.showInputDialog("請輸入西元年份(1753~)");
		//從1753年開始 排除1752年(含)以前的萬年曆閏年錯誤計算
		int year=Integer.parseInt(a1);//String轉換為int
		
		if(year % 4!=0)//不被4整除
		{System.out.println("非閏年");}	
		else //被4整除
		{
		 if(year % 100==0)//被100整除
		 {
			 if(year % 400==0)//被400整除
			 {System.out.println("閏年");} 
			 else  //不被400整除
			 {System.out.println("非閏年");}
		 } 
		 else//不被100整除
		 {System.out.println("閏年");}
		}
	}
}
