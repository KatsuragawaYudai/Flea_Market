<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,bean.Trade,bean.Item,dao.TradeDao,dao.UserDao,dao.ItemDao"%>
<%
Trade trade = (Trade) request.getAttribute("trade");
%>
<html>
<head>
<meta charset="UTF-8">
<title>フリっとマケっと</title>

<body>
<%@include file="../common/header.jsp"%>
	<style>
		table {
		margin:auto;
		}
		#listtable {
			margin-bottom: 30%;
		}
		h2 {
			text-align:center;

		}
		th {
		    width:200px;
		}
		tr{
			text-align: center;
		}
		td {
		    border: 1px solid black;
		}
    </style>
	<h2>配送状況</h2>
	<table>
		<tr><th>購入者名</th><td><%= trade.getCustomer()%></td></tr>
		<tr><th>出品者名</th><td><%= trade.getProducer()%></td></tr>
		<tr><th>購入品名</th><td><%= trade.getItem()%></td></tr>
		<tr><th>期限</th><td>2024/06/28</td></tr>
		<form action="<%=request.getContextPath()%>/shipping?">
		<input type="hidden" name = "trade_id" value = "<%= trade.getTradeId() %>">
		<tr><th>ステータス</th>
		<td><select name="status">
						<option value="1">発送準備中</option>
						<option value="2">発送済み</option>
					</select><input type="submit" value="変更"></td></tr>
	</table>
	<hooter><hr></hooter>
</body>
</html>