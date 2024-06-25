<%@page import="bean.Trade"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<Trade> list = (ArrayList<Trade>) request.getAttribute("list");
%>


<html>
<head>
<title>売上</title>
<meta charset="UTF-8">
</head>
<body>
	<style>
	body{
	background-color:rgb(88,96,109);
	color: rgb(198, 241,231);
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

table tr:hover {
	background-color: rgb(198, 241, 231);
	color: rgb(88,96,109);
}

.main table th, table td {
	text-align: center;
	width: 25%;
	padding: 15px 0;
	font-size:20px;
}
</style>
	<%@include file="../common/admin_header.jsp"%>
	<h2 h2 align="center">売上</h2>


	<div style="margin-bottom:250px">
			<table style="margin:auto">
				<tr>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:250px">日付</th>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:150px">取引ID</th>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:150px">商品名</th>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109);width:150px">出品者名</th>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:150px" >購入者</th>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:150px" >売上金額</th>
					<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:150px" >手数料</th>
					
				</tr>
				
				<%
				int totalPayment =0;
				int totalEarning =0;
				
				if(list !=null){
					for(int i=0; i<list.size(); i++){
						Trade trade =list.get(i);
						totalPayment += trade.getPayment();
						totalEarning += trade.getEarning();
					}
				}
				
				
				if(list != null){
					for(int i=0; i<list.size(); i++){
						Trade trade =list.get(i);
				%>
				
				<tr>
					<td style="text-align:center; width:250px"><%=trade.getUpdateTime()%></td>
					<td style="text-align:center; width:150px"><%=trade.getTradeId()%></td>	
					<td style="text-align:center; width:150px"><%=trade.getItem()%></td>									
					<td style="text-align:center; width:150px"><%=trade.getProducer() %></td>
					<td style="text-align:center; width:150px"><%=trade.getCustomer() %></td>
					<td style="text-align:left; width:150px"><%=trade.getPayment() %>円</td>
					<td style="text-align:left; width:150px"><%=trade.getEarning() %>円</td>
					

				
				<%
					}
				}
				
				
				%>
				
				
							
			</table>
			
			<hr	style="text-align: center; height: 1px; background-color: black; width: 950px">

			<table class="side" style="margin-left:65%">
				<form  action="<%=request.getContextPath()%>/" >
				<tr><td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109);">売上合計</td>
					<td><%=totalPayment %>円</td>
				</tr>
				<tr><td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109);">手数料合計</td>
					<td><%=totalEarning%>円</td>
				</tr>		
				</form>
			</table>

			</table>
		</div>
</body>
</html>