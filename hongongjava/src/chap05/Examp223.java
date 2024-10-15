package chap05;

public class Examp223 {

	public static void main(String[] args) {
		 int[][] array = {
				 {95, 86},
				 {83,95,96},
				 {78, 83, 93, 87, 88}
		 };
		 int sum = 0;
		 int cnt = 0;
		 double avg = 0.0;
		 for(int i = 0; i < array.length; i++) {
			 for(int su : array[i]) {
				 sum += su;
				 cnt++;
			 }
		 }
		 avg = (double)sum / cnt;
		 
		 System.out.println("sum "+ sum);
		 System.out.println("avg " + avg);
		 ;

	}//main

}
