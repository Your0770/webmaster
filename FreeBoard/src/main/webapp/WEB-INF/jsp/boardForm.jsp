<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>등록화면</h3>
<%
String msg = (String) request.getAttribute("msg");
String logId = (String) session.getAttribute("logId");
if (msg != null) {
%>
<p><%=msg%></p>
<%
}
%>
<form action="addBoard.do" method="get">
	<input type="hidden" name="writer" value="<%=logId %>">
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
			<th>작성자</th>
			<td><%=logId %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-success">저장</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</td>
		</tr>



	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>