package 도서관리;

import java.util.Date;
import java.util.List;
//import java.util.List;
import java.util.Scanner;

public class BookMain {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		MemberDao mdao = new MemberDao();
		MemberDao mdao = MemberDao.getInstance();	// 싱글톤
		Member member = null;
		
		// 로그인 체크
		while(true) {
			System.out.print("아이디를 입력하세요 > ");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하세요 > ");
			String pw = sc.nextLine();
			
			// 정상적인 로그인 되면 이름값 출력 환영 메세지
			member = mdao.checkMember(id, pw);
			if(member != null) {
				System.out.println(member.getMemberName() + "님 환영합니다.");
				break;
			}
			System.out.println("아이디와 비밀번호를 확인하세요");
		} // 로그인 체크
		
		// 권한이 User => 도서 관리 처리
		if(member.getResponsibility().equals("User")) {
			bookManage();
		}
		
		// 권한이 Admin => 회원 관리 처리
		else if(member.getResponsibility().equals("Admin")) {
			memberManage();
		}
		
		
		
		sc.close();
	}//main
	
	static void bookManage() {	//도서관리
		// 메인메뉴
		String title = null;
		String writer = null;
		int price = 0;
		String bNum = null;
		boolean run = true;
		BookDao bdao = new BookDao();
		
		
		while(run) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서목록조회 | 4.도서삭제 | 5.도서정보수정 | 6.프로그램 종료 ");
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("번호 선택 > ");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
			
			// 선택 1번 : 도서 등록
			case 1 : 
				System.out.println("[도서 등록]");
				System.out.print("책제목 > ");
				title = sc.nextLine();
				System.out.print("저자 > ");
				writer = sc.nextLine();
				System.out.print("가격 > ");
				price = Integer.parseInt(sc.nextLine());
				System.out.print("책 번호 > ");
				bNum = sc.nextLine();
				
				bdao.ins(title, writer, price, bNum);
				
				break;
				
				// 선택 2번 : 도서 검색 => 책 제목으로 검색
			case 2 : 
				System.out.println("[도서 검색]");
				System.out.print("책 제목 > ");
				title = sc.nextLine();
				bdao.sel(title);
				break;
				
				// 선택 3번 : 도서 전체 조회
			case 3 :
				System.out.println("[도서 목록 전체 조회]");
				bdao.selAll();
				break;
				
				// 선택 4번 : 도서 삭제
			case 4 :
				System.out.println("[도서 삭제]");
				System.out.print("삭제할 책 번호 > ");
				bNum = sc.nextLine();
				bdao.del(bNum);
				
				break;
				
				// 선택 5번 : 도서 정보 수정
				//			책 제목 : 변경할 책번호, 변경할 책 가격 입력 => 수정
				
			case 5 :
				System.out.println("[도서 정보 수정]");
				System.out.println("수정할 책 제목 > ");
				title = sc.nextLine();
				System.out.println("수정할 책 번호 > ");
				bNum = sc.nextLine();
				System.out.println("수정할 책 가격 > ");
				price = Integer.parseInt(sc.nextLine());
				bdao.upd(title, bNum, price);
				
				break;
				
				// 선택 6번 : 프로그램 종료
			case 6 :  
				run = false;
				break;
				
			default : 
				System.out.println("메뉴를 다시 선택해주세요.");
				
			}//switch
			
		}//while
		
	}	//bookManage()
	
	
	static void memberManage() {	//회원관리
		System.out.println("관리자메뉴입니다.");
		boolean run = true;
		String mId = null;
		String pwd = null;
		String mName = null;
		String phone = null;
		String mRes = null;
		Date creDate = null;
		MemberDao memdao = MemberDao.getInstance();
		
		
		while(run){
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1.회원등록 | 2.회원검색 | 3.회원목록조회 | 4.회원삭제 | 5.회원정보수정 | 6.프로그램 종료 ");
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("번호 선택 > ");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
					// 선택 1번 : 회원 등록
				case 1 : 
					System.out.println("[회원등록]");
					System.out.print("회원id > ");
					mId = sc.nextLine();
					System.out.print("비밀번호 > ");
					pwd = sc.nextLine();
					System.out.print("회원이름 > ");
					mName = sc.nextLine();
					System.out.print("전화번호 > ");
					phone = sc.nextLine();
					
					int memins = memdao.memIns(mId, pwd, mName, phone);
					if(memins == 1) {
						System.out.println("insert complete");
					}else {
						System.out.println("insert failed");
					}
					break;
					
					// 선택 2번 : 회원 검색 (이름으로 검색)
				case 2 : 
					System.out.println("[회원검색]");
					System.out.print("회원 이름 > ");
					mName = sc.nextLine();
					List<Member> list = memdao.sel(mName);
					for(Member li : list) {
						System.out.println(li);
					}
					break;
					
					// 선택 3번 : 회원 목록 출력
				case 3 :
					System.out.println("[회원목록조회]");
					List<Member> listAll = memdao.memberList();
					for(Member member : listAll) {
						System.out.println(member);
					}
					break;
				
					// 선택 4번 : 회원 삭제
				case 4 :
					System.out.println("[회원삭제]");
					System.out.print("삭제할 아이디 > ");
					mId = sc.nextLine();
					int memdel = memdao.del(mId);
					if(memdel == 1) {
						System.out.println("delete complete");
					}else {
						System.out.println("delete failed");
					}
					break;
					
					// 선택 5번 : 회원 정보 수정
				case 5 : 
					System.out.println("[회원정보수정]");
					System.out.print("수정할 아이디 > ");
					mId = sc.nextLine();
					System.out.print("수정할 이름 > ");
					mName = sc.nextLine();
					System.out.print("수정할 비밀번호 > ");
					pwd = sc.nextLine();
					System.out.print("수정할 연락처 > ");
					phone = sc.nextLine();
					System.out.print("수정할 권한 > ");
					mRes = sc.nextLine();
					
					int memupd = memdao.upd(mId, mName, pwd, phone, mRes);
					if(memupd == 1) {
						System.out.println("update complete");
					}else {
						System.out.println("update failed");
					}
					break;
					
					// 선택 6번 : 프로그램 종료
				case 6 : 
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
					
				default : 
					System.out.println("메뉴를 다시 선택해주세요.");
			}
			
		}	//while
		
	}	//memberManage()

}

