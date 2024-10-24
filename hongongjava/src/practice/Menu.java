package practice;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		String[] menu = {
				"다시"
//   장뚝, 바뷔치, 미성회초밥, 쌀국수, 만두, 짬뽕집, 버거킹, 편의점, 돈까스, 국밥, 맘터, 국수, 이가네, 화교집				
//				,"선분(솥밥), 소원반점(중국집), 트라이브(양식), 소머리국밥(국밥)" 
				,"장뚝" 
				,"바뷔치"
				,"미성회초밥"
				,"쌀국수"
				,"만두"
				,"짬뽕집"
				,"중국집"
				,"후라토"
//				,"버거킹"
//				,"편의점" 
				,"아웃백" 
//				,"돈까스" 
//				,"국밥" 
				,"맘터" 
				,"국수" 
				,"이가네"
				,"화교집"
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
