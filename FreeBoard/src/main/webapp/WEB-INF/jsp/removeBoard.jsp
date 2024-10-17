<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>삭제화면</h3>
<% BoardVO board = (BoardVO) request.getAttribute("boardvo"); %>
<p>정말 <%= board.getTitle() %>을 삭제하시겠습니까?</p>
<p>삭제하면 안의 내용은 모두 사라집니다.</p>
<p>삭제하시겠습니까?</p>
<form action="removeBoard.do" method="post">
<input type="hidden" value="<%=board.getBoardNo() %>" name="bno">
<input type="submit" class="btn btn-danger" value="예">
<input type="button" class="btn btn-secondary" value="아니오">
</form>



<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
document.querySelector('input[value="아니오"]').addEventListener('click', function(e){
	location.href = 'board.do?bno=<%=board.getBoardNo() %>';
});
</script>