<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${msg != null }">
<p>${msg }</p>
</c:if>

	<form action="memberAdd.do">
		<table class="table">
			<tr>
				<th>회원ID</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan='2' align="center"><input type="submit" value="저장" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
