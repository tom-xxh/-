<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<h2>用户注册信息</h2>
	<hr>
	<p>
		用户名称：
		<s:property value="user.username" />
	</p>
	<p>
		登录密码：
		<s:property value="user.password" />
	</p>
	<p>
		重复密码：
		<s:property value="user.repeatPassword" />
	</p>
	<p>
		电子邮箱：
		<s:property value="user.email" />
	</p>
	<p>
		性别：
		<s:property value="user.gender" />
	</p>
	<p>
		职业：
		<s:property value="user.profession" />
	</p>
	<p>
		爱好：
		<s:property value="user.hobby" />
	</p>
</body>
</html>