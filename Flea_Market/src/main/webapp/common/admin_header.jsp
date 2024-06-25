<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<%
//セッションからユーザー情報を取得
User sessionUser = (User) session.getAttribute("user");
%>
<header
	style="background-color: rgb(198, 241, 231); margin: 0; padding: 0;">
	<div style="text-align: left; display: flex; margin: 0; padding: 0;">
		<img src="<%=request.getContextPath()%>/common/IMG_2599.jpg"
			style="width: 15%; margin-left: 2%; margin-right: 2%;">
		<ul class="header-ul-style">
			<li class="header-li-style"
				style="font-size: 20px; color: aliceblue; margin-top: 2%; width: 150px; text-align: center; border-radius: 0.3rem; margin-top: 45%;"><a
				href="<%=request.getContextPath()%>/adminMenu"
				style="text-decoration: none; color: rgb(88, 96, 109); font-weight: bold; margin: 0; padding: 0;">管理者メニュー</a></li>
		</ul>
		<ul class="header-ul-style">
			<li class="header-li-style"
				style="font-size: 20px; color: aliceblue; margin-top: 2%; width: 150px; text-align: center; border-radius: 0.3rem; margin-top: 45%;"><a
				href="<%=request.getContextPath()%>/userList"
				style="text-decoration: none; color: rgb(88, 96, 109); font-weight: bold; margin: 0; padding: 0;">ユーザー一覧</a></li>
		</ul>
		<ul class="header-ul-style">
			<li class="header-li-style"
				style="font-size: 20px; color: aliceblue; margin-top: 2%; width: 150px; text-align: center; border-radius: 0.3rem; margin-top: 45%;"><a
				href="<%=request.getContextPath()%>/adminExhibitList"
				style="text-decoration: none; color: rgb(88, 96, 109); font-weight: bold; margin: 0; padding: 0;">出品一覧</a></li>
		</ul>
		<ul class="header-ul-style">
			<li class="header-li-style"
				style="font-size: 20px; color: aliceblue; margin-top: 2%; width: 150px; text-align: center; border-radius: 0.3rem; margin-top: 45%;"><a
				href="<%=request.getContextPath()%>/sales"
				style="text-decoration: none; color: rgb(88, 96, 109); font-weight: bold; margin: 0; padding: 0;">売上確認</a></li>
		</ul>
		<%
		if (sessionUser != null) {
		%>
		<ul>
			<li
				style="font-size: 20px; color: navy; width: 400px; text-align: right; margin-top: 5%;">
				ユーザー名：管理者
			</li>
		</ul>
		<ul class="header-ul-style">
			<li
				style="font-size: 20px; color: navy; width: 100px; text-align: center; margin-top: 20%;">
				<a href="<%=request.getContextPath()%>/logout"
				style="text-decoration: none; color: rgb(88, 96, 109); font-weight: bold; margin: 0; padding: 0;">ログアウト</a>
			</li>
		</ul>
		<%}%>
	</div>
</header>
<style>
body {
	margin: 0;
	padding: 0;
}

ul.header-ul-style li:hover {
	background-color: black;
	opacity: 0.2;
}

header {
	
}

.header-h1-style {
	
}

.header-ul-style { {
	
}

}
.header-li-style {
	
}

ul {
	list-style: none;
	padding-left: 1em;
	//1
	文字文の余白を設定する場合。完全に無くしたい場合は0を入れる。
}
</style>