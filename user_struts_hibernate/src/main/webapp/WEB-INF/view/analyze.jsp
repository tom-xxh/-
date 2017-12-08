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
<title>analyze</title>
<script type="text/javascript" src="plugins/jquery-3.2.1.min.js"></script>
<!-- 引入 Chart.js 库 -->
<script src="plugins/chart/Chart.min.js"></script>
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
				<div class="right-serch">
					<div class="right-table">
						<div class="canvas1">
							<canvas id="userGenderChartCanvas" width="200" height="200"
								style="float: left;"></canvas>
						</div>
						<div class="canvas2">
							<canvas id="userCreateChartCanvas" width="400" height="250"
								style="float: left;"></canvas>
						</div>

						<script type="text/javascript">
    // 用户性别统计参数（饼状图）
    var userGenderChartConfig = {
        type: 'pie',
        data: {
            labels: ${userGenderData.names},
            datasets: [{
                data: ${userGenderData.values},
                backgroundColor: ["#FF6384", "#36A2EB"]
            }]
        },
        options: {
            title: {
                display: true,
                text: '用户性别分布统计'
            },
            responsive: true
        }
    };

    // 用户创建日期统计参数（折线图）
    var userCreateChartConfig = {
        type: 'line',
        data: {
            labels: ${userCreateData.names},
            datasets: [{
                label: "创建日期",
                fill: false,
                data: ${userCreateData.values}
            }]
        },
        options: {
            title: {
                display: true,
                text: '用户创建日期统计'
            },
            responsive: true
        }
    };

    $(function() {
        // 生成用户性别统计图
        var userGenderChartCtx = document.getElementById("userGenderChartCanvas").getContext("2d");
        var userGenderChartCanvas = new Chart(userGenderChartCtx, userGenderChartConfig);

        // 生成用户创建日期统计图            
        var userCreateChartCtx = document.getElementById("userCreateChartCanvas").getContext("2d");
        var userCreateChartCanvas = new Chart(userCreateChartCtx, userCreateChartConfig);
    });
    </script>

					</div>
				</div>
				<div class="right-bottom">Copyright&copy;2017.轻实训版权所有</div>
			</div>
		</div>
		<script type="text/javascript" src="js/common.js"></script>
	</div>
</body>

</html>