package tw.org.iii.mytest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class java26 extends JFrame{

	private JButton b1,b2;//java26這隻視窗程式擁有兩顆按鈕(物件實體)
	
	public java26() {//建構式
		super("我的視窗");
		
		b1 = new JButton("B1");
		b2 = new JButton("B2");

		setLayout(new FlowLayout(FlowLayout.CENTER, 80, 50));//不在意物件名稱,只需要這個物件實體
		add(b1);
		add(b2);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok");
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok2");
				
			}
		});


		
		setSize(640, 480);//父父類別window所擁有
		setVisible(true);//父父類別window所擁有
		setDefaultCloseOperation(EXIT_ON_CLOSE);//父類別所JFrame擁有
	}
	
	public static void main(String[] args) {
		new java26();

	}

}
