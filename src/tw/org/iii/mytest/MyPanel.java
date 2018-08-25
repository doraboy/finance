package tw.org.iii.mytest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener{
	//宣告(對外宣稱)這個類別自己就是MouseListener
	private int x,y;
	Color color;
	
	public MyPanel() {
		color = Color.BLUE;
	}
	
	public MyPanel(int x,int y) {
		this.x=x;this.y=y;
		color = Color.red;
		System.out.println("MyPanel()");
		addMouseListener(this);//下方必須實作MouseListener的方法
	}
	
	
	//作業:滑鼠點哪裡,紅圈中心出現哪裡
	//但自己練習寫個MouseListener
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("paint");
	}
	
	@Override
	protected void paintComponent(Graphics g) {//這個component因為有生命週期,故為自動呼叫
		super.paintComponent(g);
		System.out.println("paintComponent");
		Graphics2D g2d = (Graphics2D)g;//此物件實體被自動創造,一定存在
		g2d.setColor(color);
		g2d.fillOval(x,y, 80, 80);
		
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		//滑鼠按下去,重畫紅色圓
		System.out.println(e.getX()-40);
		System.out.println(e.getY()-40);
		System.out.println("A");
		x=e.getX()-40;
		y=e.getY()-40;
		repaint();//繼承至JPanel的方法
		
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


