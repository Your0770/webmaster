package com.yedam;

import java.util.List;
import java.util.Scanner;

public class DocuDAO extends DAO {
	Scanner sc = new Scanner(System.in);
	MemberDAO memberdao = new MemberDAO();
	BookDAO bookdao = new BookDAO();
	SeatDAO seatdao = new SeatDAO();
	Member login = null;
	Book book = null;
	Seats seats = null;
	String mId = null;
	String pwd = null;
	String name = null;
	String birth = null;
	String phone = null;
	String menuNo = null;
	String bookNum = null;
	boolean run = true;
	boolean runLoginMenu = true;
	boolean runAdmin = true;
	boolean runUser = true;
	boolean runLogin = true;
	boolean runSeat = true;
	boolean runAdminSeat = true;
	
	
	void findPassword() {
		System.out.println();
		System.out.println();
		System.out.println("비밀번호 찾기 메뉴입니다.");
		System.out.println("가입되어 있는 회원님의 정보를 입력해주세요.");
		System.out.print("아이디>> ");
		mId = sc.nextLine();
		System.out.print("이름>> ");
		name = sc.nextLine();
		System.out.println("생년월일예시>> 2024-01-01");
		System.out.print("생년월일>> ");
		birth = sc.nextLine();
		System.out.println("휴대폰예시>> 010-1234-1234");
		System.out.print("휴대폰>> ");
		phone = sc.nextLine();
		
		String memPw = memberdao.findPw(mId, name, birth, phone);
		if(memPw != null) System.out.println("회원님의 비밀번호는 " + memPw + " 입니다.");
		else System.out.println("입력하신 정보의 회원정보를 찾을 수 없습니다.");
		
	}//findPassword()
	
	void findId() {
		System.out.println();
		System.out.println();
		System.out.println("아이디찾기 메뉴입니다.");
		System.out.println("가입되어 있는 회원님의 정보를 입력해주세요.");
		System.out.print("이름>> ");
		name = sc.nextLine();
		System.out.println("생년월일예시>> 2024-01-01");
		System.out.print("생년월일>> ");
		birth = sc.nextLine();
		System.out.println("휴대폰예시>> 010-1234-1234");
		System.out.print("휴대폰>> ");
		phone = sc.nextLine();
		
		String memId = memberdao.findId(name, birth, phone);
		if(memId != null) System.out.println("회원님의 아이디는 " + memId + " 입니다.");
		else System.out.println("입력하신 정보의 회원정보를 찾을 수 없습니다.");
		
	}//findId()
	
	void join() {
		System.out.println();
		System.out.println();
		System.out.println("회원가입 메뉴입니다.");
		System.out.println("아래의 항목을 각각 모두 입력해주세요.");
		System.out.print("아이디>> ");
		mId = sc.nextLine();
		System.out.print("비밀번호>> ");
		pwd = sc.nextLine();
		System.out.print("이름>> ");
		name = sc.nextLine();
		System.out.println("생년월일예시>> 2024-01-01");
		System.out.print("생년월일>> ");
		birth = sc.nextLine();
		System.out.println("휴대폰예시>> 010-1234-1234");
		System.out.print("휴대폰>> ");
		phone = sc.nextLine();
		
		int insMem = memberdao.insMem(mId, pwd, name, birth, phone);
		if(insMem == 1) System.out.println("회원가입이 성공적으로 이루어졌습니다.");
		else System.out.println("회원가입에 실패하였습니다.");
		
	}//join()
	
	void login() {
		int cnt = 0;
		while(runLogin) {
			cnt++;
			System.out.println();
			System.out.println();
			System.out.println("로그인 할 아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디>> ");
			mId = sc.nextLine();
			System.out.print("비밀번호>> ");
			pwd = sc.nextLine();
			login = memberdao.login(mId, pwd);
			if(login != null) {
				System.out.println("로그인에 성공했습니다.");
				System.out.println(login.getMemberName() + "님 환영합니다.");
				break;
			} 
			System.out.println("아이디와 비밀번호를 확인하세요.");
			if(cnt == 5) {
				System.out.println("연속으로 로그인에 실패했습니다.");
				System.out.println("로그인 메뉴로 이동합니다.");
				loginMenu();
				break;
			}
		}//while(runLogin)
		
	}//login()
	
	void loginMenu() {
		runLoginMenu = true;
		while(runLoginMenu) {
			System.out.println();
			System.out.println();
			System.out.println("로그인 메뉴입니다.");
			System.out.println("아래 메뉴를 선택해주세요.");
			System.out.println("1.로그인  2.회원가입  3.아이디찾기  4.비밀번호찾기  5.이전메뉴");
			System.out.print("선택>> ");
			String menuNo5 = sc.nextLine();
			switch(menuNo5) {
			case "1" : 
				login();
				runLoginMenu = false;
				break;
				
			case "2" : 
				join();
				break;
				
			case "3" : 
				findId();
				break;
				
			case "4" : 
				findPassword();
				break;
			case "5" : 
				System.out.println("이전메뉴로 이동합니다.");
				runLoginMenu = false;
			default  : System.out.println("메뉴를 다시 선택해주세요.");
			
			}
			
			
		}//switch(menuNo5)
	}//loginMenu()
	
	void bookLoan() {
		System.out.println();
		System.out.println();
		System.out.println("도서대여 메뉴입니다.");
		System.out.println("대여는 1권만 가능합니다.");
		System.out.println("대여할 책의 도서번호를 입력해주세요.");
		System.out.print("도서번호>> ");
		bookNum = sc.nextLine();
		book = bookdao.searchBook(bookNum);
		if(book == null ) System.out.println("도서번호를 다시 확인해주세요.");
		else {
			System.out.println("대여하려는 책이 " + book.bookName + "입니까?");
			System.out.println("예(Y)  /  아니오(N)");
			System.out.print("선택>> ");
			String menuNo1 = sc.nextLine();
			switch(menuNo1) {
			case "y" : 
			case "Y" : 
				if(book.rentMember != null) {
					System.out.println("이 도서는 이미 대여된 도서입니다.");
					System.out.println("다른 도서를 이용해 주십시오.");
					break;
				}
				
				int rentalBook = bookdao.rentBook(bookNum, login);
				book = bookdao.searchBook(bookNum);
				int renewMember = memberdao.renewMember(book, login);
				if(rentalBook == 1 && renewMember == 1) {
					System.out.println("대여가 정상적으로 완료되었습니다.");
				}else {
					System.out.println("대여에 실패했습니다.");
				}
				break;
			case "n" :
			case "N" : System.out.println("대여를 취소합니다. 메뉴로 돌아갑니다."); break;
			default  : System.out.println("다시 선택해주세요.");
			}//switch(menuNo1)
		}//else
		
	}//bookLoan()
	
	void searchBook() {
		System.out.println();
		System.out.println();
		System.out.println("도서 조회 메뉴입니다.");
		System.out.println("아래의 메뉴를 선택해주세요.");
		System.out.println("1.도서명순  2.저자순  3.도서명검색  4.저자검색  5.메인메뉴");
		System.out.print("선택>> ");
		String menuNo2 = sc.nextLine();
		switch(menuNo2) {
		case "1" : 
			System.out.println();
			System.out.println();
			System.out.println("도서명순으로 조회합니다.");
			List<Book> bookOrderName = bookdao.searchBookOrderName();
			System.out.println("도서번호\t\t도서명\t\t저자\t\t출판사\t\t\t대여인\t\t대여일\t\t\t반납일");
			for(Book bk : bookOrderName) {
				System.out.println(bk);
			}
			break;
			
		case "2" :  
			System.out.println();
			System.out.println();
			System.out.println("저자순으로 조회합니다.");
			List<Book> bookOrderWriter = bookdao.searchBookOrderWriter();
			System.out.println("도서번호\t\t도서명\t\t저자\t\t출판사\t\t\t대여인\t\t대여일\t\t\t반납일");
			for(Book bk : bookOrderWriter) {
				System.out.println(bk);
			}
			break;
			
		case "3" : 
			System.out.println();
			System.out.println();
			System.out.println("도서명으로 검색합니다.");
			System.out.println("검색할 도서명을 입력하세요.");
			System.out.print("도서명>> ");
			String bookName = sc.nextLine();
			List<Book> bookNameList = bookdao.searchBookName(bookName);
			System.out.println("도서번호\t\t도서명\t\t저자\t\t출판사\t\t\t대여인\t\t대여일\t\t\t반납일");
			for(Book bk : bookNameList) {
				System.out.println(bk);
			}
			break;
			
		case "4" : 
			System.out.println();
			System.out.println();
			System.out.println("저자를 검색합니다.");
			System.out.println("검색할 저자를 입력하세요.");
			System.out.print("저자>> ");
			String writer = sc.nextLine();
			List<Book> bookWriterList = bookdao.serchBookWriter(writer);
			System.out.println("도서번호\t\t도서명\t\t저자\t\t출판사\t\t\t대여인\t\t대여일\t\t\t반납일");
			for(Book bk : bookWriterList) {
				System.out.println(bk);
			}
			break;
			
		case "5" : 
			start();
			break;
			
		default  : 
			System.out.println("메뉴를 다시 선택해주세요.");
		}//switch(menuNo2)
		
	}//searchBook()
	
	void returnBook() {
		System.out.println();
		System.out.println();
		System.out.println("도서반납 메뉴입니다.");
		System.out.println("반납할 책의 도서번호를 입력해주세요.");
		System.out.print("도서번호>> ");
		bookNum = sc.nextLine();
		book = bookdao.searchBook(bookNum);
		if(book == null ) System.out.println("도서번호를 다시 확인해주세요.");
		else {
			System.out.println("반납하려는 책이 " + book.bookName + "입니까?");
			System.out.println("예(Y)  /  아니오(N)");
			System.out.print("선택>> ");
			String menuNo3 = sc.nextLine();
			switch(menuNo3) {
			case "y" :
			case "Y" : 
				if(book.rentMember == null) {
					System.out.println("이 도서는 이미 반납된 도서입니다.");
					break;
				}
				
				int returnBook = bookdao.returnBook(bookNum, login);
				book = bookdao.searchBook(bookNum);
				int returnMember = memberdao.returnMember(book, login);
				if(returnBook == 1 && returnMember == 1) {
					System.out.println("반납이 정상적으로 완료되었습니다.");
				}else {
					System.out.println("반납에 실패했습니다.");
				}
				break;	
				
			case "n" :
			case "N" : System.out.println("대여를 취소합니다. 메뉴로 돌아갑니다."); break;
			default  : System.out.println("다시 선택해주세요.");
			
			}//switch(menuNo3)
			
		}//else
		
	}//returnBook()
	
	void loginCheck() {
		login = memberdao.login(mId, pwd);
		if(login == null) {
			System.out.println("로그인 정보가 없습니다");
			System.out.println("로그인 메뉴로 이동합니다.");
			loginMenu();
		}
		
		
	}//loginCheck()
	
	
	void noLogin() {
		while(run) {
			System.out.println();
			System.out.println();
			System.out.println("메뉴를 선택해 주세요.");
			System.out.println("1.도서대여  2.도서조회  3.도서반납  4.좌석예약 및 반납  5.로그인  6.프로그램종료");
			System.out.print("선택>> ");
			menuNo = sc.nextLine();
			switch(menuNo) {
			case "1" :
				loginCheck();
				if(login.bookNum != null) {
					System.out.println("이미 도서를 대여하셨습니다.");
					System.out.println("대여한 도서를 반납하고 대여해주세요.");
					start();
					break;
				}
				bookLoan();
				start();
				break;
				
			case "2" : 
				searchBook();
				start();
				break;
				
			case "3" : 
				loginCheck();
				if(login.bookNum == null) {
					System.out.println("대여한 도서가 없습니다.");
					start();
					break;
				}
				returnBook();
				start();
				break;
				
			case "4" : 
				seatMenu();
				start();
				break;
				
			case "5" : 
				if(login == null) {
					loginMenu();
				}
				else if(login.getPermission().equals("Admin")) {
					adminLogin();
					break;
				}else if(login.getPermission().equals("User")){
					userLogin();
					break;
				}
				start();
				break;
				
			case "6" : 
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			
			default  : System.out.println("메뉴를 다시 선택해주세요."); 
			
			}//switch(menuNo)
			
		}//while
		
	}//noLogin()
	
	
	void adminLogin() {
		runAdmin = true;
		while(runAdmin) {
			System.out.println();
			System.out.println();
			System.out.println("관리자로 접속하셨습니다.");
			System.out.println("관리자 메뉴로 이동합니다.");
			System.out.println("관리자 메뉴입니다.");
			System.out.println("아래 메뉴를 선택해주세요.");
			System.out.println("1.회원관리  2.도서관리  3.좌석관리  4.서비스이용  5.로그아웃");
			System.out.print("선택>> ");
			String menuAdmin = sc.nextLine();
			switch(menuAdmin) {
			case "1" :
				System.out.println();
				System.out.println();
				System.out.println("회원관리 메뉴입니다.");
				System.out.println("아래 메뉴를 선택해주세요.");
				System.out.println("1.회원등록  2.회원조회  3.회원정보수정  4.회원삭제  5.메인메뉴");
				System.out.print("선택>> ");
				String menuNo1 = sc.nextLine();
				switch(menuNo1) {
				case "1" : 
					System.out.println();
					System.out.println();
					System.out.println("회원등록 메뉴입니다.");
					System.out.println("등록하실 회원의 정보를 입력해주세요.");
					System.out.println("회원가입 메뉴로 이동합니다.");
					join();
					break;
					
				case "2" : 
					System.out.println();
					System.out.println();
					System.out.println("회원조회 메뉴입니다.");
					System.out.println("아래메뉴를 선택해주세요.");
					System.out.println("1.이름순  2.등록순  3.이름검색  4.아이디검색  5.메인메뉴");
					System.out.print("선택>> ");
					String menuNo2 = sc.nextLine();
					switch(menuNo2) {
					case "1" :
						System.out.println();
						System.out.println();
						System.out.println("이름순으로 회원을 조회합니다.");
						List<Member> memberListName = memberdao.memberListName();
						System.out.println("아이디\t비밀번호\t이름\t생년월일\t\t연락처\t\t권한\t가입날짜\t\t대여좌석 여부\t책번호\t책이름\t대여일\t\t반납일");
						for(Member listName : memberListName) {
							System.out.println(listName);
						}
						break;
						
					case "2" :
						System.out.println();
						System.out.println();
						System.out.println("등록된 순서로 회원을 조회합니다.");
						List<Member> memberListTime = memberdao.memberListTime();
						System.out.println("아이디\t비밀번호\t이름\t생년월일\t\t연락처\t\t권한\t가입날짜\t\t대여좌석 여부\t책번호\t책이름\t대여일\t\t반납일");
						for(Member listTime : memberListTime) {
							System.out.println(listTime);
						}
						break;
						
					case "3" :
						System.out.println();
						System.out.println();
						System.out.println("회원 이름을 검색합니다.");
						System.out.println("검색할 이름을 입력하세요.");
						System.out.print("이름>> ");
						name = sc.nextLine();
						List<Member> memberSearchName = memberdao.memberSearchName(name);
						System.out.println("아이디\t비밀번호\t이름\t생년월일\t\t연락처\t\t권한\t가입날짜\t\t대여좌석 여부\t책번호\t책이름\t대여일\t\t반납일");
						for(Member searchName : memberSearchName) {
							System.out.println(searchName);
						}
						break;
						
					case "4" :
						System.out.println();
						System.out.println();
						System.out.println("회원 아이디를 검색합니다.");
						System.out.println("검색할 아이디를 입력하세요.");
						System.out.print("아이디>> ");
						mId = sc.nextLine();
						List<Member> memberSearchId = memberdao.memberSearchId(mId);
						System.out.println("아이디\t비밀번호\t이름\t생년월일\t\t연락처\t\t권한\t가입날짜\t\t대여좌석 여부\t책번호\t책이름\t대여일\t\t반납일");
						for(Member searchId : memberSearchId) {
							System.out.println(searchId);
						}
						break;
						
					case "5" : 
						start();
						break;
					default  :
						System.out.println("메뉴를 다시 선택해주세요.");
					}
					break;
					
				case "3" : 
					System.out.println();
					System.out.println();
					System.out.println("회원정보 수정메뉴 입니다.");
					System.out.println("정보를 수정할 회원의 아이디를 입력하세요.");
					System.out.print("아이디>> ");
					mId = sc.nextLine();
					System.out.println("정보를 수정할 회원의 정보를 입력하세요.");
					System.out.print("비밀번호>> ");
					pwd = sc.nextLine();
					System.out.print("이름>> ");
					name = sc.nextLine();
					System.out.print("생년월일>> ");
					birth = sc.nextLine();
					System.out.print("연락처>> ");
					phone = sc.nextLine();
					int updateMember = memberdao.updateMember(mId, pwd, name, birth, phone);
					if(updateMember == 1) {
						System.out.println("회원정보가 수정되었습니다.");
					} else {
						System.out.println("회원정보 수정에 실패했습니다..");
					}
					break;
					
				case "4" : 
					System.out.println();
					System.out.println();
					System.out.println("회원삭제 메뉴입니다.");
					System.out.println("삭제할 회원의 아이디를 입력하세요.");
					System.out.print("아이디>> ");
					mId = sc.nextLine();
					int deleteMember = memberdao.deleteMember(mId);
					if(deleteMember == 1) {
						System.out.println("회원삭제가 성공정으로 이루어졌습니다.");
					} else {
						System.out.println("회원삭제에 실패했습니다..");
					}
					break;
					
				case "5" : 
					start();
					break;
				default  : 
					System.out.println("메뉴를 다시 선택해주세요.");
				}
				break;
				
			case "2" :
				System.out.println();
				System.out.println();
				System.out.println("도서관리 메뉴입니다.");
				System.out.println("아래 메뉴를 선택해주세요.");
				System.out.println("1.도서등록  2.도서조회  3.도서정보수정  4.도서삭제  5.메인메뉴");
				System.out.print("선택>> ");
				String menuNo2 = sc.nextLine();
				switch(menuNo2) {
				case "1" : 
					System.out.println();
					System.out.println();
					System.out.println("도서등록 메뉴입니다.");
					System.out.println("등록할 도서 정보를 입력하세요.");
					System.out.print("도서번호>> ");
					bookNum = sc.nextLine();
					System.out.print("도서명>> ");
					String bookName = sc.nextLine();
					System.out.print("저자>> ");
					String writer = sc.nextLine();
					System.out.print("출판사>> ");
					String publisher = sc.nextLine();
					System.out.print("가격>> ");
					int price = Integer.parseInt(sc.nextLine());
					int insertBook = bookdao.insertBook(bookNum, bookName, writer, publisher, price);
					if(insertBook == 1) {
						System.out.println("도서등록이 완료되었습니다.");
					} else {
						System.out.println("도서등록에 실패하였습니다."); 
					}
					break;
					
				case "2" : 
					searchBook();
					break;
				case "3" :
					System.out.println();
					System.out.println();
					System.out.println("도서정보 수정 메뉴입니다.");
					System.out.println("수정할 도서번호를 입력하세요.");
					System.out.print("도서번호>> ");
					bookNum = sc.nextLine();
					System.out.println("수정할 정보를 입력하세요.");
					System.out.print("도서명>> ");
					bookName = sc.nextLine();
					System.out.print("저자>> ");
					writer = sc.nextLine();
					System.out.print("출판사>> ");
					publisher = sc.nextLine();
					System.out.print("가격>> ");
					try {
						price = Integer.parseInt(sc.nextLine());
						int updateBook = bookdao.updateBook(bookNum, bookName, writer, publisher, price);
						if(updateBook == 1) {
							System.out.println("도서정보가 수정되었습니다.");
						} else {
							System.out.println("도서정보 수정에 실패했습니다.");
						}
					}catch(NumberFormatException e) {
						System.out.println("숫자를 입력해주세요.");
					}
					break;
					
				case "4" : 
					System.out.println();
					System.out.println();
					System.out.println("도서삭제 메뉴입니다.");
					System.out.println("삭제할 도서번호를 입력하세요.");
					System.out.print("도서번호>> ");
					bookNum = sc.nextLine();
					int deleteBook = bookdao.deleteBook(bookNum);
					if(deleteBook == 1) {
						System.out.println("도서가 성공적으로 삭제되었습니다.");
					} else {
						System.out.println("도서삭제에 실패했습니다.");
					}
					break;
					
				case "5" : 
					start();
					break;
				default  : 
					System.out.println("메뉴를 다시 선택해주세요.");
					
				}
				break;
				
			case "3" :
				runAdminSeat = true;
				while(runAdminSeat) {
					System.out.println();
					System.out.println();
					System.out.println("좌석관리 메뉴입니다.");
					System.out.println("아래 메뉴를 선택해주세요.");
					System.out.println("1.좌석등록  2.좌석조회  3.좌석정보수정  4.좌석삭제  5.메인메뉴");
					System.out.print("선택>> ");
					String menuNo3 = sc.nextLine();
					switch(menuNo3) {
					case "1" : 
						System.out.println();
						System.out.println();
						System.out.println("좌석등록 메뉴입니다.");
						System.out.println("좌석을 등록하시겠습니까?");
						System.out.println("예(Y)  /  아니오(N)");
						System.out.print("선택>> ");
						String answer = sc.nextLine();
						switch(answer) {
						case "Y" : 
						case "y" :
							int insertSeat = seatdao.insertSeat();
							if(insertSeat == 1) {
								System.out.println("좌석등록이 완료되었습니다.");
							}else {
								System.out.println("좌석등록에 실패하였습니다.");
							}
							break;
						case "N" :
						case "n" :
							System.out.println("취소하였습니다.");
							break;
						default  :
							System.out.println("잘못된 값을 입력하셨습니다.");
						}
						break;
					case "2" : 
						List<Seats> seat = seatdao.selectSeat();
						System.out.println("번호\t대여인\t대여시간\t\t반납시간");
						for(Seats st : seat) {
							System.out.println(st);
						}
						break;
					case "3" : 
						System.out.println();
						System.out.println();
						System.out.println("좌석정보수정 메뉴입니다.");
						System.out.println("번호를 바꿀 좌석의 번호를 입력하세요.");
						System.out.print("바꿀 좌석의 번호>> ");
						int beforeNo = Integer.parseInt(sc.nextLine());
						System.out.println("몇번으로 바꿀지 입력하세요.");
						System.out.print("바껴질 좌석의 번호>> ");
						int afterNo = Integer.parseInt(sc.nextLine());
						int updateSeat = seatdao.updateSeat(beforeNo, afterNo);
						if(updateSeat == 1 ) {
							System.out.println("번호 변경이 완료되었습니다.");
						} else {
							System.out.println("번호 변경에 실패했습니다.");
						}
						
						break;
						
					case "4" : 
						System.out.println();
						System.out.println();
						System.out.println("좌석삭제 메뉴입니다.");
						System.out.println("삭제할 좌석의 번호를 입력하세요.");
						System.out.print("삭제할 좌석의 번호>> ");
						int delNo = Integer.parseInt(sc.nextLine());
						int deleteSeat = seatdao.deleteSeat(delNo);
						if(deleteSeat == 1) {
							System.out.println("삭제가 완료되었습니다.");
						} else {
							System.out.println("삭제에 실패하였습니다.");
						}
						break;
						
					case "5" : 
						runAdminSeat = false;
						start();
						break;
					default  : 
						System.out.println("메뉴를 다시 선택해주세요.");
						
					}//switch(menuNo3)
					
				}//while(runAdminSeat)
				break;
				
			case "4" :
				System.out.println();
				System.out.println("서비스이용 메뉴로 이동합니다.");
				System.out.println("관리자 메뉴로 돌아가려면 'r'키를 누르세요.");
				runAdmin = false;
				userLogin();
				break;
				
			case "5" :
				System.out.println();
				System.out.println("로그아웃합니다.");
				runAdmin = false;
				runUser = false;
				login = null;
				start();
				break;
				
			default  :
				System.out.println("메뉴를 다시 선택해주세요.");
			}//switch(menuAdmin)
			
		}//while
		
	}//adminLogin()
	
	void userLogin() {
		runUser = true;
		while(runUser) {
			System.out.println();
			System.out.println();
			System.out.println("메뉴를 선택해 주세요.");
			System.out.println("1.도서대여  2.도서조회  3.도서반납  4.좌석예약 및 반납  5.로그아웃");
			System.out.print("선택>> ");
			menuNo = sc.nextLine();
			switch(menuNo) {
			case "1" :
				loginCheck();
				if(login.bookNum != null) {
					System.out.println("이미 도서를 대여하셨습니다.");
					System.out.println("대여한 도서를 반납하고 대여해주세요.");
					break;
				}
				bookLoan();
				break;
				
			case "2" : 
				searchBook();
				break;
				
			case "3" : 
				loginCheck();
				if(login.bookNum == null) {
					System.out.println("대여한 도서가 없습니다.");
					break;
				}
				returnBook();
				break;
				
			case "4" : 
				seatMenu();
				break;
				
			case "5" : 
				System.out.println();
				System.out.println("로그아웃합니다.");
				runUser = false;
				runAdmin = false;
				login = null;
				start();
				break;
			case "r" :
			case "R" : 
				start();
				break;
				
			default  : System.out.println("메뉴를 다시 선택해주세요."); 
			
			}//switch(menuNo)
			
		}//while
		
	}//userLogin();
	
	void start() {
		if(login == null) {
			noLogin();
		}
		else if(login.getPermission().equals("Admin")) {
			adminLogin();
		}else if(login.getPermission().equals("User")){
			userLogin();
		}
	}//start()
	
	void seatMenu() {
		runSeat = true;
		while(runSeat) {
			loginCheck();
			int[] layoutX = seatdao.seatNotNull();
			System.out.println();
			System.out.println();
			seatdao.layOut(layoutX);
			System.out.println();
			System.out.println("좌석예약 및 반납 메뉴입니다.");
			System.out.println("아래 메뉴를 선택해주세요.");
			System.out.println("1.좌석예약  2.좌석반납 3. 뒤로가기");
			System.out.print("선택>> ");
			String menuNo4 = sc.nextLine();
			switch(menuNo4) {
			case "1" : 
				System.out.println();
				System.out.println();
				if(login.seatNum != 0) {
					System.out.println("이미 좌석을 대여하셨습니다.");
					System.out.println("대여한 좌석을 반납하고 대여해주세요.");
					break;
				}
				System.out.println("좌석예약 메뉴입니다.");
				System.out.println("예약할 좌석 번호를 입력하세요.");
				System.out.print("좌석번호>> ");
				int seatNum = Integer.parseInt(sc.nextLine());
				Seats searchSeat = seatdao.searchSeat(seatNum);
				if(searchSeat.rentMember != null) {
					System.out.println("이미 대여된 좌석입니다.");
					System.out.println("다른 좌석을 이용해주십시오.");
					break;
				}
				
				int seatLoan = seatdao.seatLoan(seatNum, login);
				int memberSeatLoan = memberdao.memberSeatLoan(seatNum,login);
				if(seatLoan == 1 && memberSeatLoan == 1) {
					System.out.println("좌석예약이 완료되었습니다.");
				}else {
					System.out.println("좌석예약에 실패하였습니다.");
				}
				
				break;
			case "2" :
				System.out.println();
				System.out.println();
				if(login.seatNum == 0) {
					System.out.println("대여한 좌석이 없습니다.");
					break;
				}
				System.out.println("좌석반납 메뉴입니다.");
				System.out.println("좌석을 반납하려면 비밀번호를 입력하세요.");
				System.out.print("비밀번호>> ");
				String newPwd = sc.nextLine();
				if(login.password.equals(newPwd)) {
					int seatReturn = seatdao.seatReturn(login);
					int memberSeatReturn = memberdao.memberSeatReturn(login);
					if(seatReturn == 1 && memberSeatReturn == 1) {
						System.out.println("좌석이 반납되었습니다.");
					}else {
						System.out.println("좌석 반납에 실패했습니다.");
					}
				}else {
					System.out.println("비밀번호가 맞지 않습니다.");
					System.out.println("반납에 실패했습니다.");
				}
				
				break;
			case "3" : 
				runSeat = false; 
				start();
				break;
			default  : System.out.println("메뉴를 다시 선택해주세요.");
			}//switch(menuNo4)
			
		}//while(runSeat)
		
		
	}//seatMenu()
	
	
	
	
}
