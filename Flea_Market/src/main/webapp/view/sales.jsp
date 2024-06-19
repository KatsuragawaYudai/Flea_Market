<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Trade" %>
<%@page import="servlet.Trade" %>

<%ArrayList<Trade> list =(ArrayList<Trade>)request.getAttribute("list");%>
 

<html>
<head>
<title>売上</title>
<meta charset="UTF-8">
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2 h2 align="center">売上</h2>


	<div style="margin-bottom:250px">
			<table style="margin:auto">
				<tr>
					<th style="background-color:#6666ff; width:250px">日付(yyyy-mm-dd)</th>
					<th style="background-color:#6666ff; width:150px">取引ID</th>
					<th style="background-color:#6666ff; width:150px">出品者名</th>
					<th style="background-color:#6666ff; width:150px" >購入者</th>
					<th style="background-color:#6666ff; width:150px" >売上金額</th>
					
				</tr>
				
				<%
				if(list != null){
					for(int i=0; i<list.size(); i++){
						Trade trade =list.get(i);
				%>
				
				<tr>
					<td style="text-align:center; width:250px"><%trade.getUpdateTime()%></td>
					<td style="text-align:center; width:150px"><%trade.getTradeId()%></td>
					<td style="text-align:center; width:150px"><%trade.getProducerId() %></td>
					<td style="text-align:center; width:150px"><%trade.getCustomerId() %></td>
					<td style="text-align:left; width:150px"><%trade.getPayment() %></td>
					
				</tr>
				
				<%
					}
				}
				
				int totalPayment =0;
				int totalEarning =0;
				
				if(list !=null){
					for(int i=0; i<list.size(); i++){
						Trade trade =list.get(i);
						totalPayment += trade.getPayment();
						totalEarning += trade.getEarning();
					}
				}
				%>
				
				
							
			</table>
			
			<hr	style="text-align: center; height: 1px; background-color: black; width: 950px">

			<table >list
				<form  action="<%=request.getContextPath()%>/" >
				<tr style="text-align: center; width: 100px"><td  style="background-color: #6666ff ">売上合計</td>
					<td>\<%=totalPayment %></td>
				</tr>
				<tr style="text-align: center; width: 100px"><td  style="background-color: #6666ff ">手数料合計</td>
					<td>\<%=totalEarning%></td>
				</tr>		
				</form>
			</table

			</table>
		</div>

</body>
</html>