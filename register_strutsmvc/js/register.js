/**
 * 用户注册js
 */
function judgevalue() {
	var userName = document.getElementById("name").value;
	var password = document.getElementById("password").value;
	var repeatpassword = document.getElementById("repeatpassword").value;
	var mailbox = document.getElementById("email").value;

	if (userName == null || userName == "") {
		alert("用户名称不能为空！");
		return false;
	} else if (password == null || password == "") {
		alert("登录密码不能为空！");
		return false;
	} else if (repeatpassword == null || repeatpassword == "") {
		alert("重复密码不能为空！");
		return false;
	} else if (mailbox == null || mailbox == "") {
		alert("电子邮箱不能为空！");
		return false;
	} else if (password != repeatpassword) {
		alert("登录密码与重复密码不相同！");
		return false;
	} else {
		return true;
	}
}

function judgeLength(str) {
	if (str == null || str == "") {

	} else {
		var textstr = str.trim();
		var text = /^.{6,20}$/; // 正则表达式，判断输入的字符个数是否在6-20之间
		var flag = text.test(str);
		if (!flag) {
			alert("输入的字符长度必须在6到20个字符之间！");
		}
	}

}