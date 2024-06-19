<%@page contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dntocume</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
    <style>
        td{
            width: calc(100%/4);
            text-align: center;
            margin: 50%;
        }
        table,
table th,
table td {
    border: 1px solid black;
    border-collapse: collapse;
}
        </style>
    <div style="text-align: center;font-size: 25px; font-weight: bold;margin: 5%;">購入履歴</div>
    <table cellspacing="8" style="margin: auto;">
        <tr style="text-align: center;font-size: 19px;">
            <td>
                購入ID
            </td>
            <td>
                商品名
            </td>
            <td>
                日時
            </td>
            <td>
                配送状況
            </td>
        </tr>
        <tr>
            <td>
                1212301
            </td>
            <td>
                自家製の焼物
            </td>
            <td>
                2024/06/13
            </td>
            <td>
               <a href="status.html">配達完了</a>
            </td>
        </tr>
        <tr>
            <td>
                1232302
            </td>
            <td>
                竹の箸
            </td>
            <td>
                2024/06/13
            </td>
            <td>
                <a href="#">配達完了</a>
            </td>
        </tr>
        <tr>
            <td>
                1242302
            </td>
            <td>
                ヴィンテージズボン
            </td>
            <td>
                2024/06/17
            </td>
            <td>
                <a href="#">配達完了</a>
            </td>
        </tr>
        <tr>
            <td>
                1332302
            </td>
            <td>
                ノリタケの食器
            </td>
            <td>
                2024/06/18
            </td>
            <td>
                <a href="#">配達中</a>
            </td>
        </tr>
        <tr>
            <td>
                1344302
            </td>
            <td>
                今治のタオル
            </td>
            <td>
                2024/06/18
            </td>
            <td>
                <a href="#">配達中</a>
            </td>
        </tr>
    </table>
</body>
</html>