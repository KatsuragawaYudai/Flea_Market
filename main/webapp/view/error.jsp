<%@page contentType="text/html; charset=UTF-8"%>

<%
String error = (String)request.getAttribute("error");
String cmd = (String)request.getAttribute("cmd");
String link = (String)request.getAttribute("link");
%>
<html>
<head>
<title>全てのデータを表示する</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2 align="center">エラー</h2>
<br>
<p align="center"><%=error %></p>
<br>
<p align="center"><a href="<%= request.getContextPath() %>/<%=link %>"><%=cmd %></a>
</body>
</html>