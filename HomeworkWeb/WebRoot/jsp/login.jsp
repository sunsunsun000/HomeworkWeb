<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>作业提交批改系统</title>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style-login.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
<script type="text/javascript">
	function changeCode(img) {
		img.src = img.src + "?" + new Date().getTime();
	}
	${	userModel.errorInfo}
</script>
<body>
	<!--header start here-->
	<h2>作业提交批改系统</h2>
	<div class="login-top">
		<h1>用户登录</h1>
		<form action="login.action" method="post">
			<input type="text" value="" class="input" name="username"
				placeholder="用户名" />
			<input type="password" value="" class="input"
				name="password" placeholder="密码" /> 
			<input type="text1" value=""
				class="input" name="checkCode" placeholder="验证码" /> 
			<img
				src="checkCode" alt="..." style=" position:inherit" onclick="changeCode(this)">
			<button class="btn btn-danger btn-lg"
				style="position:relative; right:150px; top:55px;" type="submit">登录</button>	
		</form>
		
		<h4>
		<br>
		<br>
		<%-- 
			没有账户？ <a href="register.action"> 注册一个</a>
		--%>
		</h4>
	</div>
	<div class="copyright"></div>
	<!--header start here-->
</body>
</html>