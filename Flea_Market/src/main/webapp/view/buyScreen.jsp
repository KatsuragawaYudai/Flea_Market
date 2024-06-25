<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,bean.Item"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dntocume</title>
</head>
<body>
<%
	User user = (User)session.getAttribute("user");
	Item item = (Item)request.getAttribute("item");
%>
<%@include file="../common/header.jsp"%>
	<form action="<%=request.getContextPath()%>/payment" style="margin: auto; ">
    <div style="text-align: center;font-size: 20px; font-weight: bold;margin: 5%;">購入画面</div>
    <div style="text-align: center;"><a style="text-align: left;display: inline-block;font-size: 22px;">商品名：<%=item.getName() %><br><br>価格：<%=item.getPrice() %>円<br><br>ご名義：<%=user.getName() %><br><br>お届け先：<%=user.getAddress() %></a>
    </div>
    <input type="hidden" name="itemId" value="<%=item.getItemId()%>"> 
    <input type="submit" value="購入確定" style="margin: auto;background: transparent;border-radius: 0.3rem;width: 20%;border-width: 1.5px; height:40px;
 line-height:30px; margin-top: 5%;margin-left: 40%;">
 
    
	</form>
</body>
</html>