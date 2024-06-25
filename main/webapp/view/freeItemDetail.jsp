<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Item"%>

<html>
<head>
<title></title>
<meta charset="UTF-8">
</head>
<body>
<%@include file="../common/header.jsp"%>
}
    </style>
	<h2 align="center">商品詳細画面</h2>
	


	<table style="margin: auto; text-align: center; margin-bottom: 300px">
		<%
			Item item = (Item)request.getAttribute("item");
			String name =item.getName();
			int price = item.getPrice();
			String remark = item.getRemark();
					
		%>	
		
			
		<form action="<%=request.getContextPath()%>/view/userinsert.jsp">
			<tr>
				
				<td style="background-color: gray; width: 80px">商品名</td>
				<td style="background-color: white; width: 100px"><%=name %></td>
			</tr>
			
			<tr>
				<td style="background-color: gray; width: 80px">価格</td>
				<td style="background-color: white; width: 100px"><%=price %>円</td>
			</tr>
			
			<tr> 
				<td style="background-color: gray; width: 80px">備考</td>
				<td><%=remark %></td>
			</tr>
			<tr><td colspan="2">
			<input type=submit value="購入"></td></tr>
			
		</form>
	</table>
	
	

</body>
</html>