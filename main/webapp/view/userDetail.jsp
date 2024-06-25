<%@page contentType="text/html; charset=UTF-8"%>
<style>
body {
	background-color: rgb(88, 96, 109);
	color: rgb(198, 241, 231);
}

.main table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 60%;
}

.main table tr {
	border-bottom: solid 1px #eee;
	cursor: pointer;
}

.main table th, table td {
	text-align: center;
	width: 25%;
	padding: 15px 0;
	font-size:20px;
}
</style>
<html>
	<head>
		<title>ユーザー情報詳細画面</title>
		<meta charset="UTF-8">
	</head>
	<body>
	<%@include file="/common/admin_header.jsp"%>
		<h2 style =" text-align:center; margin-top:50px ">ユーザー詳細画面</h2>
		<%@page import="bean.User,dao.UserDao" %>
		
		<%
		User user = (User)request.getAttribute("user");
		%>

	<table align="center" border="1px solid black">
			
			<tr>
				<td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:300px">ユーザーID</td>
				<td style="text-align:center;background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:200px"><%=user.getUserId() %></td>
			</tr>
			<tr>
				<td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:300px">ユーザー名</td>
				<td style="text-align:center;background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:400px"><%=user.getName() %></td>
			</tr>
			<tr>
				<td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:300px">ニックネーム</td>
				<td style="text-align:center;background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:400px"><%=user.getNickname() %></td>
			</tr>
			<tr>
				<td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:300px">メールアドレス</td>
				<td style="text-align:center;background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:400px"><%=user.getEmail() %></td>
			</tr>
			<tr>
				<td style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:300px">住所</td>
				<td style="text-align:center;background-color: rgb(198, 241, 231);color: rgb(88,96,109);width:400px"><%=user.getAddress() %></td>
			</tr>
		</form>
	</table>
	</body>
</html>