<%@page import="java.util.ArrayList"%>
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
  -->


<style>
ul {
  list-style: none;
  padding-left: 1em;
  //1
  文字文の余白を設定する場合。完全に無くしたい場合は0を入れる。
}

a {
  color: rgb(88, 96, 109);
}

h1 {
  color: rgb(88, 96, 109);
}

.user a:hover {
  background-color: rgb(198, 241, 231);
  opacity: 1;
  border-radius: 0.2rem;
  color: black;
}

.user a {
  text-decoration: none;
  font-size: 20px;
  font-weight: 20px;
  margin-bottom: 50px;
}

li {
  margin-top: 2%;
}
</style>
</head>
<body>

<%
@SuppressWarnings("unchecked")
ArrayList<String> notices = (ArrayList<String>)request.getAttribute("notice");
%>

  <div align="center">
    <%@include file="../common/header.jsp"%>
    <header></header>
    <main>
      <h1>ユーザーメニュー</h1>
      <div style="height: 2rem"></div>
      <div class="user">
        <%
        for(String str : notices) {
        %>
        <div style="color:red; text-align=center"><%= str %></div>
<%
}
%>          
        <ul class="flex">
          <li><a href="<%=request.getContextPath()%>/itemList">商品一覧</a></li>
          <li><a
            href="<%=request.getContextPath()%>/userMenu?transit=exhibitScreen">出品画面</a></li>
          <li><a href="<%=request.getContextPath()%>/buyHistory">購入履歴</a></li>
          <li><a
            href="<%=request.getContextPath()%>/userExhibitList">出品一覧</a></li>
        </ul>
        <div style="height: 2rem"></div>
        <ul class="flex">
          <li><a href="<%=request.getContextPath()%>/logout">ログアウト</a></li>
        </ul>
      </div>
    </main>
    <footer></footer>
  </div>

</body>
</html>