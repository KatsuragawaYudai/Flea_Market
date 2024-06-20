<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("0001");
list1.add("りんご");
list1.add("1000");

ArrayList<String> list2 = new ArrayList<>();
list2.add("0002");
list2.add("洋ナシ");
list2.add("1000");
%>
<html>
<head>
<title>全てのデータを表示する</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2 align="center">出品一覧（ユーザー）</h2>
<br>
<br>
<table align="center" border="1px solid black">
	<h3 align="center">発送が完了しています</h3>
		<tr>	
			<td style="background-color: gray; width: 100;">ID</td>
			<td style="background-color: gray; width: 100;">商品名</td>
			<td style="background-color: gray; width: 70">値段</td>
			<td style="background-color: gray; width: 70">発送状況欄</td>
			<td style="background-color: gray; width: 70">削除</td>
			
		</tr>
		<!-- 発送前と発送済みでテーブルを分ける -->
		<tr>
		<td style="background-color: white; width: 200;"><%=list1.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(2)%></td>
			<td style="background-color: white; width: 200;"><a href="status.jsp">発送前</a></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>
				<tr>
		<td style="background-color: white; width: 200;"><%=list2.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(2)%></td>
			<td style="background-color: white; width: 200;"><a href="status.jsp">発送前</a></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>
	</table>
<br>
<br>
<br>
	<table align="center" border="1px solid black">
		<h3 align="center">発送が完了していません</h3>
		<tr>	
			<td style="background-color: gray; width: 100;">ID</td>
			<td style="background-color: gray; width: 100;">商品名</td>
			<td style="background-color: gray; width: 70">値段</td>
			<td style="background-color: gray; width: 70">発送状況欄</td>
			<td style="background-color: gray; width: 70">削除</td>
			
		</tr>
		<!-- 発送前と発送済みでテーブルを分ける -->
		<tr>
		<td style="background-color: white; width: 200;"><%=list1.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list1.get(2)%></td>
			<td style="background-color: white; width: 200;"><a href="status.jsp">発送済み</a></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>
				<tr>
		<td style="background-color: white; width: 200;"><%=list2.get(0)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(1)%></td>
			<td style="background-color: white; width: 200;"><%=list2.get(2)%></td>
			<td style="background-color: white; width: 200;"><a href="status.jsp">発送済み</a></td>
			<td style="background-color: white; width: 200;"><a href="https:/あ/">削除</a></td>
		</tr>

	</table>

</body>
</html>