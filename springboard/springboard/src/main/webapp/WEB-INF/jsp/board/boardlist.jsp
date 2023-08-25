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
<a href="${pageContext.request.contextPath}/"><img alt="" src="https://pbs.twimg.com/media/Eys6wBOVgAg9MOE.jpg">
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
	<br>

	전체 게시판 입니다. ${boardlist }

	<div align="center">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>지은이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach items="${boardlist }" var="board" varStatus="loop">
				<tr>
					<td>${board.no }</td>
					<td><a href="${pageContext.request.contextPath}/board/${board.no}">${board.title}</a></td>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
					<td>${board.count }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>