<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  

	<a href="${pageContext.request.contextPath }/">
		<img  src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png">
	</a>
	<a href="${pageContext.request.contextPath }/board">게시판</a> 
	<a href="${pageContext.request.contextPath }/board/new">새글쓰기</a> 
	<c:if test="${empty currentUser}">
		<a href="${pageContext.request.contextPath }/login">로그인</a> 
	</c:if>
	<c:if test="${not empty currentUser}">		
		<a href="${pageContext.request.contextPath }/logout">로그아웃</a> 
		${currentUser.name }님 안녕하세요. 
	</c:if>
	
	 <h1> Welcome</h1>
</body>
</html>









