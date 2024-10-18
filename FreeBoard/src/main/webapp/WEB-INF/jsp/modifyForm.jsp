<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>수정화면</h3>
<%
String msg = (String) request.getAttribute("msg");
String pg = (String) request.getAttribute("page");
String kw = (String) request.getAttribute("keyword");
String sc = (String) request.getAttribute("searchCondition");
String logId = (String) session.getAttribute("logId");
BoardVO board = (BoardVO) request.getAttribute("boardvo");
if (msg != null) {
%>
<p><%=msg%></p>
<%
}
%>
<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
	<input type="hidden" name="page" value="<%=pg%>">
	<input type="hidden" name="keyword" value="<%=kw%>">
	<input type="hidden" name="searchCondition" value="<%=sc%>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo()%></td>
			<th>조회</th>
			<td><%=board.getViewCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title"
				class="form-control" value="<%=board.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="3" cols="30" name="content"
					class="form-control"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter()%></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-success" <%=logId != null && logId.equals(board.getWriter()) ? "" : "disabled" %>>저장</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</td>
		</tr>



	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
document.querySelector('button[type="reset"]').addEventListener('click', function(e){
	location.href = 'board.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg%>&bno=<%=board.getBoardNo()%>';
});
</script>