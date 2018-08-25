package tw.org.iii.mytest;

import java.util.LinkedList;

public class java73 {//將LinkedList顛倒順序由大到小

	public static void main(String[] args) {
		LinkedList<Integer> nums = new LinkedList<>();
		for(int i=0;i<10;i++){
			nums.add(0,i);//將新來元素i插入第0個位置
		}
		System.out.println(nums);

	}

}
