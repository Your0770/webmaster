package 최시훈;

public class Array {

	public static void main(String[] args) {
		// 2024.09.26 과제
		//1.
		int[] ranNo = new int[10];
		for(int i = 0; i < ranNo.length; i++) {
			ranNo[i] = (int)(Math.random()*100)+1;
		}
		int sum = 0;
		int max = 0;
		int min = 100;
		for(int i = 0; i < ranNo.length; i++) {
			System.out.printf("%d ", ranNo[i]);
			sum += ranNo[i];
			if(max < ranNo[i]) max = ranNo[i];
			if(min > ranNo[i]) min = ranNo[i];
		}
		System.out.println();
		System.out.printf("합계 = %1$d 최대값 = %2$d 최소값 = %3$d", sum, max, min);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//2.
		int[][] arrays = {{1,2,3}, {1,2}, {1}, {1,2,3}};
		for(int[] array : arrays) {
			for(int su : array) {
				System.out.printf("%d ", su);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();

		//3.
		int[][] seats = new int[3][10];
		for(int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[i].length; j++)
				seats[i][j] = (int)(Math.random()*2);
		}
		int cnt = 0;
		for(int[] seat : seats) {
			for(int su : seat) {
				System.out.printf("%d ", su);
				if(su == 1) cnt++;;
			}
			System.out.println();
		}
		System.out.println("현재 관객수는 " + cnt + "명");
		
		System.out.println();
		System.out.println();

		//4.
		int[][] scores = new int[3][5];
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int)(Math.random()*51)+50;
				System.out.printf("%d\t", scores[i][j]);
			}
			System.out.println();
		}
		for(int i = 0; i < scores.length; i++) {
			int hap = 0;
			int avg2 = 0;
			for(int j = 0; j < scores[i].length; j++) {
				hap += scores[i][j];
			}
			avg2 = hap / scores[i].length;
			System.out.println((i+1) + "번 학생 평균 = " + avg2);
		}
		
		System.out.println();
		System.out.println();

		//5. 
		String[] shapes = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		for(int i = 1; i <= 5; i++) {
			int ranS = (int)(Math.random()*shapes.length);
			int ranN = (int)(Math.random()*nums.length);
			System.out.printf("%1$s의 %2$s\n", shapes[ranS], nums[ranN]);
		}
		
		System.out.println();
		System.out.println();

		//6.
		int[][] multyArr = new int[3][5];
		
		for(int i = 1; i <= 5; i++) {
			int rowNo = (int)(Math.random()*3);
			int colNo = (int)(Math.random()*5);
			if(multyArr[rowNo][colNo] == 0) multyArr[rowNo][colNo] = 1;
			else i--;
		}
		
		for(int[] array : multyArr) {
			for(int su : array) {
				System.out.printf("%d ", su);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}
