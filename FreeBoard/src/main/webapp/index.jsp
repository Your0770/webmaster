<%@ page import="com.yedam.service.MemberServiceImpl"%>
<%@ page import="com.yedam.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
	<!--  MVC 디자인: View(JSP 페이지) , Model (DB처리) , 컨트롤 -->

	<%	String myName = "최시훈";
		MemberService svc = new MemberServiceImpl();
		if(svc.retireMember("user02")){
	%>
			<p>삭제되었습니다.</p>
	<%		
		} else {
	%>
			<p>회원정보가 없습니다.</p>
	<%		
		}
	%>
	
	<h3>내 이름은 <%= myName %>입니다.</h3>
</body>
</html>