<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Trade,bean.Item"%>
<%
ArrayList<Trade> trade_list = (ArrayList<Trade>) request.getAttribute("trade_list");
%>

<html>
<head>
<title>全てのデータを表示する</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2 align="center">出品一覧（ユーザー）</h2>
<br>
<br>
<table align="center" border="1px solid black">
  <h3 align="center"></h3>
    <tr>  
      <td style="background-color: gray; width: 100;">商品名</td>
      <td style="background-color: gray; width: 70">値段</td>
      <td style="background-color: gray; width: 70">発送状況欄</td>
      
    </tr>
    <!-- 発送前と発送済みでテーブルを分ける -->
    <%
    if (trade_list != null) {
      String status = "";
      for (int i = 0; i < trade_list.size(); i++) {
        Trade trade = (Trade) trade_list.get(i);
        if (trade.getTradeStatus() == -1) {
          status = "購入されていません";
        } else if(trade.getTradeStatus() == 0){
          status = "送金前";
        } else if(trade.getTradeStatus() == 1){
          status = "発送してください";
        } else if(trade.getTradeStatus() == 2){
          status = "発送済み";
        } else if (trade.getTradeStatus() == 3) {
          status = "配達済み";
        } else {
         status = "error"; 
        }
    %>
    <tr>
    <td style="background-color: white; width: 200;"><%=trade.getItem()%></td>
      <td style="background-color: white; width: 200;"><%=trade.getPayment()%>円</td>
    <%
    if(trade.getTradeStatus() == 1){
      %>
      <td style="background-color: white; width: 200;"><a href="<%=request.getContextPath()%>/shipping?trade_id=<%=trade.getTradeId()%>"><%=status%></a></td>
<%}else{ %>
      <td style="background-color: white; width: 200;"><%=status%></td>
      <%} %>
    </tr>
    <%
      }}
    %>
  </table>

</body>
</html>