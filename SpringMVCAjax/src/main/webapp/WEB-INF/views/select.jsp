<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../plugins/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function initProvince() {
		var opt = {
			url : "province",
			type : "post",
			dataType : "json",
			success : function(json) {
				for (var i = 0; i < json.province.length; i++) {
					var option = "<option value="+json.province[i].code+">"
							+ json.province[i].name + "</option>";
					$("#provinceSelector").append(option);
				}
			}
		}
		$.ajax(opt);
	}
	function selectProvince(provinceCode) {
		var opt = {
			url : "city",
			type : "post",
			data : {
				'code' : provinceCode
			},
			dataType : "json",
			success : function(json) {
				$("#citySelector").empty();
				$("#citySelector").append("<option value=''>请选择城市...</option>");
				for (var i = 0; i < json.cities.length; i++) {
					var option = "<option value="+json.cities[i].code+">"
							+ json.cities[i].name + "</option>";
					$("#citySelector").append(option);
				}
			}
		}
		$.ajax(opt);
	}
	function selectCity(cityCode) {
		var opt = {
			url : "district",
			type : "post",
			data : {'code' : cityCode},
			dataType : "json",
			success : function(json) {
				$("#districtSelector").empty();
				$("#districtSelector").append("<option value=''>请选择城区...</option>");
				for (var i = 0; i < json.district.length; i++) {
					var option = "<option value="+json.district[i].code+">"
							+ json.district[i].name + "</option>";
					$("#districtSelector").append(option);
				}
			}
		}
		$.ajax(opt);
	}
	$(document).ready(function() {
		//TODO 初始化所有省数据（利用 $.ajax API实现省数据加载）
		initProvince();

		//选择省
		$("#provinceSelector").change(function(e) {
			//获取选中的省编号 
			var provinceCode = $(this).find("option:selected").val();

			//TODO 利用 $.get API 实现某一省下的所有市数据加载
			selectProvince(provinceCode);
		});

		//选择市
		$("#citySelector").change(function(e) {
			//获取选中的市编号 
			var cityCode = $(this).find("option:selected").val();

			//TODO 利用 $.post API 实现某一市下的所有区数据加载
			selectCity(cityCode);
		});
	})
</script>

</head>
<body>
	<select id="provinceSelector">
		<option value="">请选择省份...</option>
	</select>
	<select id="citySelector">
		<option value="">请选择城市...</option>
	</select>
	<select id="districtSelector">
		<option value="">请选择城区...</option>
	</select>
</body>
</html>