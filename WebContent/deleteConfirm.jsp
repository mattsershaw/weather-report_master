<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<% Account account = (Account) session.getAttribute("account"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LINE天気予報</title>
</head>
<body>
<h2><%= account.getNickname() %>様 アカウントを削除しますが本当によろしいですか？</h2><br>
<br>
<a href="/WeatherReport/deleteServlet">はい</a>
<br>
<a href="javascript:history.back();" >戻る</a>
</body>
</html>