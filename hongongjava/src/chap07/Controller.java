package chap07;

public class Controller {
	//field
	public MemberService service;
	
	//constructor
	
	//method
	public void setService(MemberService service) {
		this.service = service; 
	}
	
	//main
	public static void main(String[] args) {
		//객체 생성
		Controller controller =  new Controller();
		
		
		controller.setService(new MemberService());
		controller.service.login();
		
		controller.setService(new AService());
		controller.service.login();
		
	}	//main
	
}
