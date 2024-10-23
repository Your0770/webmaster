<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
.reply span {
	display: inline-block;
}

.reply ul {
	list-style-type: none;
}
</style>

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
<div class="container reply">
	<!-- 댓글등록 -->
	<div class="header">
		댓글내용: <input class="col-sm-8" id="reply">
		<button class="col-sm-3" id="addReply">댓글등록</button>
	</div>
	<!-- 댓글목록 -->
	<div class="content">
		<ul>
			<li><span class="col-sm-2">글번호</span> <span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-2">삭제</span></li>

			<!-- <li><span class="col-sm-2">3</span> <span class="col-sm-5">댓글입니다</span>
				<span class="col-sm-2">user1</span> <button>삭제</button></li>-->

		</ul>
	</div>
	<!-- 댓글페이징 -->
	<nav aria-label="Page navigation example">
		<ul class="pagination pagination-sm">
			<li class="page-item">
			<a class="page-link" href="#" aria-label="Previous">
			<span aria-hidden="true">&laquo;</span>
			</a></li>
			
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			
			<li class="page-item">
			<a class="page-link" href="#" aria-label="Next">
			<span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

</div>


<script>
	const bno = "${boardvo.boardNo}";
	const logId = "${logId}";

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