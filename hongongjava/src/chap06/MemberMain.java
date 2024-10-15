package chap06;

public class MemberMain {

	public static void main(String[] args) {
		// 객체 생성
		Member member = new Member();
		
		// 필드 출력
		System.out.println(member.name);
		System.out.println(member.id);
		System.out.println(member.password);
		System.out.println(member.age);
		System.out.println();
		
		// 필드값 변경
		member.name = "최하얀";
		member.age = 23;
		member.id = "hayan23";
		member.password = "choiwhite23";
		
		//수정된 필드 출력
		System.out.println(member.name);
		System.out.println(member.id);
		System.out.println(member.password);
		System.out.println(member.age);
		System.out.println();
		
		Member user1 = new Member("홍길동", "hong");
		System.out.println(user1.name);
		System.out.println(user1.id);
		System.out.println(user1.password);
		System.out.println(user1.age);
		
		
		
		
		
		
	}//main

}
