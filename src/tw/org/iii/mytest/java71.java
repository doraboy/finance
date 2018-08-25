package tw.org.iii.mytest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class java71 {//介面Set
	public static void main(String[] args) {
		//HashSet類別可實作介面Set
		HashSet set = new HashSet();
		//介面Set特性:(1)無順序性(2)裡面元素不會重複
		
		set.add(12);
		set.add(34.0);
		set.add("Brad");
		set.add(new Bike());
		set.add(12);//元素不會重覆,丟不進去
		set.add(34.0);//元素不會重覆,丟不進去
		System.out.println(set.toString());
		
		TreeSet<Integer> set2 = new TreeSet<>();//有指定物件類型
		//有泛型<E>後,編譯時期就會自動檢查物件類型是否符合指定類型,
		while(set2.size()<6) {//產生6個不重複樂透數字
			set2.add((int)(Math.random()*49+1));
		}
		System.out.println(set2.toString());
		
		System.out.println("-------------------");
		//方法一:利用疊代器Iterator<>將元素取出
		//但缺點是疊代器物件實體取完元素後,就自動消滅,不能再取用
		Iterator<Integer> it = set2.iterator();
		while(it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
		System.out.println("-------------------");
		
		//方法二:利用for each(因為是Collection介面的一種)
		//Interface Collection => Set(子介面)
		//TreeSet類別來實作介面Set
		for(Integer num : set2) {
			System.out.println(num);
		}
		//這種方法可重複取用
		

	}

}
