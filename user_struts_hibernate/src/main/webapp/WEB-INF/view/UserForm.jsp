<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userForm</title>
<script type="text/javascript" src="plugins/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div class="all">
		<div class="head">
			<img src="images/logo.png"> <span>用户管理系统</span>
			<div class="top-right">
				<a href="#">帮助</a>&nbsp; &nbsp; <a href="index.jsp">退出</a>
			</div>
		</div>
		<div id="nav">
			<div id="left">
				<div class="left-hr">
					<hr>
					<a href="userinfo">用户查询</a>
					<hr>
					<a href="toadd">用户新增</a>
					<hr>
					<a href="toanalyze">用户分析</a>
					<hr>
				</div>
				<div class="left-img">
					<img src="images/avatar.jpeg">
					<p>当前登录用户</p>
				</div>
			</div>
			<div id="right">
				<h3>新增&amp;编辑用户信息</h3>
				<form action="saveuserinfo" method="post"
					onsubmit="return judgevalue()">
					<div class="content">
						<div class="box">
							<label for="name">用户名称：</label> <input type="text" id="name"
								name="userModel.name" placeholder="请输入您的用户名！"
								autofocus="autofocus" onblur="judgeLength(this.value);">
						</div>
						<div class="box">
							<label for="password">登录密码：</label> <input type="password"
								id="password" name="userModel.password" placeholder="请输入您的密码！"
								autofocus="autofocus" onblur="judgeLength(this.value);">
						</div>
						<div class="box">
							<label for="repeatpassword">重复密码：</label> <input type="password"
								id="repeatpassword" name="repeatPassword"
								placeholder="请输入您的确认密码！" autofocus="autofocus"
								onblur="judgeLength(this.value);">
						</div>
						<div class="box">
							<label for="email">电子邮箱： </label> <input type="email" id="email"
								name="userModel.email" placeholder="请输入您的邮箱！"
								autofocus="autofocus">
						</div>
						<div class="sex">
							性&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;别： <input type="radio"
								name="userModel.sex" value="0" id="nan"><label for="nan">男</label>&nbsp;&nbsp;
							<input type="radio" name="userModel.sex" value="1" id="nv"
								checked><label for="nv">女</label>
						</div>
						<hr>
					</div>
					<div class="bottom">
						<button type="submit">保存</button>
						&nbsp; &nbsp; &nbsp;
						<button type="reset">重置</button>
				</form>
				&nbsp; &nbsp; &nbsp;
				<button type="button">
					<a href="userinfo">返回</a>
				</button>
			</div>
			<div class="right-bottom1">Copyright&copy;2017.轻实训版权所有</div>
		</div>
	</div>
	</div>
	<script type="text/javascript" src="js/common.js"></script>
</body>

</html>