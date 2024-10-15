package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam604 {
	
	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));
		
		Iterator<Student> ir = set.iterator();
		while(ir.hasNext()) {
			Student st = ir.next();
			System.out.println(st.stNum + ":" + st.name);
		}
		
		
		
	} //main
}
