package chap06;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		// 객체 생성
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		// 배열 변수를 null로 초기화 = 연결 x
		// 주소를 할당 받지 못함
		Book[] books = null;
		
		while(run) {
			System.out.println("1. 도서 수 입력 2. 도서 입력 3. 도서목록 조회 4. 도서분석 5. 종료");
			System.out.print("번호선택> ");
			int su = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(su) {
			case 1 : System.out.println("도서 수를 입력하세요");
				System.out.print("도서 수> ");
				int bookNum = Integer.parseInt(sc.nextLine());
				books = new Book[bookNum];
				break;
			
			case 2 : 
				System.out.println("도서를 입력하세요.");
				// 1)
				// books[] 배열에 값들이 null 이기때문에
				// 배열에 새로운 Book 객체를 생성해준다. 
				for(int i = 0; i < books.length; i++) {
					books[i] = new Book();
					System.out.print("도서 제목> ");
					String bName = sc.nextLine();
					System.out.print("도서 번호> ");
					int bNum = Integer.parseInt(sc.nextLine());
					System.out.print("도서 가격> ");
					int bPrice = Integer.parseInt(sc.nextLine());
					
					books[i].setName(bName); 
					books[i].setNum(bNum);
					books[i].setPrice(bPrice);
				}
				
				// 2)
				// 생성자를 생성해두면 그냥 그 값을 집어넣으면 되기 때문에
				// 객체 생성에는 생성자 함수를 만들어 두는 것이 용이하다.
//				for(int i = 0; i < books.length; i++) {
//					System.out.print("도서 제목> ");
//					String bName = sc.nextLine();
//					System.out.print("도서 번호> ");
//					int bNum = Integer.parseInt(sc.nextLine());
//					System.out.print("도서 가격> ");
//					int bPrice = Integer.parseInt(sc.nextLine());
//					books[i] = new Book(bName, bNum, bPrice);
//					
//				}
				// 3)
				// 향상된 for문은 인덱스 개념이 없어서
				// 그냥 불러오는 역할만 하기 때문에
				// 출력으로는 사용이 용이하지만
				// 값을 수정하기 위해서 사용하는 것에는 불가하다.
				// 아래의 포문은 쓰면 case3에서 출력 불가
//				for(Book buks : books) {
//					buks = new Book();
//					System.out.print("도서 제목> ");
//					String bName = sc.nextLine();
//					System.out.print("도서 번호> ");
//					int bNum = Integer.parseInt(sc.nextLine());
//					System.out.print("도서 가격> ");
//					int bPrice = Integer.parseInt(sc.nextLine());
//					
//					buks.setName(bName); 
//					buks.setNum(bNum);
//					buks.setPrice(bPrice);
//				}
				
				break;
				
			case 3 : 
				System.out.println("도서 목록을 출력합니다.");
				for(Book buk : books) {
					System.out.printf("도서 제목: %s\t도서 번호: %d\t도서 가격: %d\n", buk.getName(), buk.getNum(), buk.getPrice());
				}
				break;
				
			case 4 :
				System.out.println("도서 분석을 시작합니다.");
				int sum = 0;
				String title = null;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				for(Book bookArr : books) {
					sum += bookArr.getPrice(); //합
					if(max < bookArr.getPrice()) {
						max = bookArr.getPrice(); //최대값
						title = bookArr.getName();
					}
					if(min > bookArr.getPrice()) min = bookArr.getPrice(); //최대값
				}
				double avg = (double)sum / books.length; // 평균
				System.out.printf("도서 평균 가격 = %.2f\t최대가격 = %d\t최소가격 = %d\n", avg, max, min);
				System.out.println("가장 비싼 책 : " + title);
				break;
			case 5 : run = false; break;
			default : System.out.println("다시 입력하세요.");	
			}//switch
			
		}//while

		sc.close();
	}//main

}
