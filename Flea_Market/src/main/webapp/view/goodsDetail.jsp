<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title></title>
<meta charset="UTF-8">
</head>
<body>
<%@include file="../common/header.jsp"%>
	<h2 align="center">商品詳細画面</h2>



	<table style="margin: auto; text-align: center; margin-bottom: 300px">
			
		
			
		<form action="buyScreen.jsp">
			<tr>
				
				<td style="background-color: gray; width: 80px">商品名</td>
				<td style="background-color: white; width: 100px">りんご</td>
			</tr>
			<tr>
				<td style="background-color: gray; width: 80px">カテゴリー</td>
				<td style="background-color: white; width: 100px">果物</td>
			</tr>
			<tr>
				<td style="background-color: gray; width: 80px">価格</td>
				<td style="background-color: white; width: 100px">1000円</td>
			</tr>
			
			<tr>
				<td style="background-color: gray; width: 80px">備考</td>
				<td><textarea name="comment" row=10 cols=30></textarea>  </td>
			</tr>
			<tr><td colspan="2"><input type=submit value="購入"></td></tr>
		</form>
	</table>
	
	

</body>
</html>