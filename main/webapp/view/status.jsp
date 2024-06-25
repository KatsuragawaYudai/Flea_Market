<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,bean.Trade,bean.Item,dao.TradeDao,dao.UserDao,dao.ItemDao"%>
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
	<h2>取引状況</h2>
	<table>
	<%
	Trade trade =(Trade)request.getAttribute("trade");
	String proName =(String)request.getAttribute("proName");
	String cstName =(String)request.getAttribute("cstName");
	String itmName =(String)request.getAttribute("itmName");
	%>
	
	<%
	String money;
	String traStatus;
	if(trade.getTradeStatus() == 0){
		money = "入金待ち";
		traStatus = "未発送";
	}else if(trade.getTradeStatus() == 1){
		money = "入金済";
		traStatus = "未発送";
	}else if(trade.getTradeStatus() == 2){
		money = "入金済";
		traStatus = "発送済";
	}else {
		money = "入金済";
		traStatus = "到着済";
	}
	%>
		<tr><th>購入者名</th><td><%=proName %></td></tr>
		<tr><th>出品者名</th><td><%=cstName %></td></tr>
		<tr><th>購入品名</th><td><%=itmName %></td></tr>
		<tr>
			<th>入金状況</th>
			<td><%=money %>
				<%if(trade.getTradeStatus() == 0){%>
					<form action="<%=request.getContextPath()%>/updatetrade">
					<input type="hidden" name="change" value="入金">
					<input type="hidden" name="tradeId" value="<%=trade.getTradeId() %>">
					<input type="submit" value=" 入金済に変更 ">
					</form>
				<%
				}
				%>
			</td>
		</tr>
		<tr>
			<th>発送状況</th>
			<td><%=traStatus %>
				<%if(trade.getTradeStatus() == 2){%>
					<form action="<%=request.getContextPath()%>/updatetrade">
					<input type="hidden" name="change" value="到着">
					<input type="hidden" name="tradeId" value="<%=trade.getTradeId() %>">
					<input type="submit" value=" 到着済に変更 ">
					</form>
				<%
				}
				%>
			</td>
		</tr>
		
	</table>
	<hooter><hr></hooter>
</body>
</html>