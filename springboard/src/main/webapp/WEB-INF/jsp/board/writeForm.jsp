<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error{
		color:red
	}
</style>
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
	<br>

<h1>새글입니다.</h1>
	<div>
		<form:form	action="${pageContext.request.contextPath }/board/new" 
				method="post" modelAttribute="boardVO" >	
			<table>	
				<tr>
					<th>제목</th>
					<td><form:input path="title" />  </td>
					<td><form:errors path="title" class="error"/> </td>	  
				</tr>		
				<tr>
					<th> 글쓴이</th>
					<td><form:input path="writer" /></td>	
					<td><form:errors path="writer" class="error"/> </td>
				</tr>
				<tr>
					<th> 내용</th>
					<td><form:input path="content" /></td>
					<td><form:errors path="content" class="error"/> </td>
				</tr>				
			</table>
			<input type="submit" value="새글쓰기">	
		</form:form>
		
	</div>


</body>
</html>