package tw.org.iii.mytest;

import java.io.File;

public class java44 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);//";"用在path當中不同路徑間的分隔符號
		System.out.println(File.separator);//"\"用在路徑當中,表示在某某路徑下
		//不同作業系統,其path和路徑中的符號有可能不同,所以為了達到跨平台
		//才需要先取得該作業系統的所用符號
		
		File dir1 = new File("c:/brad/dir1");//因為windows系統下\即為字串的跳脫字元符號
		//故要用\\取代,或者可用/取代,因為java跨平台,建議用後者
		System.out.println(dir1.exists());
		
		File[] roots=File.listRoots();
		for (File root : roots)
		{System.out.println(root.getAbsolutePath());}
		//在windows系統中,為多根系統,根=盡頭的意思
		//故絕對路徑的結果為C:\,D:\,E:\等
		//不符合跨平台的精神,故通常會改用相對路徑來表示
		
		File dir2 = new File("./dir1");//"."代表本目錄, ":"代表上一層
		//這邊的.代表本專案目錄
		System.out.println(dir2.getAbsolutePath());
		//結果為C:\JavaPrograms\gitrepository\java02\.
		System.out.println(dir2.exists());
	

	}

}

