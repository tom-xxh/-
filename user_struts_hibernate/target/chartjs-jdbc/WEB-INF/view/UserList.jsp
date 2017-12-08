<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userList</title>
<script type="text/javascript" src="plugins/jquery-3.2.1.min.js"></script>
<script src="plugins/bootstrap/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/default.css" rel="stylesheet">
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
					<a href="toanalyze">用户新增</a>
					<hr>
					<a href="toadd">用户分析</a>
					<hr>
				</div>
				<div class="left-img">
					<img src="images/avatar.jpeg">
					<p>当前登录用户</p>
				</div>
			</div>
			<div id="right">
				<div class="right-serch">
					<form action="#" method="post">
						<label for="username">用户名称:</label> <input type="text"
							id="username" name="username">
						<button type="submit">查询</button>
					</form>
					<div class="right-table">
						<table border="1" width="780px" cellpadding="0" cellspacing="0">
							<thead>
								<tr>
									<th>编号</th>
									<th>用户名称</th>
									<th>邮箱</th>
									<th>性别</th>
									<th>创建时间</th>
									<th>更新时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userModellist.result}" var="obj"
									varStatus="stuts">
									<s:if test="#stuts.odd == true">
										<tr>
									</s:if>
									<s:else>
										<tr class="even">
									</s:else>
									<td>${obj.id }</td>
									<td>${obj.name }</td>
									<td>${obj.email }</td>
									<td><c:if test="${!obj.sex}">男</c:if> <c:if
											test="${obj.sex}">女</c:if></td>
									<td><fmt:formatDate value="${obj.createTime}"
											pattern="yyyy-MM-dd" /></td>
									<td><fmt:formatDate value="${obj.updateTime}"
											pattern="yyyy-MM-dd" /></td>
									<td><a href="searchuser?userModel.id=${obj.id }">编辑</a>&nbsp;
										&nbsp;<a
										href="JavaScript:doDeleteUser('${obj.id }','${obj.name }');">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- 自定义分页处理TagLib -->
						<qsx:paging pageSize="${userModellist.pageSize}"
							pageNo="${userModellist.pageNo}" url="userinfo"
							totalCount="${userModellist.totalCount}" />
					</div>
				</div>
				<div class="right-bottom">Copyright&copy;2017.轻实训版权所有</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript">
		//删除用户
		function doDeleteUser(userId, userName) {
			//提示是否确认删除
			var deleteConfirm = confirm("是否确认删除用户：" + userName + " ?");
			if (deleteConfirm == true) {
				document.location = "deleteuserinfo?userModel.id=" + userId;
				alert("用户删除成功！");
			}
		}
	</script>
</body>

</html>