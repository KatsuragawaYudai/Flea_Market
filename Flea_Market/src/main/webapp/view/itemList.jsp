<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Item"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dntocume</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
    <style>
        td{
            width: calc(100%/4);
            text-align: center;
            margin: 50%;
        }
        table,
table th,
table td {
    border: 1px solid black;
    border-collapse: collapse;
}
        </style>
    <div style="text-align: center;font-size: 25px; font-weight: bold;margin: 5%;">商品一覧</div>
    <table cellspacing="8" style="margin: auto;">
        <tr style="text-align: center;font-size: 19px;">
            <td>
                商品ID
            </td>
            <td>
                商品名
            </td>
            <td>
                値段
            </td>
        </tr>
        <%
        ArrayList<Item>list = (ArrayList<Item>)session.getAttribute("item_list");
        for(int i=0;i<list.size();i++){
        	int id = list.get(i).getItemId();
        	String name = list.get(i).getName();
        	int price = list.get(i).getPrice();
        
        %>
        <tr>
            <td>
                <%=id %>
            </td>
            <td>
                <a href="<%=request.getContextPath() %>/goodsDetail.jsp/itemName=<%=name%>"><%=name %></a>
            </td>
            <td>
                <%=price %>円
            </td>
        </tr>
        <%} %>
    </table>
</body>
</html>