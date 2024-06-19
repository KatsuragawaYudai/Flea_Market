<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<String> list = new ArrayList<>();
list.add("0001");
list.add("太郎");
list.add("りんご");
list.add("1000");
ArrayList<String> list1 = new ArrayList<>();
list1.add("0002");
list1.add("次郎");
list1.add("梨");
list1.add("1100");
ArrayList<String> list2 = new ArrayList<>();
list2.add("0003");
list2.add("三郎");
list2.add("葡萄");
list2.add("1200");
%>
<html>
<head>
<title>全てのデータを表示する</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2 align="center">エラー</h2>
</body>
</html>