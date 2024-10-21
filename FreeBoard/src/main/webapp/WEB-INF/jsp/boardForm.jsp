<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>등록화면</h3>

<c:if test="${msg !=null }">
	<p style="color: red;">${msg }</p>
</c:if>
<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${logId }">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="30" name="content"
					class="form-control"></textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="img" class="form-control"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${logId }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-success">저장</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</td>
		</tr>



	</table>
</form>

