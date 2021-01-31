<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LINE天気予報</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="icon" type="image/png" href="/weatherReport/sunny.png">
<style type="text/css">
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
<h3 class="mt-5 mb-4">アカウントの削除が完了しました!</h3>
<h3 class="mb-4">またのご利用をお待ちしております。</h3>
</div>
<a class="pt-5 pb-5" href="/weatherReport/WelcomeServlet">ホーム画面へ戻る</a><br>
</body>
</html>