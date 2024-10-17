package practice;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		String[] menu = {
				"다시"
				,"중국집"
//				,"버거킹"
//				,"편의점" 
				,"장뚝" 
//				,"돈까스" 
				,"국밥" 
//				,"맘터" 
//				,"국수" 
				,"이가네"
				};
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("엔터를 입력하세요.");
		while(run) {
			String enter = sc.nextLine();
			switch(enter) {
			case ""  : 
				int ranNo = (int)(Math.random()*menu.length);
				System.out.println(menu[ranNo]);
				break;
			case "ㅂ" :
			case "Q" :
			case "q" :
				run = false;
				break;
				
			default  :
				System.out.println();
				
			}
			
		}
		
		sc.close();
		
	} //main

}
