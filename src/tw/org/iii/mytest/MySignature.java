package tw.org.iii.mytest;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//Object=>Component=>Container=>Window=>Frame=>JFrame=>MySignature(自定)
public class MySignature extends JFrame{//簽名程式
	private JButton clear, undo, redo, saveJPG, saveObject, loadObject;
	private MyView myView;
	
	
	
	
	public MySignature() {
		//呼叫其父類別建構式,傳入其"視窗標題"參數
		super("簽名");

		
//BorderLayout為實作介面LayoutManager的類別,很常使用
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		saveJPG = new JButton("Save JPG");
		saveObject = new JButton("Save Object");
		loadObject = new JButton("Load Object");
		
		top.add(clear);top.add(undo);top.add(redo);
		top.add(saveJPG);top.add(saveObject);top.add(loadObject);
		add(top,BorderLayout.NORTH);

//Object=>Component=>Container=>JComponent=>JPanel=>MyView(自創)
		//自定的類別MyView,來展現即時的畫圖畫面
		myView = new MyView();
		add(myView,BorderLayout.CENTER);
		
		//來實作各個按鈕的作用
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.undo();
				
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.redo();
			}
		});
		
		saveJPG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//saveJPEG();
				myView.saveJPEG();
			}
		});
		
		saveObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		
		loadObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}



	private void saveJPG(){
	    BufferedImage imagebuf = null;
	    
	    try {
	        imagebuf = new Robot().createScreenCapture(myView.bounds());
	    } catch (AWTException e1) {
	        e1.printStackTrace();
	    }  
	    
	    Graphics2D graphics2D = imagebuf.createGraphics();
	    myView.paint(graphics2D);
	     
	     try {
	        ImageIO.write(imagebuf,"jpeg", new File("dir1/save1.jpeg"));
			
	        //存完圖檔後後顯示存檔成功訊息
			JOptionPane.showMessageDialog(this, "Save JPEG ok");
	     } catch (Exception e) {
	        System.out.println("error");
	    }
	}
	
	private void saveObject() {
		LinkedList<LinkedList<HashMap<String, Integer>>> lines = myView.getLines();
		try {
			ObjectOutputStream oout =
					new ObjectOutputStream(
							new FileOutputStream("dir1/brad.obj"));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			
			//存完物件後顯示存檔成功訊息
			JOptionPane.showMessageDialog(this, "Save Object ok");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
		private void loadObject() {
			try {
				ObjectInputStream oin = 
					new ObjectInputStream(
						new FileInputStream("dir1/brad.obj"));
				LinkedList<LinkedList<HashMap<String, Integer>>> lines = 
					(LinkedList<LinkedList<HashMap<String, Integer>>>)oin.readObject();
				oin.close();
				myView.setLines(lines);
			} catch (Exception e) {
				System.out.println(e);
			}
				
			
		}
	
	public static void main(String[] args) {
		new MySignature();

	}

}
