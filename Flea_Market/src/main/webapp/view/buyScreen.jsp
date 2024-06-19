<%@page contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dntocume</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
	<form action="payment.jsp" style="margin: auto; ">
    <div style="text-align: center;font-size: 20px; font-weight: bold;margin: 5%;">購入画面</div>
    <div style="text-align: center;"><a style="text-align: left;display: inline-block;font-size: 22px;">商品名：今治のタオル<br><br>価格：¥1400<br><br>ご名義：神田太郎様<br><br>お届け先：東京都神田町39番地1丁目</a>
    </div>
    
    <input type="submit" value="決済画面へ" style="margin: auto;background: transparent;border-radius: 0.3rem;width: 20%;border-width: 1.5px; height:40px;
 line-height:30px; margin-top: 5%;margin-left: 40%;">
 
    
	</form>
</body>
</html>