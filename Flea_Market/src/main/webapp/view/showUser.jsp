<%@page contentType="text/html; charset=UTF-8"%>

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
				<th>ユーザーID</th>
				<th>ユーザー名</th>
			</tr>
		</thead>

		<tr>
			<td><a href ="" >0001</a></td>
			<td>かんだくん</td>
		</tr>
		<tr>
			<td><a href ="" >0002</a></td>
			<td>aya@プロフ必読</td>
		</tr>
		<tr>
			<td><a href ="" >0003</a></td>
			<td>今村</td>
		</tr>
		<tr>
			<td><a href ="" >0004</a></td>
			<td>焼き芋</td>
		</tr>
		<tr>
			<td><a href ="" >0005</a></td>
			<td>。</td>
		</tr>

	</table>
	<hooter><hr></hooter>
</body>
</html>