<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>수정화면</h3>
<%
String msg = (String) request.getAttribute("msg");
BoardVO board = (BoardVO) request.getAttribute("boardvo");
if (msg != null) {
%>
<p><%=msg%></p>
<%
}
%>
<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
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
				<button type="submit" class="btn btn-success">저장</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</td>
		</tr>



	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>