package tw.org.iii.mytest;

import java.util.Iterator;
import java.util.LinkedList;


public class java72 {//介面List
	public static void main(String[] args) {
		//介面List特性:(1)有順序性(2)裡面元素可重複
		//兩種常用的實作類別:
		//LinkedList(執行階段元素異動性大), ArrayList(執行階段元素不太會改變)
		
		LinkedList<String> names = new LinkedList<>();
		names.add("Brad");
		names.add("Brad");
		names.add("Tony");
		names.add("Eric");
		names.add("Mary");
		System.out.println(names.size());
		System.out.println(names);
		
		//方法一:可利用疊代器Iterator<>將元素取出
		//但缺點是疊代器物件實體取完元素後,就自動消滅,不能再取用
		//內容(略)	
		
		//方法二:利用for each(因為是Collection介面的一種)
		//Interface Collection => List(子介面)
		for(String name : names) {
			System.out.println(name);
		}
		//這種方法可重複取用
		
		System.out.println(names.get(3));
		

	}

}
