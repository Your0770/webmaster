package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 2개를 던져서 합이 5가 되면 종료 - game over
		// 5가 아니면 (1,3) 주사위 눈 표시
		// gameover가 몇번만에 나왔는지?
		
		int count = 0;         // 반복문 안에 넣으면 반복할때마다 0으로 초기화 되니까 밖으로 빼야함
		while(true) {
			int dice1 = (int)(Math.random()*6) + 1;
			int dice2 = (int)(Math.random()*6) + 1;
			if(dice1 + dice2 != 5) {
				System.out.printf("(%1$d,%2$d) ", dice1, dice2);
				count++;
			}else {
				System.out.println("\ngame over " + count);
				break;
			}
		}
		
		// 주사위 눈이 1이면 1등 ~ 6이면 6등이라고 출력
		int dice3 = (int)(Math.random()*6)+1;
		System.out.println(dice3 + "등");
		
		// if문
		if(dice3 == 1) System.out.println("1등");
		if(dice3 == 2) System.out.println("2등");
		if(dice3 == 3) System.out.println("3등");
		if(dice3 == 4) System.out.println("4등");
		if(dice3 == 5) System.out.println("5등");
		if(dice3 == 6) System.out.println("6등");
		
		// switch문
		switch(dice3) {
			case 1 : System.out.println("1등"); break;
			case 2 : System.out.println("2등"); break;
			case 3 : System.out.println("3등"); break;
			case 4 : System.out.println("4등"); break;
			case 5 : System.out.println("5등"); break;
			case 6 : System.out.println("6등"); break;
			default : System.out.println("다시시도"); break;
		}
		
		// 50에서 100까지 수를 발생
		// 90 이상이면 A, 80이상이면 B,70이상이면 C, 60이상이면 D, 나머지 F 표시
		// switch문으로 표시
//		int score = 100;    //점수 대입 해보기
		int score = (int)(Math.random()*51)+50;
		
		switch(score/10) {
			case 10 :
			case 9 : System.out.println(score + "점 : A등급"); break;
			case 8 : System.out.println(score + "점 : B등급"); break;
			case 7 : System.out.println(score + "점 : C등급"); break;
			case 6 : System.out.println(score + "점 : D등급"); break;
			default : System.out.println(score + "점 : F등급");
		}

		
		
		
		
		
		

	}

}
