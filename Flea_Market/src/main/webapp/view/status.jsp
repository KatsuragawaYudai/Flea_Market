<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,bean.Trade"%>
<html>
<head>
<meta charset="UTF-8">
<title>システム</title>

<body>
<%@include file="../common/header.jsp"%>
	<h2>配送状況</h2>
	<table>
		<tr><th>購入者名</th><td>神田たろう</td></tr>
		<tr><th>出品者名</th><td>神田はなこ</td></tr>
		<tr><th>購入品名</th><td>馬鹿でもわかるJava入門</td></tr>
		<tr><th>期限</th><td>2024/06/28</td></tr>
		<tr><th>ステータス</th><td><select name="status">
						<option value="1">発送準備中</option>
						<option value="2">発送済み</option>
					</select><input type="submit" value="変更"></td></tr>
	</table>
	<hooter><hr></hooter>
</body>
</html>