package dora.finance;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyView extends JPanel{
	private MyMouseListener mouseListener = new MyMouseListener();	
	//宣告一個空的資料結構,來存放點座標
	//畫多條線
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines = new LinkedList<>();
	private LinkedList<LinkedList<HashMap<String, Integer>>> recycle = new LinkedList<>();//線條的資源回收桶

	
	public MyView() {
		setBackground(Color.YELLOW);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		
	}
	
	//Object=>Graphics=>Graphics2D
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//將父類別物件實體g強制轉型為其子類別物件
		Graphics2D g2d = (Graphics2D)g;
		
		//setStroke():設定筆畫的粗細等的方法
		g2d.setStroke(new BasicStroke(4));g2d.setColor(Color.BLUE);
		int line_index=1;
		
		for(LinkedList<HashMap<String, Integer>> line : lines){//畫所有線
			if(line_index==1) {g2d.setStroke(new BasicStroke(6));g2d.setColor(Color.BLACK);};
			if(line_index==2) {g2d.setStroke(new BasicStroke(6));g2d.setColor(Color.RED);};
			if(line_index>2) {g2d.setStroke(new BasicStroke(4));g2d.setColor(Color.BLUE);};
			line_index++;
			
			//畫單條線
			for(int i=1; i<line.size(); i++) {
				HashMap<String,Integer> p0 = line.get(i-1);
				HashMap<String,Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), 
						p1.get("x"), p1.get("y"));
			}
		}
	}
	
	
	//宣告給外部使用者,來存成圖檔
	public void saveJPEG() {
		BufferedImage paintImage = 
				new BufferedImage(
						getWidth(), getHeight(), 
						BufferedImage.TYPE_3BYTE_BGR);
	    
		Graphics2D graphics2D = paintImage.createGraphics();
	    paint(graphics2D);
	     
	    try {
		        ImageIO.write(paintImage,"jpeg", new File("dir1/save1.jpeg"));
		    } catch (Exception e) {
		        System.out.println("error");
		    }
	
	
	}
	
	
	//宣告給外部使用者,來清除所有線條的內部類別
	public void clear() {
		lines.clear();
		repaint();
	}
	
	//宣告給外部使用者,來復原上一步動作
	public void undo() {
		if (lines.size()>0) {
			recycle.add(lines.removeLast());
			repaint();
		}

	}
	
	//宣告給外部使用者,來重做上一步動作
	public void redo() {
		if (recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}


	public LinkedList<LinkedList<HashMap<String, Integer>>> getLines() {return lines;}

	public void setLines(LinkedList<LinkedList<HashMap<String, Integer>>> lines) {
		this.lines = lines;
		repaint();
	}
	
	//宣告滑鼠動作的內部類別
	//其父類別MouseAdapter所實現的Interfaces:
	//MouseListener, MouseMotionListener, MouseWheelListener, EventListener
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			//點下去時加入新線條
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
	
			//MyPoint point = new MyPoint(e.getX(),e.getY());
			HashMap<String,Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());		
			
			line.add(point);
			lines.add(line);
			//要畫新線時,資源回收桶要清空
			recycle.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			
			//新的點要加入最新(資料結構最後)的那條線中
			lines.getLast().add(point);
			repaint();
		}
	}

	
//畫data的走勢圖
	public void drawData(int[] indexs, double[] goals, double[] prices, String goal_code , String price_code, 
			int data_length,int period, int index_max, int index_min, double goal_max, double goal_min, double price_max, 
			double price_min, int screenWidth, int screenHeight, String ma , int drawing_move, double zoom_size) {	
		int range_x, range_y, data_length2; data_length2 = data_length - period+1;
		range_x = (int)(screenWidth*0.8*0.8*zoom_size);
		range_y = (int)(screenHeight*0.8*0.7);
		
		LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
		for(int i=0;i<data_length2;i++) {
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", (int)((int)(screenWidth*0.8*0.8)*0.05 + range_x*(indexs[i]-index_min)/(index_max-index_min)*0.99));
			point.put("y", (int)(range_y*1.075 - range_y*(goals[i]-goal_min)/(goal_max-goal_min)*0.99));		
			line.add(point);
			//System.out.println(indexs[i]+" "+point);
		}
		lines.add(line);
		
		LinkedList<HashMap<String, Integer>> line2 = new LinkedList<>();
		for(int i=0;i<data_length2;i++) {
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", (int)((int)(screenWidth*0.8*0.8)*0.05 + range_x*(indexs[i]-index_min)/(index_max-index_min)*0.99));
			point.put("y", (int)(range_y*1.075 - range_y*(prices[i]-price_min)/(price_max-price_min)*0.99) - drawing_move);		
			line2.add(point);
			
		}
		lines.add(line2);		
		repaint();
		}
}


////宣告點座標的public類別
//class MyPoint implements Serializable{
//	int x, y;
//	public MyPoint(int x, int y) {this.x = x; this.y = y;}
//}

