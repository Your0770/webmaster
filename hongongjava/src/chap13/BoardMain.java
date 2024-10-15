package chap13;

import java.util.List;
import java.util.Vector;

public class BoardMain {

	public static void main(String[] args) {
		// Vector : 멀티 스레드 환경에 안전
		List<Board> list = new Vector<>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for(Board obj : list) {
			System.out.printf("%s\t%s\t%s", obj.subject, obj.content, obj.writer);
			System.out.println();
		}
		System.out.println();
		
		//hashCode()
		Board bd = new Board("제목", "내용", "작가");
		System.out.println(bd);				//.println() - 객체를 출력해달라고 하면 toString() 을 출력해줌
		System.out.println(bd.hashCode());
		System.out.println(bd.toString());
		
		
		

	}//main

}
