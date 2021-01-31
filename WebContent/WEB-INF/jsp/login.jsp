<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsgForLogin = (String) request.getAttribute("errorMsgForLogin"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LINE天気予報</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="icon" type="image/png" href="/weatherReport/sunny.png">
<style type="text/css">
.color {
	color: red;
	font-size: 24px;
}
.txForm {
	width: 300px;
}
.btn-success {
	background-color: #16c464;
	border-color: #16c464;
}
input {
	margin-right: auto;
	margin-left: auto;
}
header {
	background-color: #16c464;
	height: 81px;
}
.title {
	text-align: left;
	color: white;
	font-size: 28px;
	font-family: Helvetica Neue;
	padding-top: 24px;
	padding-left: 163px;
}
.mar {
	margin-left: 10px;
}
.step {
	text-align: center;
}
.cont {
	text-align: left;
	margin-left: auto;
	margin-right: auto;
	width: 410px;
}
</style>
</head>
<body class="text-center text">
<header>
	<h1 class="title">LINEで天気予報を受け取ろう!</h1>
</header>

<div class="container">
	<h2 class="mt-5 mb-4">LINEで天気予報を受け取ろう!<br>(日本国内限定)</h2>
	<form name="myForm" action="/weatherReport/LoginServlet" method="post">
		<div class="form-group">
			<label for="userId">ユーザーID: </label>
			<input class="form-control form-control-lg txForm" type="text" name="userId" maxlength="20" pattern="[a-z,0-9]{6,20}"><br>
			<label for="pass">パスワード: </label>
			<input class="form-control form-control-lg txForm" type="password" name="pass" maxlength="20" pattern="[a-z,0-9]{6,20}"
			title="4桁の数字を入力してください"><br>
			<input type="submit" class="btn btn-success mt-3" value="ログイン">
			<input type="button" class="btn btn-success mt-3 mar" value="アカウント作成" onClick="document.location='/weatherReport/RegistrationServlet';"> <!-- できた!!! -->
			</div>
	</form>
			<% if(errorMsgForLogin != null) { %>
			<div class="color mt-3"><%= errorMsgForLogin %></div>
			<% } %>
			<p class="mt-5">まずはLINE Notifyでトークンを発行
			<a href="https://notify-bot.line.me/ja/" target= "_blank" rel="noopener noreferrer">LineNotify公式ページ</a><br>アカウント作成の際にそのトークンを登録! (アカウント作成後の登録も可能)</p>
</div>
</body>
</html>