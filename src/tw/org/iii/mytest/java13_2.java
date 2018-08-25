package tw.org.iii.mytest;

import javax.swing.JOptionPane;

public class java13_2 {
	public static void main(String[] args) {
		String a1 = JOptionPane.showInputDialog("請輸入乘法表最大數字");
		int max_number=Integer.parseInt(a1);

		for(int l=0;l<(max_number-1) / 4;l++){//4代表一列最多印4個數字
		for(int i=1; i<=max_number;i++ ){
			for(int j=l*4+2; j<=l*4+5;j++ ){
				System.out.print(j+" x "+i+" = "+i*j+"\t");	//\t代表tab鍵
			}
			System.out.println("");	
		}
		System.out.println("-----------------------------------------------------------");
		}
		
		if((max_number-1)%4!=0) {
		for(int i=1; i<=max_number;i++ ){
			for(int j=max_number-max_number%4+2; j<=max_number;j++ ){
				System.out.print(j+" x "+i+" = "+i*j+"\t");	//\t代表tab鍵
			}
			System.out.println("");	
		}
		System.out.println("-----------------------------------------------------------");
		}
		
		
		
		
		
	}

}
