package tw.org.iii.mytest;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class java38 extends JFrame{
	//private MyPanel myPanel;
	//private MyPanelV2 myPanel;
	//private MyPanelV3 myPanel;
	private MyPanelV4 myPanel;
	
	public java38() {
		setLayout(new BorderLayout());
		
		//myPanel = new MyPanelV2();
		//myPanel = new MyPanelV3();
		myPanel = new MyPanelV4();
		add(myPanel,BorderLayout.CENTER);//要add進去才會有元件的表現
		
		addWindowListener(new MyListener());
		setSize(640,480);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new java38();
	}
}

class MyListener extends WindowAdapter{//已經繼承WindowAdapter,程式碼雖較精簡,但無法在繼承其他類別
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("closing");
		System.exit(0);//command line return value;
		//0 => normal; non-zero => error
	}
	
}


//class MyWindowListener implements WindowListener{//自己實作介面,可以實作繼承多個介面
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		System.out.println("opened");	
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		System.out.println("closed");
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.out.println("closing");
//		System.exit(0);//command line return value;
//		//0 => normal; non-zero => error
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		System.out.println("deactivated");	
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		System.out.println("deiconified");
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		System.out.println("iconified");		
//	}
//
//	@Override
//	public void windowOpened(WindowEvent e) {
//		System.out.println("opened");
//	}
//	
//}
