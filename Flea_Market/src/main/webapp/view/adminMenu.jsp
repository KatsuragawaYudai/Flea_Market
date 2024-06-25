<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<style>
  * {
    margin: 0;
    padding: 0;
  }
  .container {
    display: flex;
    flex-flow: column;
    min-height: 100vh;
    width: 80vw;
    margin: auto;
  }
  
  header {
    height: 1rem;
    /* background-color: skyblue; */
  }
  main {
    flex: 1;
    /* background-color: pink; */
  }
  
  footer {
    height: 1rem;
    /* background-color: skyblue; */
    border-top: 2px black solid;
  }
  
  .title {
    text-align: center;
    border-bottom: 2px black solid;
  }
  
  .main-grid {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    border: 1px black solid;
    max-width: 30vw;
    margin: auto;
    gap: 1rem 1rem;
  }
  
  .flex {
    display: flex;
    flex-flow: column; 
    max-width: 30vw;
    margin: auto;
    /* background-color: brown; */
    text-align: center;
    list-style: none;
  }
</style>
 -->
 <style>
  ul {
  list-style: none;
  padding-left: 1em; //1文字文の余白を設定する場合。完全に無くしたい場合は0を入れる。
}
a{
	color: rgb(198, 241,231);
}
body{
background-color:rgb(88,96,109);
}

h1{
color: rgb(198, 241,231);
}
.admin a:hover{
	background-color:rgb(198, 241,231);
	opacity: 1;
	border-radius:0.2rem;
	color:black;
}
.admin a{
	text-decoration:none;
	font-size:20px;
	font-weight:20px;
	margin-bottom:50px;
}
li{
	margin-top:2%;
}
</style>
</head>
<body>
  <div align="center">
    <header></header>
    <main>
    <%@include file="../common/admin_header.jsp"%>
        <h1 class="title">管理者メニュー</h1>
        <div style="height: 2rem"></div>
        <div class="admin">
        <ul class="flex">
          <li><a href="<%= request.getContextPath()%>/userList">ユーザー一覧</a></li>
          <li><a href="<%= request.getContextPath()%>/adminExhibitList">出品一覧</a></li>
          <li><a href="<%= request.getContextPath()%>/sales">売上確認</a></li>
        </ul>
        <div style="height: 2rem"></div>
        <ul class="flex">
          <li><a href="<%= request.getContextPath()%>/logout">ログアウト</a></li>
        </ul>
        </div>
    </main>
    <footer></footer>
  </div>

</body>
</html>