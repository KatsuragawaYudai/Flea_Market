<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Trade"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dntocume</title>
</head>
<body>
<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null){
		%>
		<script type="text/javascript">
    	var msg = "<%=msg%>";
    	alert(msg);
    	</script>
		<%
	}
	%>
<%@include file="../common/header.jsp"%>
    <style>
 <style>
body{
	color: rgb(88,96,109);
}
table{
  border-collapse: collapse;
  border-spacing: 0;
  width: 60%;
}

table tr{
  border-bottom: solid 1px #eee;
  cursor: pointer;
}

table tr:hover{
 background-color: rgb(198, 241,231);
}

table th,table td{
  text-align: center;
  width: 20%;
  padding: 20px 0;
}

        </style>
    <div style="text-align: center;font-size: 25px; font-weight: bold;margin: 5%;">購入履歴</div>
    <table cellspacing="8" style="margin: auto;">
        <tr style="text-align: center;font-size: 19px;">
            <td>
                購入ID
            </td>
            <td>
                商品名
            </td>
            <td>
                日時
            </td>
            <td>
            	入金状況欄
            </td>
        </tr>
        <%
        ArrayList<Trade>list = (ArrayList<Trade>)session.getAttribute("trade_list");
        for(int i=0;i<list.size();i++){
        	 String status = null;
        	 String payStatus = null;
        	 int itemId = list.get(i).getItemId();
        	 int tradeId = list.get(i).getTradeId();
        	 String itemName =list.get(i).getItem();
        	 String date = list.get(i).getStartTime();
        	 switch(list.get(i).getTradeStatus()){
        		 case 0:
        			 payStatus = "入金待ち";
        			 break;
        		 case 1:
        			 payStatus = "入金済み";
        			 break;
        		 case 2:
        			 payStatus = "配達中";
        			 break;
        		 case 3:
        			 payStatus = "配達済み";
        			 break;
        	 }
        	 System.out.println(tradeId);
        
        %>
        <tr>
        <td><%=tradeId %></a></td>
        <td><%=itemName %></td>
        <td><%=date %></td>
        <td><a href="<%=request.getContextPath()%>/transport?tradeId=<%=tradeId %>"><%=payStatus %></td>
        </tr>
        <%} %>
</body>
</html>