<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/"><img alt=""
		src="https://pbs.twimg.com/media/Eys6wBOVgAg9MOE.jpg">
	</a>
	<a href="${pageContext.request.contextPath}/board">게시판</a>

	<a href="${pageContext.request.contextPath}/board/new">새글쓰기</a>

	<!-- 	만약 currentuser가 있으면 ~님 안녕하세요 보여주고 로그아웃링크를 생성하고 없으면 로그인 링크를 생성한다 -->
	<c:if test="${empty currentUser }">
		<a href="${pageContext.request.contextPath}/login">로그인</a>
	</c:if>
	<c:if test="${not empty currentUser }">
        ${currentUser.name }님 안녕하세요.
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>

	<a href="${pageContext.request.contextPath}/join">회원가입</a>
	<br> 상세게시글입니다. ${boardVO}

	<div align="center">
		<table border="1" width="60%">
			<tr>
				<th>번호</th>
				<th>${boardVO.no}</th>
			</tr>

			<tr>
				<th>제목</th>
				<th>${boardVO.no}</th>
			</tr>

			<tr>
				<th>글쓴이</th>
				<th>${boardVO.writer}</th>
			</tr>

			<tr>
				<th>등록일</th>
				<th>${boardVO.regDate}</th>
			</tr>

			<tr>
				<th>내용</th>
				<th>${boardVO.content}</th>
			</tr>
			<tr>
			<tr>
				<th>조회수</th>
				<th>${boardVO.count}</th>
			</tr>

		</table>

	</div>
</body>
</html>