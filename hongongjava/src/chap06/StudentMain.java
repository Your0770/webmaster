package chap06;

public class StudentMain {

	public static void main(String[] args) {
		// 객체 생성
		Student st1 = new Student("240901", "강땡땡");
		System.out.println(st1.stNo);
		System.out.println(st1.name);
		st1.study();
		
		Student st2 = new Student("240902", "김땡땡");
		System.out.println(st2.stNo);
		System.out.println(st2.name);
		st2.study();
		
		System.out.println();
		System.out.println();
		
		//클래스 객체의 배열타입으로 객체를 생성하면 반복문으로 돌릴때 편하다
		Student[] std = new Student[5];
		std[0] = new Student("1", "아무나", 67, 60, 78);
		std[1] = new Student("2", "아무개", 94, 78, 90);
		std[2] = new Student("3", "아무무", 69, 82, 75);
		std[3] = new Student("4", "암개", 92, 87, 96);
		std[4] = new Student("5", "암나", 10, 20, 95);
		
		System.out.println();
		
		for(Student st : std) {
			st.print();
		}

	}//main

}
