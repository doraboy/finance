package dora.finance;

import java.io.FileInputStream;//input file's byte streams
//An InputStreamReader is a bridge from byte streams to character streams
import java.io.InputStreamReader;
import java.io.BufferedReader;//接收 character streams

public class ReadCSV {//讀取CSV檔案
	public int[] index;
	public double[] goal, price;
	public int data_length = -1;
	public String goal_code , price_code;
	
//	public static void main(String[] args) {
	ReadCSV(){
		try {	
			FileInputStream fin_0 = new FileInputStream("dir1/test.csv");//讀檔進來
			InputStreamReader isr_0 = new InputStreamReader(fin_0,"big5");//以big5編碼解析資料
			BufferedReader reader_0 = new BufferedReader(isr_0);
			String line = null; 
			
//BufferedReader的readLine()方法:傳回一整行的文字(不包含換行字元)
			//第一次讀檔計算資料長度
			while((line = reader_0.readLine())!=null) {
				data_length++;
			}
			//System.out.println(data_length);
			fin_0.close();
			
			//第二次讀檔才去解析資料內容
			FileInputStream fin = new FileInputStream("dir1/test.csv");//讀檔進來
			InputStreamReader isr = new InputStreamReader(fin,"big5");//以big5編碼解析資料
			BufferedReader reader = new BufferedReader(isr);
			
			goal_code = price_code = null;
			line = null; 
			

			//寫入資料陣列的指標(對應到index)
			int point = 0;
			index = new int[data_length];
			goal = new double[data_length];
			price = new double[data_length];
			
			while((line = reader.readLine())!=null) {
				String[] data = line.split(",");//因為是csv檔案,故指定用","隔開來解析
				String data00 = data[0];	
				String data01 = data[1];
				String data02 = data[2];
				
				//第一次進來時才去assign分析標的代號的值
				if(goal_code == null && price_code == null) {
					goal_code = data01; price_code = data02;
				}else {
					try
					{ 
					index[point] = Integer.parseInt(data00);
					goal[point] = Double.parseDouble(data01);
					price[point] = Double.parseDouble(data02);
					
					}
					catch (NumberFormatException e)
					{ 
					System.out.println("csv檔案內容格式有誤!");
					break;
					}

//					System.out.print("Index="+index[point]+" , ");
//					System.out.print(goal_code+"="+goal[point]+" , ");
//					System.out.println(price_code+"="+price[point]);
					point++;
				}
			
				//印出全部解析資料
				//System.out.println(line);
			}
			fin.close();
		} catch (Exception e) {
			System.out.println("讀檔失敗!!");
		}

	}
	


}
