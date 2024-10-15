package chap06;

public class SingletonMain {

	public static void main(String[] args) {
		// 싱글톤 사용시 객체 생성 불가
		// 메소드 호출로 객체를 받아옴
		
		Singleton st = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		if(st == st2) System.out.println("같은 객체");
		else System.out.println("다른 객체");
		
		st2.name = "거시기";
		System.out.println(st.name);
		st.name = "아무개";
		System.out.println(st2.name);
		
	}

}
