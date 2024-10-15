package chap06;

public class MemberServiceMain {

	public static void main(String[] args) {
		// 객체 생성
		MemberService log = new MemberService();
		boolean result = log.login("hong", "12345");
		
		if(result) {
			System.out.println("로그인 되었습니다.");
			log.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}

	}//main

}
