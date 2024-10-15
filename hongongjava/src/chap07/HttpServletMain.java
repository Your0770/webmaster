package chap07;

public class HttpServletMain {
	//field
	
	//constructor
	
	//method
	public static void method(HttpServlet servlet) {
		servlet.service();
	}
	
	//main
	public static void main(String[] args) {
		method(new LoginServlet());
		method(new FileDownloadServlet());
	}	//main
	
}
