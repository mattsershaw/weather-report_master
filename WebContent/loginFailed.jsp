<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LINE天気予報</title>
<style type="text/css">
#color {color: red;}
</style>
</head>
<body>
<form action="/weatherReport/LoginServlet" method="post">
<h1>LINEで天気予報を受け取ろう!</h1>
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
<p id="color">ユーザー名もしくはパスワードが正しくありません</p>
<br>
<a>新規登録は</a>
<a href="/weatherReport/RegistrationServlet">こちら</a>
</form>
</body>
</html>