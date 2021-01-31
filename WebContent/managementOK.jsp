<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<% Account account = (Account) session.getAttribute("account"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#color {color: red;}
textarea {
  resize: none;
  width: 300px;
  height: 200px;
}
</style>
</head>
<body>
<p id="color">編集画面</p><br>
<br>
<form action="/weatherReport/ManagementServlet" method="post">
<p>id</p>
<textarea name="userId" cols="40"><%= account.getUserId() %></textarea><br>
<input type="reset" value="リセット">
<p>パスワード</p><br>
<textarea name="pass" cols="40"><%= account.getPass() %></textarea><br>
<input type="reset" value="リセット">
<p>LINE Notify トークン</p><br>
<textarea name="lineId" cols="40"><%= account.getLineToken() %></textarea><br>
<input type="reset" value="リセット">
<p>ニックネーム</p><br>
<textarea name="nickname" cols="40"><%= account.getNickname() %></textarea><br>
<input type="reset" value="リセット">
<p>登録場所</p><br>
<textarea name="location" cols="40"><%= account.getLocation() %></textarea><br>
<input type="reset" value="リセット"><br>
<br>
<input type="submit" value="送信">
</form>
<p id="color">正しく更新されました</p>
<br>
<a href="/weatherReport/WelcomeServlet">ログアウト</a><br>
<br>
<a href="/weatherReport/DeleteServlet">アカウント削除</a>
</body>
</html>