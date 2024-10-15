package chap13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Time586 {

	public static void main(String[] args) {
		// 프로그램 실행 시간 체크
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long starttime;
		long endtime;

		//list1
		starttime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endtime = System.nanoTime();
		System.out.println("ArrayList 걸린시간 : " + (endtime - starttime) + " ns");
		
		//list2
		starttime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endtime = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (endtime - starttime) + " ns");
		
		//list1 끝에서부터
		starttime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list1.add(String.valueOf(i));
		}
		endtime = System.nanoTime();
		System.out.println("ArrayList 걸린시간 : " + (endtime - starttime) + " ns");
		
		//list2 끝에서부터
		starttime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list2.add(String.valueOf(i));
		}
		endtime = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (endtime - starttime) + " ns");
		
		
	}	//main

}
