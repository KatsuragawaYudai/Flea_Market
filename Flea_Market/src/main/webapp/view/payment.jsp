<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>入金状況画面</title>
	</head>
	<body>
	<%@include file="../common/header.jsp"%>
		<h2 style="text-align:center">入金状況</h2>
		<p style="text-align:center; font-size:20px">入金が完了したらボタンを押してください</p>
		<form action="userMenu.jsp">
			<p style="text-align:center"><input type="submit" value="入金完了"></p>
		</form>
	</body>
</html>