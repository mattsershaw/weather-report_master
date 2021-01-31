<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsgForLogin = (String) request.getAttribute("errorMsgForLogin"); %>
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
<h1>LINEで天気予報を受け取ろう!(日本国内限定)</h1>
ユーザーID:<input type="text" name="userId" pattern="[a-z,0-9]{6,15}"><br>
パスワード:<input type="password" name="pass" pattern="[0-9]{4}"
       title="4桁の数字を入力してください"><br>
<input type="submit" value="ログイン"><br>
<br>
<% if(errorMsgForLogin != null) { %>
<div id=color><%= errorMsgForLogin %></div>
<% } %><br><br>
<h6>*ユーザーIDは6文字以上15文字以下</h6>
<h6> パスワードは4桁の数字</h6>

<a>まずはLINE Notifyでトークンを発行</a>
<a href="https://notify-bot.line.me/ja/" target= "_blank" rel="noopener noreferrer">LineNotify公式ページ</a><br><br>
<a>新規登録は</a>
<a href="/weatherReport/RegistrationServlet">こちら</a>
<ul>
<li>ステップ1 LINE notifyでお客様の情報を登録</li>
<li>ステップ2 そこでトークンを発行!</li>
<li>ステップ3 ここで新規登録だけ!</li>
</ul>
</form>
</body>
</html>