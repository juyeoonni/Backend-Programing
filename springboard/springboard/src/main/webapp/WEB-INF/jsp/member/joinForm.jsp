<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<a href="${pageContext.request.contextPath}/"><img alt="" src="https://pbs.twimg.com/media/Eys6wBOVgAg9MOE.jpg">
	</a>
	<a href="${pageContext.request.contextPath}/board">게시판</a>
	
	<a href="${pageContext.request.contextPath}/board/new">새글쓰기</a>
	
<!-- 	만약 currentuser가 있으면 ~님 안녕하세요 보여주고 로그아웃링크를 생성하고 없으면 로그인 링크를 생성한다 -->
	<c:if test="${empty currentUser }">
        <a href="${pageContext.request.contextPath}/login">로그인</a>
    </c:if>
    <c:if test="${not empty currentUser }">
        ${currentUser.name }님 안녕하세요.<br>
        <a href="${pageContext.request.contextPath}/login">로그아웃</a>
    </c:if>
	
	<a href="${pageContext.request.contextPath}/join">회원가입</a>
	<br>

    <h1>회원가입 페이지 입니다.</h1>
    <div align="left">
        <form:form action="${pageContext.request.contextPath }/join" method="post" modelAttribute="memberVO">
            id: <form:input path="id"/>
            <form:errors path="id"/><br> 
            password: <form:input path="password"/>
            <form:errors path="password"/><br>
            name: <form:input path="name"/>
            <form:errors path="name"/><br>
            addr: <form:input path="addr"/>
            <form:errors path="addr"/><br>                     
            <input type="submit" value="회원가입 요청">
        </form:form>
    </div>
</body>
</html>