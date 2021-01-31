<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#color {color: red;}
</style>
</head>
<body>
<form action="/weatherReport/RegistrationServlet" method="post"> <!-- "jdbc:mysql://localhost/weatherReport" -->
ユーザーID:<br>
<input type="text" name="userId"><br>
パスワード:<br>
<input type="password" name="pass"><br>
LINE ID:<br>
<input type="text" name="lineId"><br>
ニックネーム:<br>
<input type="text" name="nickname"><br>
登録したい場所:<br>
<select name="location" size="1"> <!-- sizeは1度に表示される欄の数 -->
<option value="">場所を選択</option>
<option value="千葉県">千葉県</option>
<option value="東京都">東京都</option>
<option value="埼玉県">埼玉県</option>
<option value="神奈川県">神奈川県</option>
</select>
<input type="submit" value="登録"><br>
<p id="color">ユーザー名もしくはパスワードが正しくありません</p>
<br>
<a href="/weatherReport/WelcomeServlet">トップへ</a>
</form>
</body>
</html>