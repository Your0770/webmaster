package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("최길동", 30));
		set.add(new Member("최길동", 25));
		
		System.out.println("총 객체수 : " + set.size());
		System.out.println();
		
		System.out.println("향상된 for");
		for(Member mb : set) {
			System.out.printf("%s\t%d\n", mb.name, mb.age);
		}
		System.out.println();
		
		System.out.println("Iterator");
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member mbi = iterator.next();
			System.out.printf("%s\t%d\n", mbi.name, mbi.age);
		}
		
	}

}
