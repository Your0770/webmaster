package chap06;

public class ShopService {
	//싱글톤
	 
	
	//필드
	private static ShopService shops = new ShopService();
		
	//생성자
	private ShopService() {};
		
	//메소드
	// 메소드를 클래스로 호출하기 위해 static을 앞에 붙인다.
	static ShopService getInstance() {
		return shops;
	}
}
