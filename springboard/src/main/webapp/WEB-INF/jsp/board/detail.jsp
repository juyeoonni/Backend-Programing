<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세게시글입니다.
${boardVO} 

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