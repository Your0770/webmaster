<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>글목록</h3>

<form class="row g-3">
	<div class="col-md-2" action="boardList.do">
		<select name="searchCondition" class="form-select">
			<option selected value="">선택하세요.</option>
			<option value="T" ${searchCondition == "T" ? "selected" : "" }>제목</option>
			<option value="W" ${searchCondition == "W" ? "selected" : "" }>작성자</option>
			<option value="TW" ${searchCondition == "TW" ? "selected" : "" }>제목
				& 작성자</option>
		</select>
	</div>

	<div class="col-md-4">
		<input type="text" class="form-control" name="keyword"
			value='${keyword }'>
	</div>

	<div class="col-md-1">
		<button type="submit" class="btn btn-primary">검색</button>
	</div>
</form>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="board" items="${boardList }">
			<tr>
				<td><c:out value="${board.boardNo }" /></td>
				<td><a
					href='board.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page.page}&bno=${board.boardNo}'>${board.title}</a></td>
				<td><c:out value="${board.writer }" /></td>
				<td><fmt:formatDate value="${board.writeDate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><c:out value="${board.viewCnt }" /></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${page.prev }">
				<li class="page-item"><a class="page-link"
					href="boardList.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page.startPage - 1}">Previous</a>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Previous</a>
			</c:otherwise>
		</c:choose>
		</li>
		<c:forEach var="p" begin="${page.startPage }" end="${page.endPage }"
			step="1">
			<c:choose>
				<c:when test="${p == page.page }">
					<li class="page-item active" aria-current="page"><span
						class="page-link">${p }</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="boardList.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${p}">${p}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${page.next }">
				<li class="page-item"><a class="page-link"
					href="boardList.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page.endPage + 1}">Next</a>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Next</a>
			</c:otherwise>
		</c:choose>
		</li>
	</ul>
</nav>

