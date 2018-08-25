package tw.org.iii.mytest;

public class java16_2 {

	public static void main(String[] args) {
		
		int number_0,number_1,number_2,number_3,number_4,number_5,number_6=0;
		number_0=number_1=number_2=number_3=number_4=number_5=number_6=0;
		
		for(int i=0;i<100;i++){
		int a=(int)(Math.random()*6)+1;
		switch(a) {
		case 1:number_1++;break;
		case 2:number_2++;break;
		case 3:number_3++;break;
		case 4:number_4++;break;
		case 5:number_5++;break;
		case 6:number_6++;break;
		default:number_0++;//例外情況(錯誤)
		}
		
		}
		
		if(number_0==0){
		System.out.println("點數1次數為"+number_1);
		System.out.println("點數2次數為"+number_2);
		System.out.println("點數3次數為"+number_3);
		System.out.println("點數4次數為"+number_4);
		System.out.println("點數5次數為"+number_5);
		System.out.println("點數6次數為"+number_6);
		}else {
			System.out.println("XX");
		}
		
	}

}
