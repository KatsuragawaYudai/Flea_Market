<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Trade,bean.Item"%>
<%
ArrayList<Trade> trade_list = (ArrayList<Trade>) request.getAttribute("trade_list");
ArrayList<Item> item_list = (ArrayList<Item>) request.getAttribute("item_list");
%>

<style>
body {
	background-color: rgb(88, 96, 109);
	color: rgb(198, 241, 231);
}

.main table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 60%;
}

.main table tr {
	border-bottom: solid 1px #eee;
	cursor: pointer;
}
.main table th, table td {
	text-align: center;
	width: 25%;
	padding: 15px 0;
	font-size:20px;
}
a:hover {
	background-color: black;
	opacity: 0.2;
}
</style>
<html>
<head>
<title>全てのデータを表示する</title>
</head>
<body>
	<%@include file="../common/admin_header.jsp"%>
	<h2 align="center">出品一覧（管理者）</h2>
	<h2 align="center">購入前</h2>
	<table align="center" border="1px solid black">
		<tr>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px;">ID
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">出品者名
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">商品名
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">値段
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">削除
			
			</th>
		</tr>
		<%
		for (int i = 0; i < item_list.size(); i++) {
		%>
		<tr>
			<td style="text-align: center; width: 200px"><%=item_list.get(i).getItemId()%></td>
			<td style="text-align: center; width: 200px"><%=item_list.get(i).getProducer()%></td>
			<td style="text-align: center; width: 200px"><%=item_list.get(i).getName()%></td>
			<td style="text-align: center; width: 200px"><%=item_list.get(i).getPrice()%>円</td>
			<td style="text-align: center; width: 200px"><a
				href="<%=request.getContextPath()%>/adminExhibitListDelete?itemId=<%=item_list.get(i).getItemId()%>"style="text-decoration: none;color:rgb(198, 241, 231);">削除</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<h2 align="center">購入済</h2>
	<table align="center" border="1px solid black">
		<tr>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">ID
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">出品者名
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">購入者名
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">商品名
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">値段
			
			</th>
			<th
				style="background-color: rgb(198, 241, 231); color: rgb(88, 96, 109); width: 200px;font-size:20px">削除
			
			</th>

		</tr>

		<%
		for (int i = 0; i < trade_list.size(); i++) {
		%>
		<tr>
			<td style="text-align: center; width: 200px"><%=trade_list.get(i).getItemId()%></td>
			<td style="text-align: center; width: 200px"><%=trade_list.get(i).getProducer()%></td>
			<td style="text-align: center; width: 200px"><%=trade_list.get(i).getCustomer()%></td>
			<td style="text-align: center; width: 200px"><%=trade_list.get(i).getItem()%></td>
			<td style="text-align: center; width: 200px"><%=trade_list.get(i).getPayment()%>円</td>
			<td style="text-align: center; width: 200px"><a
				href="<%=request.getContextPath()%>/adminExhibitListDelete?itemId=<%=trade_list.get(i).getItemId()%>"style="text-decoration: none;color:rgb(198, 241, 231);">削除</a></td>
		</tr>
		<%} %>

	</table>
	<br>

	<br>
</body>
</html>