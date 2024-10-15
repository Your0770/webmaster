package com.yedam;

import java.util.List;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpDAO empdao = new EmpDAO();
		boolean run = true;
		String empId = null;
		String empName = null;
		String tel = null;
		String hDate = null;
		int sal = 0;
		int menuNo = 0;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.print("메뉴 선택>> ");
			menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo){
				case 1 : 
					System.out.print("사번입력>> ");
					empId = sc.nextLine();
					System.out.print("이름입력>> ");
					empName = sc.nextLine();
					System.out.print("전화번호입력>> ");
					tel = sc.nextLine();
					System.out.print("입사일입력>> ");
					hDate = sc.nextLine();
					System.out.print("급여입력 >>");
					sal = Integer.parseInt(sc.nextLine());
					int rows = empdao.ins(empId, empName, tel, hDate, sal);
					if(rows == 1) {
						System.out.println("등록 성공");
					}else {
						System.out.println("등록 실패");
					}
					break;
					
				case 2 : 
					List<Employee> empList = empdao.selAll();
					System.out.println("사번\t이름\t전화번호\t급여");
					for(Employee em : empList) {
						System.out.printf("%s\t%s\t%s\t%d\n",em.getEmId(), em.getEmName(), em.getTel(), em.getSal());
					}
					break;
					
				case 3 : 
					System.out.print("사번입력>> ");
					empId = sc.nextLine();
					System.out.print("급여입력>> ");
					sal = Integer.parseInt(sc.nextLine());
					
					int upRows = empdao.upd(empId, sal);
					if(upRows == 1) {
						System.out.println("수정 성공");
					}else {
						System.out.println("수정 실패");
					}
					break;
					
				case 4 : 
					System.out.print("사번입력>> ");
					empId = sc.nextLine();
					int delRows = empdao.del(empId);
					if(delRows == 1) {
						System.out.println("삭제 성공");
					} else {
						System.out.println("삭제 실패");
					}
					break;
					
				case 5 :
					System.out.print("입사일자>> ");
					hDate = sc.nextLine();
					List<Employee> empList1 = empdao.sel(hDate);
					System.out.println("사번\t이름\t입사일자");
					for(Employee li : empList1) {
						System.out.printf("%s\t%s\t%s\n", li.getEmId(), li.getEmName(), li.getHireDate().substring(0,10));
					}
					break;
					
				case 6 : 
					System.out.println("프로그램을 종료합니다");
					run = false;
					break;
					
				default : 
					System.out.println("메뉴를 다시 입력해주세요");
					
			}//switch
		}//while
		sc.close();

	} //main

}
