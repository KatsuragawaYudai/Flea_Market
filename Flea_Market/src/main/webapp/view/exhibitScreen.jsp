<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>出品画面</title>
	</head>
	<body>
	<%@include file="../common/header.jsp"%>
		<h2 style="text-align:center">出品</h2>
		<form action="<%=request.getContextPath() %>/exhibitScreen">
			<table style="text-align:center; margin:auto">
				<tr>
					<td style="font-size:19px" colspan="2">出品物登録</td>
				</tr>
				<tr>
					<td style="width:150px; background-color: salmon">商品名</td>
					<td><input type=text  size="50px"; name="name"></td>
				</tr>
				<tr>
					<td style="width:150px; background-color: salmon">価格</td>
					<td><input type=text  size="50px"; name="price"></td>
				</tr>
				<tr>
					<td style="width:150px; background-color: salmon">備考</td>
					<td><textarea name="remark" rows="5" cols="50"></textarea></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="出品する"></td>
				</tr>
			</table>
		</form>
	</body>
</html>