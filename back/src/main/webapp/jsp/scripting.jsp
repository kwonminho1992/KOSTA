<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scripting element : expression</h1>
	<%int i = 90; %>  <!-- expression, value = 90 -->
	<%=i %> <!-- expression -->
	<br>
	<%! int i; %> <!-- declaration -->
	<%=i %> <!-- expression, value = 90 -->
	<br>
</body>
</html>