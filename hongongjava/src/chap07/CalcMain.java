package chap07;

public class CalcMain {

	public static void main(String[] args) {
		// 자식 객체 생성
		Computer com = new Computer();
		Calculator calc = new Calculator();
		
		double result1 =  calc.areaCircle(10);
		System.out.println("부모메소드 : " + result1);
		
		double result = com.ac(10);
		System.out.println("자식메소드 : " + result);

	}

}
