<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
<title>ログイン画面</title>
</head>

<body>
	
<%@include file="../common/header.jsp"%>
	<h2 align="center">ログイン画面</h2>
	
	<div style="margin-bottom: 300px; padding-top:70px">
		<form action="userMenu.jsp">
			<table style="margin: auto">
				<tr>
					<th style="background-color: gray; width: 200px ; ">ID入力</th>
					<th><input type=text  size="30" name="userId" ></input></th>
				</tr>

				<tr>
					<th style="background-color: gray; width: 200px">パスワード</th>
					<th><input type="password" size="30" name="password" ></input></th>
				</tr>
				
				
				<tr>
					<th colspan="2" style="text-align: center; padding: 70px;"><input
						type="submit" value="ログイン"></th>
				</tr>
				
				<div>
				<tr>
				</tr>
				</div>	
				
			</table>
				<div style="text-align: center; background-color: gray; background-size:cover ; width:200px;margin:auto;"><a href="<%=request.getContextPath()%>/login">ユーザー登録</a></div>
		</form>
	</div>
		


</body>
</html>