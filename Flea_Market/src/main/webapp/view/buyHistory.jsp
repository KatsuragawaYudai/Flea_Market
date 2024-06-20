<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Trade"%>
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
                発送状況
            </td>
            <td>
            <!-- 仕様変更　入金状況欄追加 -->
            </td>入金状況欄</td>
        </tr>
        <%
        ArrayList<Trade>list = session.getAttribute("trade_list");
        for(int i=0;i<list.size();i++){
        	 int itemId = list.get(i).getItemId();
        	 int =list.get(i).get
        
        %>
        <tr>
        <td><%tradelist. %></td>
        <!-- 入金状況 payment.jspに遷移　-->
        </td></td>
        </tr>
</body>
</html>