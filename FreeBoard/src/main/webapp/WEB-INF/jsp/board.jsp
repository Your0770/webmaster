<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h3>상세페이지</h3>
<form action="">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${boardvo.boardNo }</td>
			<th>조회수</th>
			<td>${boardvo.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardvo.title }</td>
			<th>작성자</th>
			<td>${boardvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly rows="4" cols="30"
					class="form-control">
		${boardvo.content }
		</textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td colspan="3"><c:choose>
					<c:when test="${boardvo.img != null }">
						<img src="images/${boardvo.img}" width="150px"></td>
			</c:when>
			<c:otherwise>
				<p>No file</p>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>작성일자</th>
			<td colspan="3"><fmt:formatDate value="${boardvo.writeDate }"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="button" value="수정"
				class="btn btn-warning"> <input type="button" value="삭제"
				class="btn btn-danger"></td>
		</tr>
	</table>
</form>
<!-- 댓글 -->
<table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th>
			<th colspan="5">내용</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>

	</tbody>
</table>



<script>
	document
			.querySelector('input[value="수정"]')
			.addEventListener(
					'click',
					function(e) {
						location.href = 'modifyBoard.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page}&bno=${boardvo.boardNo}';
					});
	document
			.querySelector('input[value="삭제"]')
			.addEventListener(
					'click',
					function(e) {
						location.href = 'removeBoard.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page}&bno=${boardvo.boardNo}';
					});
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>