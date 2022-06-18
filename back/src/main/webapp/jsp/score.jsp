<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>score.jsp</title>
</head>
<body>
<%!
int count = 0;
int sum = 0;
double average = 0;
%>
<%
String scoreInString = request.getParameter("score");
int score = Integer.parseInt(scoreInString);
sum += score;
count++;
average = (double) sum / count;
%>
<%=score %> 점을 선택하셨습니다.
<br>
-----------------------------
<br>
<%
System.out.println("score : " + score);
System.out.println("sum : " + sum);
System.out.println("count : " + count);
System.out.println("average : " + average);
System.out.println("");
%><br>

총점 : <%=sum %> 점 <br>
참여인원 : <%=count %> 명 <br>
평균평점 : <%=average %> 점 <br>


</body>
</html>