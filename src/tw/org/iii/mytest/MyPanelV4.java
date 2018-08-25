
package tw.org.iii.mytest;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanelV4 extends MyPanel{
	private MouseListener mListener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			//super.mouseClicked(e);
			System.out.println("mListener");
		}
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);
		}
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
		}
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
		}
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
		}
	};

	
	private MouseListener mListener2 = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			//super.mouseClicked(e);
			System.out.println("mListener2");
		}
		
	};
	
	
	public MyPanelV4() {
		//super();
		addMouseListener(mListener);
		addMouseListener(mListener2);
		MouseListenerV100 mListener3=new MouseListenerV100(this);
		addMouseListener(mListener3);

	}
	
class MouseListenerV100 extends MouseAdapter{
	private MyPanelV4 obj;
	public MouseListenerV100(MyPanelV4 obj) {
		this.obj=obj;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//super.mouseClicked(e);
		System.out.println("mListener3");
	}
	
}
	

}
