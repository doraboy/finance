package tw.org.iii.mytest;

import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.JOptionPane;

public class java04 {
	public static void main(String[] args) {
		String a1 = JOptionPane.showInputDialog("請輸入第一個數字");
		String a2 = JOptionPane.showInputDialog("請輸入第二個數字");
		System.out.println(a1+" sdf "+a2);
		
		int i1=Integer.parseInt(a1);
		int i2=Integer.parseInt(a2);
		System.out.println(i1+i2);
		
		String a3 = JOptionPane.showInputDialog("請輸入第三個數字");
		String a4 = JOptionPane.showInputDialog("請輸入第四個數字");
		int i3=Integer.parseInt(a3);//String轉換為int
		int i4=Integer.parseInt(a4);
		System.out.println(i3+"/"+ i4 +" = "+i3/i4+"......"+(i3 % i4));
		
	}

}
