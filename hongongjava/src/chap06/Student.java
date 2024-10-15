package chap06;

public class Student {
	//필드(속성)
	String stNo;
	String name;
	int kor;
	int eng;
	int math;
	
	
	//생성자(객체 생성) -> 객체의 속성을 초기화
	Student(){
		
	}
	
	Student(String stNo, String name){
		this(stNo, name, 0, 0, 0);
	}

	Student(String stNo, String name, int kor, int eng, int math){
		this.stNo = stNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드(기능)
	void study() {
		System.out.println("공부합니다.");
	}
	//총점
	int sum() {
		int result = kor + eng + math;
		return result;
	}
	//평균
	double avg() {
		double result = sum() / 3.0;
		return result;
	}
	//등급
	String grade() {
		int avg = (int) avg();
		String result = null;
		switch(avg/10) {
			case 10 : 
			case 9 : result = "A";
			break;
			case 8 : result = "B";
			break;
			case 7 : result = "C";
			break;
			case 6 : result = "D";
			break;
			default : result = "F";
		}
		return result;
	}
	//출력
	void print() {
		System.out.printf("%s\t- %3d : %3d : %3d : %3d : %5.2f : %s\n",name, kor, eng, math, sum(), avg(), grade() );
	}
	
	
	
	
}
