<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	if (list == null) {
		response.getWriter().print("<p>회원목록을 불러올수 없습니다.</p>");
	} else {
		System.out.println(list);
	%>
	<h3>회원목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>연락처</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MemberVO mvo : list) {
			%>
			<tr>
				<td><%=mvo.getMemberId()%></td>
				<td><%=mvo.getMemberName()%></td>
				<td><%=mvo.getPhone()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>
