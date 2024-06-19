<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>売上</title>
<meta charset="UTF-8">
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2 h2 align="center">売上</h2>


	<div style="margin-bottom:250px">
			<table style="margin:auto">
				<tr>
					<th style="background-color:#6666ff; width:250px">日付(yyyy-mm-dd)</th>
					<th style="background-color:#6666ff; width:150px">取引ID</th>
					<th style="background-color:#6666ff; width:150px">出品者名</th>
					<th style="background-color:#6666ff; width:150px" >購入者</th>
					<th style="background-color:#6666ff; width:150px" >売上金額</th>
					
				</tr>
				
				<tr>
					<td style="text-align:center; width:250px">2024-06-18</td>
					<td style="text-align:center; width:150px">00001</td>
					<td style="text-align:center; width:150px">田中</td>
					<td style="text-align:center; width:150px">加藤</td>
					<td style="text-align:left; width:150px">\9999</td>
					
				</tr>
				
				
				
							
			</table>
			
			<hr	style="text-align: center; height: 1px; background-color: black; width: 950px">

			<table >
				<form  action="<%=request.getContextPath()%>/" >
				<tr style="text-align: center; width: 100px"><td  style="background-color: #6666ff ">売上合計</td>
					<td>\0000</td>
				</tr>
				<tr style="text-align: center; width: 100px"><td  style="background-color: #6666ff ">手数料合計</td>
					<td>合計ｘ10%</td>
				</tr>		
				</form>
			</table

			</table>
		</div>

</body>
</html>