<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsgForRegis = (String) request.getAttribute("errorMsgForRegis"); %>
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
.token {
	width: 550px;
}
</style>
</head>
<body class="text-center text">
<header>
	<h1 class="title">LINEで天気予報を受け取ろう!</h1>
</header>
<div class="container">
<h2 class="mt-5 mb-4">アカウント作成</h2>
<form action="/weatherReport/RegistrationServlet" method="post"> <!-- "jdbc:mysql://localhost/weatherReport" -->
<h5>ユーザーID<span class="color"> *</span></h5>
<input class="form-control form-control-lg txForm" type="text" name="userId" pattern="[a-z,0-9]{6,20}"><br /><p>*6文字以上20文字以下の英数字</p>
<br />
<h5>パスワード<span class="color"> *</span></h5>
<input class="form-control form-control-lg txForm" type="password" name="pass" pattern="[a-z,0-9]{6,20}"><br /><p>*6文字以上20文字以下の英数字</p>
<br />
<h5>LINE Notify トークン</h5>
<input class="form-control form-control-lg txForm" type="text" name="lineToken" pattern=".{0,60}"><br />
<br />
<h5>ニックネーム<span class="color"> *</span></h5>
<input class="form-control form-control-lg txForm" type="text" name="nickname" pattern=".{2,20}"><br /><p>*2文字以上20文字以下</p>
<br />
<h5>登録場所<span class="color"> *</span></h5>
<div class="dropdown">
<select name="location" size="1" required> <!-- sizeは1度に表示される欄の数 -->
<option value="">場所を選択</option>
<option value="北海道">北海道</option>
<option value="青森県">青森県</option>
<option value="岩手県">岩手県</option>
<option value="宮城県">宮城県</option>
<option value="秋田県">秋田県</option>
<option value="山形県">山形県</option>
<option value="福島県">福島県</option>
<option value="茨城県">茨城県</option>
<option value="栃木県">栃木県</option>
<option value="群馬県">群馬県</option>
<option value="埼玉県">埼玉県</option>
<option value="千葉県">千葉県</option>
<option value="東京都">東京都</option>
<option value="神奈川県">神奈川県</option>
<option value="新潟県">新潟県</option>
<option value="富山県">富山県</option>
<option value="石川県">石川県</option>
<option value="福井県">福井県</option>
<option value="山梨県">山梨県</option>
<option value="長野県">長野県</option>
<option value="岐阜県">岐阜県</option>
<option value="静岡県">静岡県</option>
<option value="愛知県">愛知県</option>
<option value="三重県">三重県</option>
<option value="滋賀県">滋賀県</option>
<option value="京都府">京都府</option>
<option value="大阪府">大阪府</option>
<option value="兵庫県">兵庫県</option>
<option value="奈良県">奈良県</option>
<option value="和歌山県">和歌山県</option>
<option value="鳥取県">鳥取県</option>
<option value="島根県">島根県</option>
<option value="岡山県">岡山県</option>
<option value="広島県">広島県</option>
<option value="山口県">山口県</option>
<option value="徳島県">徳島県</option>
<option value="香川県">香川県</option>
<option value="愛媛県">愛媛県</option>
<option value="高知県">高知県</option>
<option value="福岡県">福岡県</option>
<option value="佐賀県">佐賀県</option>
<option value="長崎県">長崎県</option>
<option value="熊本県">熊本県</option>
<option value="大分県">大分県</option>
<option value="宮崎県">宮崎県</option>
<option value="鹿児島県">鹿児島県</option>
<option value="沖縄県">沖縄県</option>


</select>
</div>
<input class="btn btn-success mt-5" type="submit" value="登録"><br>
<br>
<% if(errorMsgForRegis != null) { %>
<div class=color><%= errorMsgForRegis %></div>
<% } %><br>

<a class="pb-5" href="/weatherReport/WelcomeServlet">ホーム画面へ戻る</a>
</form>
</div>
</body>
</html>