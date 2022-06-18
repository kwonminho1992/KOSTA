<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>
<%int i = 99; %>
<div style="border:1px solid black">
<%@include file="include_sub.jsp" %>
</div> <!-- include_sub.jsp의 실행결과를 포함, include.jsp의 자바코드도 연산됨 -->


<div style="border:1px solid black">
<jsp:include page="include_sub.jsp"></jsp:include>
</div> <!-- include_sub.jsp의 실행결과만을 포함 -->

</body>
</html>