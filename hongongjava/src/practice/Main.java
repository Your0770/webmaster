package practice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		if(A.equals(A)) A += "??!";
		System.out.println(A);
		
		sc.close();
	}

}
