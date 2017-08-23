<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div class="all">
		<form action="save.action" method="post" onsubmit="return judgevalue()">
			<header>
				<div class="top">
					<img src="images/logo.png">
					<p>用户注册</p>
				</div>
			</header>
			<div class="content">
				<div class="box">
					<label for="name">用户名称：</label> <input type="text" id="name"
						name="user.username" placeholder="请输入您的用户名！" autofocus="autofocus"
						onblur="judgeLength(this.value);">
				</div>
				<div class="box">
					<label for="password">登录密码：</label> <input type="password"
						id="password" name="user.password" placeholder="请输入您的密码！"
						autofocus="autofocus" onblur="judgeLength(this.value);">
				</div>
				<div class="box">
					<label for="repeatpassword">重复密码：</label> <input type="password"
						id="repeatpassword" name="user.repeatPassword" placeholder="请输入您的确认密码！"
						autofocus="autofocus" onblur="judgeLength(this.value);">
				</div>
				<div class="box">
					<label for="email">电子邮箱： </label> <input type="email"
						id="email" name="user.email" placeholder="请输入您的邮箱！"
						autofocus="autofocus">
				</div>
				<div class="sex">
					性&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;别： <input type="radio" name="user.gender"
						checked="checked" value="男">男&nbsp;&nbsp; <input type="radio"
						name="user.gender" value="女">女
				</div>
				<div class="occupation">
					职&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;业： <select name="user.profession">
						<option value="学生" selected="selected">学生</option>
						<option value="老师">老师</option>
						<option value="程序员">程序员</option>
						<option value="工程师">工程师</option>
					</select>
				</div>
				<div class="hobby">
					<span>爱&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;好：</span>
					<textarea name="user.hobby" cols="15" rows="3">书法 乐器 运动 编程
                    </textarea>
				</div>
				<hr>
			</div>
			<div class="bottom">
				<button type="submit">注册</button>
				&nbsp; &nbsp; &nbsp;
				<button type="reset">重置</button>
			</div>
		</form>
		<footer class="footer">Copyright &copy;2017.轻实训版权所有</footer>
	</div>
	<script language="JavaScript" type="text/javascript"
		src="js/register.js"></script>
</body>

</html>