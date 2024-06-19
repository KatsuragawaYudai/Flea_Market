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
  padding-left: 1em; //1文字文の余白を設定する場合。完全に無くしたい場合は0を入れる。
}
</style>
</head>
<body>
  <div align="center">
  <%@include file="../common/header.jsp"%>
    <header></header>
    <main >
        <h2>ユーザーメニュー</h2>
        <ul class="flex">
          <li><a href="itemList.jsp">商品一覧</a></li>
          <li><a href="exhibitScreen.jsp">出品画面</a></li>
          <li><a href="buyHistory.jsp">購入履歴</a></li>
          <li><a href="userExhibitList.jsp">出品一覧</a></li>
        </ul>
        <div style="height: 2rem"></div>
        <ul class="flex">
          <li><a href="login.html">ログアウト</a></li>
        </ul>
    </main>
    <footer></footer>
  </div>

</body>
</html>