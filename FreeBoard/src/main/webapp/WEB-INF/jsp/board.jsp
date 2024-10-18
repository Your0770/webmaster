<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("boardvo");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = sdf.format(board.getWriteDate());
String pg = (String) request.getAttribute("page");
String sc = (String) request.getParameter("searchCondition");
String kw = (String) request.getParameter("keyword");
%>

<form action="">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo()%></td>
			<th>조회수</th>
			<td><%=board.getViewCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly rows="4" cols="30"
					class="form-control">
		<%=board.getContent()%>
		</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td colspan="3"><%=wdate%></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<input type="button" value="수정" class="btn btn-warning">  
			<input type="button" value="삭제" class="btn btn-danger"> 
			</td>
		</tr>
	</table>
</form>



<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
	document.querySelector('input[value="수정"]').addEventListener('click', function(e){
		location.href = 'modifyBoard.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg%>&bno=<%=board.getBoardNo() %>';
	});
	document.querySelector('input[value="삭제"]').addEventListener('click', function(e){
		location.href = 'removeBoard.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg%>&bno=<%=board.getBoardNo() %>';
	});
	
		
</script>