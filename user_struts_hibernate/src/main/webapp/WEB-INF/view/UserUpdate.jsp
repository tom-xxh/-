<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserUpdate</title>
<script type="text/javascript" src="plugins/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="right1">
		<h3 align="center">修改&amp;编辑用户信息</h3>
		<form action="updateuserinfo" method="post"
			onsubmit="return judgevalue()">
			<input type="hidden" value="${userModel.id }" name="userModel.id">
			<div class="content">
				<div class="box">
					<label for="name">用户名称：</label> <input type="text" id="name"
						name="userModel.name" value="${userModel.name }"
						placeholder="请输入您的用户名！" autofocus="autofocus"
						onblur="judgeLength(this.value);">
				</div>
				<div class="box">
					<label for="password">登录密码：</label> <input type="password"
						id="password" name="userModel.password"
						value="${userModel.password }" placeholder="请输入您的密码！"
						autofocus="autofocus" onblur="judgeLength(this.value);">
				</div>
				<div class="box">
					<label for="repeatpassword">重复密码：</label> <input type="password"
						id="repeatpassword" name="repeatPassword"
						value="${userModel.password }" placeholder="请输入您的确认密码！"
						autofocus="autofocus" onblur="judgeLength(this.value);">
				</div>
				<div class="box">
					<label for="email">电子邮箱： </label> <input type="email" id="email"
						name="userModel.email" value="${userModel.email }"
						placeholder="请输入您的邮箱！" autofocus="autofocus">
				</div>
				<div class="sex">
					性&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;别：
					<c:if test="${!userModel.sex}">
						<input type="radio" name="userModel.sex" value="0" id="nan"
							checked>
						<label for="nan">男</label>&nbsp;&nbsp;
							<input type="radio" name="userModel.sex" value="1" id="nv">
						<label for="nv">女</label>
					</c:if>
					<c:if test="${userModel.sex}">
						<input type="radio" name="userModel.sex" value="0" id="nan">
						<label for="nan">男</label>&nbsp;&nbsp;
							<input type="radio" name="userModel.sex" value="1" id="nv"
							checked>
						<label for="nv">女</label>
					</c:if>

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
		<div class="right-bottom1">Copyright&copy;2017.轻实训版权所有</div>
	</div>
	</div>
	<script type="text/javascript" src="js/common.js"></script>
</body>
</html>