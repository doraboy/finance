package dora.finance;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

//Object=>Component=>Container=>Window=>Frame=>JFrame=>MySignature(自定)
public class MyInvesting extends JFrame{//投資分析程式
	private JButton clear, undo, redo, saveJPG, saveObject, loadObject , drawData, clearScreen;
	private JButton reset, zoom_in, zoom_out, shift_U, shift_UU, shift_UUU, shift_D, shift_DD, shift_DDD;
	private JMenuBar menubar;
	private static MyJTextArea screen;
	private MyView myView;
	private static int[] indexs;
	private static int[] indexs_0;
	private static double[] goals;
	private static double[] goals_0;
	private static double[] prices;
	private static double[] prices_0;
	private static String goal_code, price_code, mode;
	private static int data_length;
	private static String ma;
	private static int period = 1;
	private static int index_max, index_min, drawing_move;
	private static double goal_max, goal_min, price_max, price_min, zoom_size;
	private static DecimalFormat formatter = new DecimalFormat("#.###");
	public static int screenWidth, screenHeight;
	

	public MyInvesting() {
		//呼叫其父類別建構式,傳入其"視窗標題"參數
		super("投資分析程式");

//BorderLayout和FlowLayout為實作介面LayoutManager的類別,很常使用
//FlowLayout常用傳參數建構式: FlowLayout(int align, int hgap, int vgap)
//FlowLayout.LEFT,FlowLayout.RIGHT,FlowLayout.CENTER,FlowLayout.LEADING,FlowLayout.TRAILING
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER,60,10));
		JPanel realtime_panel = new JPanel(new BorderLayout());
		JPanel realtime_upper = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		JPanel realtime_lower = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		JPanel operation_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));

//Object=>Component=>Container=>JComponent=>AbstractButton=>JButton
		clear = new JButton("Clear");
		//System.out.println(clear.getFont());
		//預設字型:[family=Dialog,name=Dialog,style=bold,size=12]
		undo = new JButton("Undo");
		redo = new JButton("Redo");		
		saveJPG = new JButton("Save JPG");
		saveObject = new JButton("Save Object");
		loadObject = new JButton("Load Object");
		drawData = new JButton("Draw Data");
		clearScreen = new JButton("Clear Screen");
		
		reset = new JButton("Reset");
		zoom_in = new JButton("Zoom in");
		zoom_out = new JButton("Zoom out");
		shift_U = new JButton(" ↑ ");
		shift_UU = new JButton("↑ ↑");
		shift_UUU = new JButton("↑↑↑");
		shift_D = new JButton(" ↓ "); //▼▲
		shift_DD = new JButton("↓ ↓");
		shift_DDD = new JButton("↓↓↓");
		
		drawing_move = 0; zoom_size = 1;
		
//Object=>Component=>Container=>JComponent=>JMenuBar	
//Object=>Component=>Container=>JComponent=>AbstractButton=>JMenu=>JMenuItem
//創建選單列(JMenuBar)=>選單(JMenu)=>選項(JMenuItem)
       JMenuItem item1, item2, item3, item4 , item5, item6 , item7, item8 ,item9, item10, item11, item12, item13, item14 ;
       JMenu menu1 = new JMenu("檔案");
       item1 = new JMenuItem("開啟檔案");
       item2 = new JMenuItem("儲存檔案");
       item2.setEnabled(false);
       menu1.add(item1);
       menu1.add(item2);
       menu1.setFont(new Font("Default",Font.BOLD ,36));
       item1.setFont(new Font("Default",Font.PLAIN ,30));
       item2.setFont(new Font("Default",Font.PLAIN ,30));
       
       period = 1; ma = "RAW";
     
       JMenu menu2 = new JMenu("分析");
       item3 = new JMenuItem("模式1 (" + period + "-" + ma +")");
       item4 = new JMenuItem("模式2 (" + period + "-" + ma +")");
       menu2.add(item3);
       menu2.add(item4);
       menu2.setFont(new Font("Default",Font.BOLD ,36));
       item3.setFont(new Font("Default",Font.PLAIN ,30));
       item4.setFont(new Font("Default",Font.PLAIN ,30));
       menu2.setEnabled(false);
       
       JMenu menu3 = new JMenu("設定");
       JMenu menu4 = new JMenu("資料取樣");
       JMenu menu5 = new JMenu("其他");
       JMenu menu6 = new JMenu("週期");
       JMenu menu7 = new JMenu("方式");
       JMenu menu8 = new JMenu("資料");
       
       item5 = new JMenuItem("5");     
       item6 = new JMenuItem("10");
       item7 = new JMenuItem("20");
       item8 = new JMenuItem("60");
       item9 = new JMenuItem("120");
       item10 = new JMenuItem("240"); 
       item11 = new JMenuItem("簡單平均(SMA)");
       item12 = new JMenuItem("時間加權平均(EMA)"); 
       item13 = new JMenuItem("原始資料(RAW)");
       item14 = new JMenuItem("讀取資料 (" + period + "-" + ma +")");
       menu6.add(item5);menu6.add(item6);menu6.add(item7);menu6.add(item8);menu6.add(item9);menu6.add(item10);
       menu7.add(item13);menu7.add(item11);menu7.add(item12);
       menu4.add(menu7);menu4.add(menu6);
       menu3.add(menu4);menu4.add(menu5);
       menu8.add(item14);
       menu3.setEnabled(false);
       menu8.setEnabled(false);
     
       item5.setEnabled(false);
       item6.setEnabled(false);
       item7.setEnabled(false);
       item8.setEnabled(false);
       item9.setEnabled(false);
       item10.setEnabled(false);
       
       menu3.setFont(new Font("Default",Font.BOLD ,36));
       menu8.setFont(new Font("Default",Font.BOLD ,36));
       
       menu4.setFont(new Font("Default",Font.BOLD ,30));
       menu5.setFont(new Font("Default",Font.BOLD ,30));
       menu6.setFont(new Font("Default",Font.BOLD ,30));
       menu7.setFont(new Font("Default",Font.BOLD ,30));
       
       item14.setFont(new Font("Default",Font.PLAIN ,30));

       item5.setFont(new Font("Default",Font.PLAIN ,24));
       item6.setFont(new Font("Default",Font.PLAIN ,24));
       item7.setFont(new Font("Default",Font.PLAIN ,24));
       item8.setFont(new Font("Default",Font.PLAIN ,24));
       item9.setFont(new Font("Default",Font.PLAIN ,24));
       item10.setFont(new Font("Default",Font.PLAIN ,24));
       item11.setFont(new Font("Default",Font.PLAIN ,24));
       item12.setFont(new Font("Default",Font.PLAIN ,24));
       item13.setFont(new Font("Default",Font.PLAIN ,24));
      
       
       menubar = new JMenuBar();
       menubar.add(menu1);
       menubar.add(menu2);
       menubar.add(menu8);
       menubar.add(menu3);
       setJMenuBar(menubar);

 
       
//實作點選選單列的動作
       item1.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			copyData();
			
			if(data_length>0) {
			item2.setEnabled(true);
			menu2.setEnabled(true);
			menu3.setEnabled(true);
			menu8.setEnabled(true);
			drawData.setEnabled(true);
			
			if(data_length>5) {item5.setEnabled(true);}
			if(data_length>10) {item6.setEnabled(true);}
			if(data_length>20) {item7.setEnabled(true);}
			if(data_length>60) {item8.setEnabled(true);}
			if(data_length>120) {item9.setEnabled(true);}
			if(data_length>240) {item10.setEnabled(true);}
			}
		}
	});
       
       //實作模式分析選項
       item3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Investing01();
		}
	});
       item4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Investing02();
		}
	});
       
       //實作設定取樣方式和週期選項
       item5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			period = 5; if(ma == "RAW") { ma = "SMA";}
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
		}
	});
       item6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			period = 10; if(ma == "RAW") { ma = "SMA";}
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
		}
	});
       item7.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			period = 20; if(ma == "RAW") { ma = "SMA";}	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
		}
	});
       item8.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			period = 60; if(ma == "RAW") { ma = "SMA";}	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
		}
	});
       item9.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			period = 120; if(ma == "RAW") { ma = "SMA";}	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
		}
	});
       item10.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			period = 240; if(ma == "RAW") { ma = "SMA";}	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
			if(data_length>5) {item5.setEnabled(true);}
			if(data_length>10) {item6.setEnabled(true);}
			if(data_length>20) {item7.setEnabled(true);}
			if(data_length>60) {item8.setEnabled(true);}
			if(data_length>120) {item9.setEnabled(true);}
			if(data_length>240) {item10.setEnabled(true);}
		}
	});  
       item11.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ma = "SMA"; if(period == 1) {period = 5;}	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
			if(data_length>5) {item5.setEnabled(true);}
			if(data_length>10) {item6.setEnabled(true);}
			if(data_length>20) {item7.setEnabled(true);}
			if(data_length>60) {item8.setEnabled(true);}
			if(data_length>120) {item9.setEnabled(true);}
			if(data_length>240) {item10.setEnabled(true);}
		}
	}); 
       item12.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ma = "EMA";	if(period == 1) {period = 5;}	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);
		}
	});
       item13.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ma = "RAW";	period = 1;	
			item3.setText("模式1 (" + period + "-" + ma +")"); item4.setText("模式2 (" + period + "-" + ma +")");
			item14.setText("讀取資料 (" + period + "-" + ma +")");
			menu2.setEnabled(false);item5.setEnabled(false);item6.setEnabled(false);item7.setEnabled(false);
			item8.setEnabled(false);item9.setEnabled(false);item10.setEnabled(false);
		}
	});
       item14.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				copyData();
				drawData.setEnabled(true);
				menu2.setEnabled(true);
			}
		});
       
       //System.out.println("選單數: " + menubar.getMenuCount());
		
       
		//變更按鈕字型
		clear.setFont(new Font("Default",Font.BOLD ,32));
		undo.setFont(new Font("Default",Font.BOLD ,32));
		redo.setFont(new Font("Default",Font.BOLD ,32));
		saveJPG.setFont(new Font("Default",Font.BOLD ,32));
		saveObject.setFont(new Font("Default",Font.BOLD ,32));
		loadObject.setFont(new Font("Default",Font.BOLD ,32));
		drawData.setFont(new Font("Default",Font.BOLD ,32));
		drawData.setEnabled(false);
		clearScreen.setFont(new Font("Default",Font.BOLD ,32));
		
		shift_U.setFont(new Font("Default",Font.BOLD ,32));
		shift_UU.setFont(new Font("Default",Font.BOLD ,32));
		shift_UUU.setFont(new Font("Default",Font.BOLD ,32));
		shift_D.setFont(new Font("Default",Font.BOLD ,32));
		shift_DD.setFont(new Font("Default",Font.BOLD ,32));
		shift_DDD.setFont(new Font("Default",Font.BOLD ,32));
		reset.setFont(new Font("Default",Font.BOLD ,36));
		zoom_in.setFont(new Font("Default",Font.BOLD ,36));
		zoom_out.setFont(new Font("Default",Font.BOLD ,36));
		
		screen = new MyJTextArea(" 狀態列:\n",30,16);
		screen.setFont(new Font("Default", Font.PLAIN, 32));
		screen.setBackground(Color.GREEN);
		
		top.add(clear);top.add(undo);top.add(redo);
		top.add(saveJPG);top.add(saveObject);top.add(loadObject);
		top.add(drawData);
		add(top,BorderLayout.NORTH);
		
		//screen.append("標題1:xfcbbbbbbbbbbbbbbbbbbjjjjjjjjjjjjjjjjjbbbbbbbb"+"\n");
		//System.out.println(screen.getLineCount());//印出該物件選單總數
			
		realtime_upper.add(shift_U);realtime_upper.add(shift_UU);realtime_upper.add(shift_UUU);
		realtime_lower.add(shift_D);realtime_lower.add(shift_DD);realtime_lower.add(shift_DDD);
		realtime_panel.add(realtime_upper,BorderLayout.NORTH);realtime_panel.add(realtime_lower,BorderLayout.CENTER);
		operation_panel.add(reset);operation_panel.add(zoom_in);operation_panel.add(zoom_out);

		bottom.add(realtime_panel);
		bottom.add(operation_panel);
		
		bottom.setAlignmentY((float) 100.0);
		
		add(bottom,BorderLayout.SOUTH);
		
        //建立Screen
		screen.setEditable(false);
		screen.setLineWrap(true);
		screen.setAutoscrolls(true);
        JScrollPane jpanel = new JScrollPane(screen,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(jpanel,BorderLayout.WEST);
        jpanel.setColumnHeaderView(clearScreen);

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
		
		drawData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				myView.drawData(indexs, goals, prices, goal_code, price_code, data_length, period,
								index_max,index_min,goal_max,goal_min,price_max,price_min,
								screenWidth, screenHeight, ma , drawing_move, zoom_size);
				drawData.setEnabled(false);
				
			}
		});
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				drawing_move = 0; zoom_size = 1;
				myView.drawData(indexs, goals, prices, goal_code, price_code, data_length, period,
						index_max,index_min,goal_max,goal_min,price_max,price_min,
						screenWidth, screenHeight, ma , drawing_move, zoom_size);
			}
		});
		
		zoom_in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				drawing_move += 0; zoom_size *= 1.1;
				myView.drawData(indexs, goals, prices, goal_code, price_code, data_length, period,
						index_max,index_min,goal_max,goal_min,price_max,price_min,
						screenWidth, screenHeight, ma , drawing_move, zoom_size);
			}
		});
		
		zoom_out.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				drawing_move += 0; zoom_size *= 1/1.1;
				myView.drawData(indexs, goals, prices, goal_code, price_code, data_length, period,
						index_max,index_min,goal_max,goal_min,price_max,price_min,
						screenWidth, screenHeight, ma , drawing_move, zoom_size);
			}
		});
		
		shift_U.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				drawing_move += 30;
				myView.drawData(indexs, goals, prices, goal_code, price_code, data_length, period,
						index_max,index_min,goal_max,goal_min,price_max,price_min,
						screenWidth, screenHeight, ma , drawing_move, zoom_size);
			}
		});
		
		shift_D.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
				drawing_move -= 30;
				myView.drawData(indexs, goals, prices, goal_code, price_code, data_length, period,
						index_max,index_min,goal_max,goal_min,price_max,price_min,
						screenWidth, screenHeight, ma , drawing_move, zoom_size);
			}
		});
		
		clearScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(" 狀態列:\n");
			}
		});
		
		
//Object=>Toolkit
//This class is the abstract superclass of all actual implementations of the Abstract Window Toolkit. 
//抽象視窗工具組（Abstract Window Toolkit=AWT）是Java的平台獨立的視窗系統， 圖形和使用者介面器件工具包

		//Object=>Dimension2D=>Dimension
		//The Dimension class encapsulates the width and height of a component (in integer precision) in a single object
		//以下為取得螢幕解析度(像素)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight();
		System.out.println("Resolution:" + screenWidth + "x" + screenHeight + "\n");
		
		//設置視窗長寬大小為解析度長寬的80%
		setSize((int)(screenWidth*0.8),(int)(screenHeight*0.8));
		//設置視窗可視與否
		setVisible(true);
		//設置視窗在螢幕上的位置(置中,且貼其螢幕上方)
		setLocation((int)(screenWidth*(1-0.8)*0.5), 0);

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
		
	public static void copyData() {
		ReadCSV rCSV = new ReadCSV();
//		System.out.println(rCSV.index[98]);
		
		goal_code = rCSV.goal_code;
		price_code = rCSV.price_code;
		data_length = rCSV.data_length;
		
		indexs_0 = new int[data_length];
		goals_0 = new double[data_length];
		prices_0 = new double[data_length];
		
		indexs = new int[data_length-period+1];
		goals = new double[data_length-period+1];
		prices = new double[data_length-period+1];
		
		mode = "";
		
		//原始資料
		System.out.println("----------------原始資料如下---------------");
		for(int i=0;i<data_length;i++) {
			indexs_0[i] = rCSV.index[i];
			goals_0[i] = rCSV.goal[i];
			prices_0[i] = rCSV.price[i];	
			System.out.println("Index="+indexs_0[i]+" , "+goal_code+"="+goals_0[i]+" , "+price_code+"="+prices_0[i]);
		}
		
		//取樣後資料
		System.out.println("---------------取樣後資料如下---------------");

		for(int i=0;i<data_length-period+1;i++) {
			indexs[i] = indexs_0[i+period-1];//index照樣複製
			if(ma=="EMA") {
					if(i>0) {
					goals[i] = goals_0[i+period-1]*(2/(period+1f)) + goals[i-1]*(1-2/(period+1f));
					prices[i] = prices_0[i+period-1]*(2/(period+1f)) + prices[i-1]*(1-2/(period+1f));	
					}else {//i=0
						goals[0] = goals_0[period-1]; prices[0] = prices_0[period-1];
					}
			}else {//ma = RAW or SMA
				goals[i] = 0; prices[i] = 0;
				for(int j=0;j<period;j++) {//period=5 0 1 2 3 4
					goals[i] += goals_0[i+period-1-j];//0  0 1 2 3 4
					prices[i] += prices_0[i+period-1-j];	
				}
				goals[i] = goals[i]/period; prices[i] = prices[i]/period;
			}
			System.out.println("Index="+indexs[i]+" , "+goal_code+"="+formatter.format(goals[i])+" , "+price_code+"="+formatter.format(prices[i]));
		}
		
		
		
		//找最大值、最小值
		index_max=indexs[0]; index_min=indexs[0];
		for(int i=0;i<data_length-period+1;i=i+1){
			if (indexs[i]>index_max) {index_max=indexs[i];}
			if (indexs[i]<index_min) {index_min=indexs[i];}
		}
		goal_max=goals[0]; goal_min=goals[0];
		for(int i=0;i<data_length-period+1;i=i+1){
			if (goals[i]>goal_max) {goal_max=goals[i];}
			if (goals[i]<goal_min) {goal_min=goals[i];}
		}
		price_max=prices[0];price_min=prices[0];
		for(int i=0;i<data_length-period+1;i=i+1){
			if (prices[i]>price_max) {price_max=prices[i];}
			if (prices[i]<price_min) {price_min=prices[i];}
		}
		
		screen.setText(" 狀態列:\n");
		screen.append(" 目標: " + goal_code + " , 測試: " + price_code + "\n 資料數: " + data_length+", 取樣數: "+(data_length-period+1)+"\n 取樣方式: "+period+" - "+ma+"\n");
		screen.append(" 序號: " + index_min + " ~ " + index_max+"\n");
		screen.append(" 目標: " + formatter.format(goal_min) + " ~ " + formatter.format(goal_max)+"\n");
		screen.append(" 測試: " + formatter.format(price_min) + " ~ " + formatter.format(price_max)+"\n");
		screen.append("---------------------------------------" + "\n");
		screen.append(mode + "\n");
		
		
		System.out.println("-----------------------------------------");
		System.out.println("目標對象:" + goal_code + " , 測試對象:" + price_code + " , 資料數量:" + data_length);
		System.out.println("取樣資料數量:"+(data_length-period+1)+" 取樣週期:"+period+"("+ma+")");
		System.out.println("index最大值:"+index_max+", index最小值:"+index_min);
		System.out.println("goal最大值:"+formatter.format(goal_max)+", goal最小值:"+formatter.format(goal_min));
		System.out.println("price最大值:"+formatter.format(price_max)+", price最小值:"+formatter.format(price_min));
		
		System.out.println("-----------------------------------------");
		
	}
		
	public static void Investing01() {
		screen.setContext(" 資料處理分析完成! (模式1)");
		
		System.out.println("----------------------------");
		System.out.println("由這邊做資料處理分析(模式1)");
		System.out.println("分析模式1:取樣週期:" + period + ",方式:" + ma);
// (以下先測試印出所有index)
//		for (int i:indexs) {
//		   System.out.println(i);
//		}
	
	}
	
	public static void Investing02() {
		screen.setContext(" 資料處理分析完成! (模式2)");
		System.out.println("----------------------------");
		System.out.println("由這邊做資料處理分析(模式2)");
		System.out.println("分析模式2:取樣週期:" + period + ",方式:" + ma);

	}
	

	class MyJTextArea extends JTextArea {
		public MyJTextArea() {super(" 狀態列:\n");}
		public MyJTextArea(String string, int i, int j) {super(string,i,j);}
		public void setContext(String My_mode_text) {
			setText(" 狀態列:\n"
			+" 目標: " + goal_code + " , 測試: " + price_code + "\n 資料數: " + data_length+", 取樣數: "+(data_length-period+1)+"\n 取樣方式: "+period+" - "+ma+"\n"
			+" 序號: " + index_min + " ~ " + index_max+"\n"
			+" 目標: " + formatter.format(goal_min) + " ~ " + formatter.format(goal_max)+"\n"
			+" 測試: " + formatter.format(price_min) + " ~ " + formatter.format(price_max)+"\n"
			+"---------------------------------------" + "\n"
			+My_mode_text + "\n");
		}
	}

	public static void main(String[] args) {
		new MyInvesting();
		//copyData();
		//Investing01();
		

	}

}




