<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>システム</title>
	<style>
		table {
			margin:auto;
			margin-bottom: 30%;
			text-align: center;
		}
		h2 {
			text-align:center;

		}
		th {
		    background-color:rgb(128, 128, 192);
		    width:200px;
		}
		td {
		    border: 1px solid black;
		}
		
		#nav {
			position: absolute;
			top: 23px;
			width: 285px;
			text-align:center;
		}
    </style>
</head>
<body>
	<%@include file="../common/header.jsp"%>
			<h2>ユーザー一覧</h2>

	</div>
	<table>
		<thead>
			<tr>
			<!-- 仕様変更 ユーザーIDからuserDetailに飛べるように設計をお願いします。 -->
				<th>ユーザーID</th>
				<th>ユーザー名</th>
			</tr>
		</thead>

		<%
		ArrayList<User> list =(ArrayList<User>)request.getAttribute("userList");
		if(list != null){
			for(int i=0;i<list.size();i++){
				User users = (User)list.get(i);
		%>
		
		<tr>
			<td><a href ="" ><%=users.getUserId()%></a></td>
			<td><%=getNickname()%></td>
		</tr>
		
		<%
			}
		}
		%>


	</table>
	<hooter><hr></hooter>
</body>
</html>