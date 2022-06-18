<%@page import="java.io.FileInputStream"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page buffer="1024kb" errorPage="err.jsp"%> <!-- buffer의 크기에 따라 기존내용(1~10000까지 출력)이 담긴 buffer를 auto flush해서 출력되는걸 방지할 수 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%for(int i = 1; i <= 10000; i++) {
%> <span><%=i %></span>
<%	
}
%>

<%
FileInputStream fls = null;
fls = new FileInputStream("a.txt");
%>
</body>
</html>