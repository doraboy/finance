package tw.org.iii.mytest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanelV3 extends MyPanel {
	public MyPanelV3() {
		addMouseListener(new MyMouseListener());
		
	}
	
	//內部類別,可直接存取外部類別的屬性和方法
	//故為MyPanelV3所擁有的內部類別,也會有那四種存取修飾字
	//相反地外部類別只有public或沒有這兩種修飾字
	class MyMouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);//可省略
			System.out.println("OK");
		}
		
	}
}
