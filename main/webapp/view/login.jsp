<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>

<body>
	<style>
body {
	color: rgb(88, 96, 109);
}

hov:hover {
	background-color: black;
	opacity: 0.2;
}
</style>
	<%@include file="../common/header.jsp"%>
	<%
	String email = "";
	String password = "";
	

	String message = (String) request.getAttribute("message");
	Cookie[] userCookie = request.getCookies(); //クッキーの取得
	//クッキーがあるか判定
	if (userCookie != null) {
		for (int i = 0; i < userCookie.length; i++) {
			if (userCookie[i].getName().equals("email")) {
				email = userCookie[i].getValue();
			}
			if (userCookie[i].getName().equals("password")) {
				password = userCookie[i].getValue();
			}
		}
	}
	String msg = (String) request.getAttribute("msg");
	if (msg != null){
		%>
		<script type="text/javascript">
    	var msg = "<%=msg%>";
    	alert(msg);
    	</script>
		<%
	}
	%>
	<h2 align="center">ログイン画面</h2>

	<div
		style="margin-bottom: 300px; padding-top: 70px; text-align: center;">
		<form action="<%=request.getContextPath()%>/login" method="post">
		
			<div style="text-align: center; background-size: cover; width: 250px; margin: auto; margin-top: 2%; color:#ff0000;">
				<%if(message == null){ message ="";	}%>
				<td><%=message %></td>
			</div>
		
			<a
				style="font-size: 20px; font-weight: bold; text-align: left;; margin-right: 32%;">メールアドレス</a><br>
			<input type=text size="30" name="email" value="<%=email %>" 
				style="height: 6%; width: 550px; border-radius: 0.5rem;"></input><br>
			<br> <a
				style="font-size: 20px; font-weight: bold; text-align: left; margin-right: 30%; margin-top: 3%;">パスワード</a><br>
			<input type="password" size="30" name="password" value ="<%=password %>"
				style="height: 6%; width: 550px; border-radius: 0.5rem;"></input><br>
			<div class="hov">
				<input type="submit" value="ログイン"
					style="margin: auto; background: transparent; border-radius: 0.3rem; width: 20%; border-width: 1.5px; height: 40px; line-height: 30px; margin-top: 2%; font-size: 20px; color: rgb(88, 96, 109); background-color: rgb(198, 241, 231);">
			</div>			
			
			<div
				style="text-align: center; background-size: cover; width: 200px; margin: auto; margin-top: 2%;">
				<a href="<%=request.getContextPath()%>/view/userInsert.jsp">ユーザー登録</a><br>
				<a href="<%=request.getContextPath()%>/freeitemList">ユーザー会員外</a>
			</div>
		</form>
	</div>



</body>
</html>