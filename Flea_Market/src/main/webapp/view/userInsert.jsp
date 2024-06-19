<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>全てのデータを表示する</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
<h1 align="center">ユーザー登録</h1>
		<table>
		<br>
	
		<table style="margin: 0 auto; border: none;">
			<tr>
				<td style="background-color: gray; width: 150;">本名</td>
				<td><input type=text size="30" name="name"></input></td>
			</tr>
			<tr>
				<td style="background-color: gray;width: 150;">ニックネーム</td>
				<td><input type=text size="30" name="nickname"></input></td>
			</tr>
			<tr>
				<td style="background-color: gray;width: 150;">住所</td>
				<td><input type=text size="30" name="address"></input></td>
			</tr>
						<tr>
				<td style="background-color: gray;width: 150;">メールアドレス</td>
				<td><input type=text size="30" name="email"></input></td>
			</tr>
			<tr>
				<td style="background-color: gray;width: 150;">パスワード</td>
				<td><input type=text size="30" name="password"></input></td>
			</tr>
		</table>
		
		<br>
		<br>
		<div style="text-align: center">
	
		<input type="submit" value="登録">
	</form>
	</div>
	<br>
</body>
</html>