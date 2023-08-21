<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost:8081/springmvc/method/method를 입력받아서
	WEB-INT/jsp/method/methodForm.jsp 입니다.
	<br>

	springmvc
	<form action="${pageContext.request.contextPath}/method/method"
		method="POST">
		<input type="submit" value="호출">
	</form>


</body>
</html>