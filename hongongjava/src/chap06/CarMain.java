package chap06;

public class CarMain {

	public static void main(String[] args) {
		// 객체 생성
		Car myCar = new Car();
		
		//필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.getMaxSpeed());
		System.out.println("현재속도: " + myCar.getSpeed());
		
		//필드값 변경
		myCar.setSpeed(60);
		System.out.println("수정된 속도: " + myCar.getSpeed());
		myCar.color = "흰색";
		System.out.println("도색색깔: " + myCar.color);
		System.out.println();
		
		//p279
		myCar.setGas(5);
		
		boolean gasState = myCar.isLeftGas();
		
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
		System.out.println();
		
		//p284
		myCar.keyTurnOn();
		myCar.run2();
		int speed = myCar.getSpeed();
		System.out.println("현재 속도 : " + speed + "km/h)");
		
		//p327
		
		myCar.setSpeed(-50);
		System.out.println(myCar.getSpeed());
		
		myCar.setSpeed(60);
		System.out.println(myCar.getSpeed());
		if(!myCar.isStop()) myCar.setStop(true);
		System.out.println(myCar.getSpeed());
		
	}//main

}
