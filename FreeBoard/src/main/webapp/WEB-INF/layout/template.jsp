<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title><tiles:getAsString name="title" /></title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<div class="sidebar-heading border-bottom bg-light">Start
				Bootstrap</div>
			<div class="list-group list-group-flush">
				<c:if test="${pm == 'Admin' }">
					<a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="memberList.do">회원목록</a>
					<a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="memberAddForm.do">회원등록화면</a>
				</c:if>
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="boardList.do">게시글목록</a>
				<c:choose>
					<c:when test="${logId == null }">
						<a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="loginForm.do">로그인</a>
					</c:when>
					<c:otherwise>
						<a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="addBoardForm.do">게시글등록화면</a>
						<a
							class="list-group-item list-group-item-action list-group-item-light p-3"
							href="logout.do">로그아웃(${logId})</a>
					</c:otherwise>
				</c:choose>
				<a	class="list-group-item list-group-item-action list-group-item-light p-3"
					href="javascript.do">자바스크립트 연습</a>
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
					href="chart.do">차트</a>
				<a	class="list-group-item list-group-item-action list-group-item-light p-3"
					href="fullCalendar.do">캘린더</a>
				<a	class="list-group-item list-group-item-action list-group-item-light p-3"
					href="exe1.do">exe1</a>
				<a	class="list-group-item list-group-item-action list-group-item-light p-3"
					href="exe2.do">exe2</a>
			</div>
		</div>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<div class="container-fluid">
					<button class="btn btn-primary" id="sidebarToggle">Toggle
						Menu</button>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ms-auto mt-2 mt-lg-0">
							<li class="nav-item active"><a class="nav-link" href="#!">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Dropdown</a>
								<div class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#!">Action</a> <a
										class="dropdown-item" href="#!">Another action</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#!">Something else here</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Page content-->
			<div class="container-fluid">
				<tiles:insertAttribute name="body" />

			</div>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
