<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글목록</h3>

<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
PageDTO paging = (PageDTO) request.getAttribute("page");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
kw = kw ==null ? "" : kw;



%>
<form class="row g-3">

    <div class="col-md-2" action="boardList.do">
    <select name="searchCondition" class="form-select">
      <option selected value="">선택하세요.</option>
      <option value="T" <%=(sc !=null && sc.equals("T") ? "selected" : "") %>>제목</option>
      <option value="W" <%=(sc !=null && sc.equals("W") ? "selected" : "") %>>작성자</option>
      <option value="TW" <%=(sc !=null && sc.equals("TW") ? "selected" : "") %>>제목 & 작성자</option>
    </select>
  </div>
  
  <div class="col-md-4">
    <input type="text" class="form-control" name="keyword" value='<%=kw%>'>
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
		<%
		for (BoardVO board : list) {
			String wdate = sdf.format(board.getWriteDate());
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>	
			<td><a href='board.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=paging.getPage() %>&bno=<%=board.getBoardNo()%>'><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=wdate%></td>
			<td><%=board.getViewCnt() %>
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <%if(paging.isPrev()) { %>
    	<li class="page-item">
      		<a class="page-link" href="boardList.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=paging.getStartPage()-1%>">Previous</a>
    <% } else { %>
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
      <%} %>
    </li>
    <% for(int p = paging.getStartPage(); p <= paging.getEndPage(); p++){ 
 		if(p == paging.getPage()){
    %>
 			<li class="page-item active" aria-current="page">
      				<span class="page-link"><%=p %></span></li>			
    <%
 		} else {
    %>
    <li class="page-item"><a class="page-link" href="boardList.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=p %>"><%=p %></a></li>
    <%		}
 		}%>
    <%if(paging.isNext()) { %>
    	<li class="page-item">
      		<a class="page-link" href="boardList.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=paging.getEndPage()+1%>">Next</a>
    <% } else { %>
    <li class="page-item disabled">
      <a class="page-link">Next</a>
      <%} %>
    </li>
  </ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>
