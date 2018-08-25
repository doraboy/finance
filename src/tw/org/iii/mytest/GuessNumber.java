package tw.org.iii.mytest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame {
	private JButton guess;
	private JTextField input;
	private JTextArea hist;
	private String answer = createAnswer();
	private int counter;//預設為0

	
	public GuessNumber() {//建構式,初始化視窗配置
		super("猜數字遊戲");
		
		guess = new JButton("猜");
		input = new JTextField();
		hist = new JTextArea();
		input.setFont(new Font("Default", Font.PLAIN, 24));
		hist.setFont(new Font("Default", Font.BOLD+Font.ITALIC, 24));
		
		setLayout(new BorderLayout());//不在意物件名稱,只需要這個物件實體
		add(hist,BorderLayout.CENTER);
		
		JPanel top = new JPanel(new BorderLayout());//宣告top的隔間
		//不需擁有,單純用來初始化,故宣告成區域變數
		top.add(guess,BorderLayout.EAST);
		top.add(input,BorderLayout.CENTER);

		add(top,BorderLayout.NORTH);//將隔間放入視窗內(南,北優於東,西,最後是剩下的部分)
		
		guess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doGuess();
			}
		});//有聽才會回應
		//guess本身是一個按鈕的物件實體,它本身不會聽動作
		//故委託其祖先類別的動作傾聽者

		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void doGuess() {
		//作業:
		//1.猜完後游標移回輸入框
		//2.不符合格式的猜測不要進入檢查
		//3.猜中或猜錯10次後,按完確定,開新局
		
		//System.out.println("謎底"+answer);
		counter++;
		String result = checkAB();
		hist.append(counter+". "+input.getText()+" =>"+result+"\n");//添加結果
		input.setText("");
		if(result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null,"恭喜猜中了!");
//			newGame();
		}else if(counter == 10) {
			JOptionPane.showMessageDialog(null,"Loser:答案為"+answer);
//			newGame();
		}
	}

	String createAnswer() {
		int poker[]=new int[10];//0-12,13-25,25-38,38-51代表四種花色
		boolean isRepeat;
		int temp;
		
		for(int i=0;i<poker.length;i++) {			
	
			do {//至少做一次
			    temp=(int)(Math.random()*10);
			
			//檢查機制
			isRepeat=false;
			for(int j=0;j<i;j++) {
				if(poker[j]==temp) {
					isRepeat=true;
					break;
				}
			}
		}while(isRepeat);//若重複則重洗
		
		//出上面迴圈代表已經洗到不重複
		poker[i]=temp;		
		
		}

		return ""+poker[0]+poker[1]+poker[2];
	}
	
	String checkAB() {
		int a,b; a = b = 0;
		boolean isRight=false;//判斷輸入是否正確
		//得到使用者輸入值
		String guess = input.getText();
		
//		do {
//
//		if(guess.matches("^[0-9]*3$")) {
//			isRight = true;
//		  }else{
//			  System.out.println("輸入錯誤,請重新輸入");
//			  input = new JTextField();
//			  guess = input.getText();
//		  }
//		} while(isRight==false);
		

		
		//判斷幾A幾B
		for(int i=0;i<guess.length();i++) {
			if(guess.charAt(i)==answer.charAt(i)) {
				a++;
			}else if(answer.indexOf(guess.charAt(i))!=-1) {
				b++;
			}
		}
		System.out.println(guess);
		return a+"A"+b+"B";
	}
	
	
//	public void newGame() {//重啟遊戲
//		
//		counter=0;
//		answer = createAnswer();
//		guess = new JButton("猜");
//		input = new JTextField();
//		hist = new JTextArea();
//		input.setFont(new Font("Default", Font.PLAIN, 24));
//		hist.setFont(new Font("Default", Font.BOLD+Font.ITALIC, 24));
//		
//		setLayout(new BorderLayout());//不在意物件名稱,只需要這個物件實體
//		add(hist,BorderLayout.CENTER);
//		
//		JPanel top = new JPanel(new BorderLayout());//宣告top的隔間
//		//不需擁有,單純用來初始化,故宣告成區域變數
//		top.add(guess,BorderLayout.EAST);
//		top.add(input,BorderLayout.CENTER);
//
//		add(top,BorderLayout.NORTH);//將隔間放入視窗內(南,北優於東,西,最後是剩下的部分)
//		
//		guess.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				doGuess();
//			}
//		});//有聽才會回應
//		//guess本身是一個按鈕的物件實體,它本身不會聽動作
//		//故委託其祖先類別的動作傾聽者
//
//		
//		setSize(640, 480);
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//	
	public static void main(String[] args) {
		new GuessNumber();
		
		

	}

}
