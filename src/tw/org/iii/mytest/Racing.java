package tw.org.iii.mytest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel[] lanes = new JLabel[8];
	private Horse[] horses = new Horse[8];
	private int rank = 0;
	
	public Racing() {
		super("賽跑遊戲");
		//9個rows跑道
		setLayout(new GridLayout(9, 0));
		
		go = new JButton("Go!");add(go);
		for(int i=0;i<lanes.length;i++) {
			lanes[i] = new JLabel((i+1)+".");
			add(lanes[i]);
		}
		
		go.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				newRound();	
				go.setEnabled(false);
			}
		});
		
		setSize(800,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void newRound() {
		rank = 1;
		for(int i=0;i<horses.length;i++) {
			lanes[i].setText((i+1)+".");
			horses[i] = new Horse(i);
			horses[i].start();
		}
	}
	
	private void stopGame() {
		for(int i=0;i<horses.length;i++) {
			horses[i].interrupt();
		}	
		go.setEnabled(true);
	}
	
	private class Horse extends Thread{
		int lane;
		public Horse(int lane) {this.lane = lane;}
		@Override
		public void run() {
			for(int i=0;i<100;i++) {
				lanes[lane].setText(lanes[lane].getText() + ">");
				
				if(i==99) {
					lanes[lane].setText(lanes[lane].getText() +" "+ rank++);		
					//第一名結束後,其他都不要跑
					stopGame();
				}
				try {
					Thread.sleep(30+(int)(Math.random()*270));
				} catch (Exception e) {
					break;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Racing();

	}

}
