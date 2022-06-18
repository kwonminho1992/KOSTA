<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public void jspInit() {
	System.out.println("lifecycle_jsp 객체 생성");
}

public void jspDestroy() {
	System.out.println("lifecycle_jsp 객체 소멸");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lifecycle.jsp</title>
</head>
<body>
<%
System.out.println("lifecycle_jsp 객체의 _jspService(); 호출");
%>
</body>
</html> 