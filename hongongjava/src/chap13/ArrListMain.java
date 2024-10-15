package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrListMain {

	public static void main(String[] args) {
		// List 컬렉션
		// ArrayList
		
		//ctrl + shift + o
		List<String> list = new ArrayList<String>();
		
		//스트링 객체를 저장
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");	//2번 자리에 Database 저장
		list.add("iBATIS");
		
		// 저장된 총 객체 수 얻기
		int size = list.size();		//length가 아니라 size
		System.out.println("총 객체 수: " + size);
		System.out.println();

		// 2번 인덱스의 객체 얻기
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		// 저장된 객체 수 만큼 루핑
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println();
		
		
		// 2번 인덱스 삭제
		list.remove(2);			//2번 Database
		list.remove(2);			//2번 Servlet/JSP
		list.remove("iBATIS");
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
	}//main

}//class
