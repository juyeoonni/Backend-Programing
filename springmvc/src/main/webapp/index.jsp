<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
index입니다.
<%-- <a href="<%= request.getContextPath()%>/hello/hello">HelloController</a> --%>
<a href="${pageContext.request.contextPath}/hello/hello">HelloController</a><br/>
<a href="${pageContext.request.contextPath}/method/method">MethodController</a><br/>


reqeust.servletPath : ${pageContext.request.servletPath} <br/>
request.contextPath: ${pageContext.request.contextPath } 



</body>
</html>