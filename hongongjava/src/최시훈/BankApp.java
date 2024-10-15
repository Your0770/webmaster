package 최시훈;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] accounts = new Account[100];
		boolean run = true;
		int cnt = 0;
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
			case 1 : 
				System.out.println("---------");
				System.out.println("계좌생성");
				System.out.println("---------");
				System.out.print("계좌번호: ");
				String ano = sc.nextLine();
				System.out.print("계좌주: ");
				String owner = sc.nextLine();
				System.out.print("초기입금액: ");
				int balance = Integer.parseInt(sc.nextLine());
				
				if(acCheck(accounts, ano)) {
					System.out.println("계좌 생성에 실패했습니다.");
				}else {
					accounts[cnt] = new Account(ano, owner, balance);
					System.out.println("계좌가 생성되었습니다.");
					cnt++;
				}
				break;
				
			case 2 : 
				System.out.println("---------");
				System.out.println("계좌목록");
				System.out.println("---------");
				
				quit2 : for(int i = 0; i < accounts.length; i++) {
					if(accounts[i] != null) {
						System.out.printf("%s\t%s\t%d\n", accounts[i].getAno(), accounts[i].getOwner(), accounts[i].getBalance());
					}else break quit2;
				}
				break;
				
			case 3 : 
				System.out.println("---------");
				System.out.println("예금");
				System.out.println("---------");
				System.out.print("계좌번호: ");
				String ano3 = sc.nextLine();
				System.out.print("예금액: ");
				int inMoney = Integer.parseInt(sc.nextLine());
				
//				메소드 사용안함
//				quit3 : for(int i = 0; i < accounts.length; i++) {
//					if(accounts[i] != null) {
//						if(accounts[i].getAno().equals(ano3)) {
//							accounts[i].inMoney(accounts[i].getBalance(), inMoney);
//						}
//					}else break quit3;
//				}
				
//				메소드 사용
				if(acCheck(accounts, ano3)) {
					accounts[idxCheck(accounts, ano3)].inMoney(accounts[idxCheck(accounts, ano3)].getBalance(), inMoney);
//					aCheck(accounts, ano3).inMoney(aCheck(accounts, ano3).getBalance(), inMoney);
				}
				break;
				
			case 4 : 
				System.out.println("---------");
				System.out.println("출금");
				System.out.println("---------");
				System.out.print("계좌번호: ");
				String ano4 = sc.nextLine();
				System.out.print("출금액: ");
				int outMoney = Integer.parseInt(sc.nextLine());
				
//				메소드 사용안함
//				quit4 : for(int i = 0; i < accounts.length; i++) {
//					if(accounts[i] != null) {
//						if(accounts[i].getAno().equals(ano4)) {
//							accounts[i].outMoney(accounts[i].getBalance(), outMoney);
//						}
//					}else break quit4;
//				}
				
//				메소드 사용
				if(acCheck(accounts, ano4)) {
//					accounts[idxCheck(accounts, ano4)].outMoney(accounts[idxCheck(accounts, ano4)].getBalance(), outMoney);
					aCheck(accounts, ano4).outMoney(aCheck(accounts, ano4).getBalance(), outMoney);
				}
				break;
				
			case 5 : run = false; break; 
			
			default : System.out.println("메뉴를 다시 선택해주세요."); 
			}//switch
			
		}//while

		sc.close();
	}//main

	//method
	//중복된 계좌
		static boolean acCheck(Account[] acc, String ano) {
			for(int i = 0; i < acc.length; i++) {
				if(acc[i] != null) {
					if(acc[i].getAno().equals(ano)) {
						return true;
					}
				}
			}
			return false;
		}
	//계좌 값이 같을때의 idx값 리턴	
		static int idxCheck(Account[] acc, String ano) {
			int i = 0;
			for(i = 0; i < acc.length; i++) {
				if(acc[i] != null) {
					if(acc[i].getAno().equals(ano)) {
						return i;
					}
				}
			}
			return i;
		}
		
//	 계좌 값이 같을때 향상된 for문 이용
		static Account aCheck(Account[] acc, String ano) {
			Account ac = null;
			for(Account A : acc) {
				if(A != null) {
					if(A.getAno().equals(ano)) {
						ac = A;
					}
				}
			}
			return ac;
		}
		
}//class
