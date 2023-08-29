<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('${msg}')
		alert('${msg}')
</script>
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
	
<h1>로그인 페이지 입니다.</h1>
<h1><spring:message code="label.title"></spring:message> </h1>

	<div align="left">
		<form:form action="${pageContext.request.contextPath }/login" 
			method="post" modelAttribute="loginVO" >
			id: <form:input path="id"/> 
				<form:errors path="id"/> <br>
			password: <form:input path="password"/>
						<form:errors path="password"/> <br>
			<input type="submit" value="로그인"><br>
		</form:form>
	</div>

</body>
</html>




