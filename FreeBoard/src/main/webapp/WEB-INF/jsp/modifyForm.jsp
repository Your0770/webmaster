<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>수정화면</h3>
<c:if test="${msg != null }">
<p>${msg }</p>
</c:if>

<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="${boardvo.boardNo }">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${boardvo.boardNo }</td>
			<th>조회</th>
			<td>${boardvo.viewCnt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title"
				class="form-control" value="${boardvo.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="3" cols="30" name="content"
					class="form-control">${boardvo.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${boardvo.writer}</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-success" <c:set var="check" value="${logId==boardvo.writer || pm=='Admin' ? '' : 'disabled' }"></c:set><c:out value="${check}"></c:out>>저장</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</td>
		</tr>



	</table>
</form>

<script>
document.querySelector('button[type="reset"]').addEventListener('click', function(e){
	location.href = 'board.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page}&bno=${boardvo.boardNo}';
});
</script>