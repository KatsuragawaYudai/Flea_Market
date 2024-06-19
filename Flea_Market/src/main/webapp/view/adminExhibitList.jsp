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
<h2 align="center">出品一覧（管理者）</h2>
<form action="<%=request.getContextPath()%>/search">
<td>ID:<input type="text" name="isbn"></td> 
<td>ユーザー名:<input type="text" name="title"></td>
<td>商品名:<input type="text" name="title"></td>
<td> 値段:<input type="text" name="price"> <input type="submit" value="検索" />
<br>
 <br>

<table align="center" border="1px solid black">
		<tr>	
			<td style="background-color: gray; width: 100;">ID</td>
			<td style="background-color: gray; width: 100;">ユーザー名</td>
			<td style="background-color: gray; width: 100;">商品名</td>
			<td style="background-color: gray; width: 70">値段</td>
			<td style="background-color: gray; width: 70">削除</td>
			
		</tr>
		<tr>
		<td style="background-color: white; width: 200;"><%=list.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list.get(2)%></td>
			<td style="background-color: white; width: 200;"><%=list.get(3)%></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>
				<td style="background-color: white; width: 200;"><%=list1.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(2)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(3)%></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>
				<td style="background-color: white; width: 200;"><%=list2.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(2)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(3)%></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>
	</table>
	<br>
	
	<br>
</body>
</html>