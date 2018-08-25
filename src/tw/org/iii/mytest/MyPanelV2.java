package tw.org.iii.mytest;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanelV2 extends MyPanel {
	public MyPanelV2() {//建構式沒有在繼承的,
		super(100,100);//add父類別MyPanel的MouseListener
		addMouseListener(new MyMouseListener());//add子類別自己的MouseListener
	}
	//建構式的目的:1.完成物件實體初始化
	//             2.確保該物件實體的祖宗八代全都在這裡面存在


	//內部類別,可直接存取外部類別的屬性和方法
	private class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("B");
			color = Color.GREEN;
			repaint();//繼承外部類別MyPanel的方法(從JPanel繼承來)
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

