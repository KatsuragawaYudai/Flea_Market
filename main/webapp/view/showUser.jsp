<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>システム</title>
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
a:hover {
	background-color: black;
	opacity: 0.2;
}
</style>
</head>
<body>
	<%@include file="../common/admin_header.jsp"%>
	<h2 align="center">ユーザー一覧</h2>

	</div>
	<table align="center" border="1px solid black">
		<thead>
			<tr>
				<!-- 仕様変更 ユーザーIDからuserDetailに飛べるように設計をお願いします。 -->
				<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:100px;font-size:20px">ユーザーID</th>
				<th style="background-color: rgb(198, 241, 231);color: rgb(88,96,109); width:100px;font-size:20px">ユーザー名</th>
			</tr>
		</thead>

		<%
		ArrayList<User> list =(ArrayList<User>)request.getAttribute("userList");
		if(list != null){
			for(int i=0;i<list.size();i++){
				User users = (User)list.get(i);
		%>

		<tr>
			<td><a
				href="<%=request.getContextPath() %>/userDetail?userId=<%=users.getUserId() %>"
				style="text-decoration: none;color: rgb(198, 241, 231);width: 100px; font-weight: bold; margin: 0; padding: 0;"><%=users.getUserId()%></a></td>
			<td><%=users.getNickname()%></td>
		</tr>

		<%
			}
		}
		%>


	</table>
	<hooter>
	<hr>
	</hooter>
</body>
</html>