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
</style>
</head>
<body>
  <div align="center">
    <header></header>
    <main>
    <%@include file="../common/header.jsp"%>
        <h1 class="title">管理者メニュー</h1>
        <div style="height: 2rem"></div>
        <ul class="flex">
          <li><a href="showUser.jsp">ユーザー一覧</a></li>
          <li><a href="adminExhibitList.jsp">出品一覧</a></li>
          <li><a href="sales.jsp">売上確認</a></li>
        </ul>
        <div style="height: 2rem"></div>
        <ul class="flex">
          <li><a href="userMenu.jsp">ログアウト</a></li>
        </ul>
    </main>
    <footer></footer>
  </div>

</body>
</html>