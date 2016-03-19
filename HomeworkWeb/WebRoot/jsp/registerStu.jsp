<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>作业提交批改系统</title>
<link href="css/reg_style1.css" rel='stylesheet' type='text/css' />
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Inscription and login forms,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements" ./>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Copse|Roboto'
	rel='stylesheet' type='text/css'>
</head>
<script type="text/javascript">
	function changeCode(img) {
		img.src = img.src + "?" + new Date().getTime();
	}
	${	userModel.errorInfo}
</script>
<body>
	<div class="main">
		<div class="wrap">
			<div class="top-one">
				<div class="login-one">
					<div class="create-account">
						<div class="btn-group btn-group-justified" role="group">
							<div class="btn-group" role="group">
								<button type="button" class="btn btn-default"
									style="position:relative; left:0px; top:0px;"
									onclick="window.location.href='register.action?reg_type=stu'">学生账户</button>
							</div>
							<div class="btn-group" role="group">
								<button type="button" class="btn btn-default" onclick="window.location.href='register.action?reg_type=teacher'">教师账户</button>
							</div>
						</div>
						<form method="post">
							<input type="hidden" name="reg_type" value="stu" />
							<p>
								用户名
								<lable> *</lable>
							</p>
							<input type="text" class="input" value="" name="username"
								placeholder="Username">
							<p>
								学号
								<lable> *</lable>
							</p>
							<input type="text" class="input" value="" name="stuNum"
								placeholder="StudentNum">
							<p>
								密码
								<lable> *</lable>
							</p>
							<input type="password" class="input" value="" name="password"
								placeholder="Password">
							<p>
								确认密码
								<lable> *</lable>
							</p>
							<input type="password" class="input" value="" name="rePassword"
								placeholder="ReEnter Password">
							<p>
								验证码
								<lable> *</lable>
							</p>
							<input type="text1" class="input" name="checkCode"
								placeholder="Check Code"> <img src="checkCode"
								alt="点击换一张" style="position: relative;"
								onclick="changeCode(this)"> <br> <br> <br>
							<br> <br> <br>
							<div class="sign-up">
								<input type="reset" value="重置"> <input type="submit"
									onclick="myFunction()" value="注册">

								<!-- pop-up-box -->
								<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
									media="all" />
								<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
								<!--//pop-up-box -->
							</div>
						</form>
						<div class="clear"></div>
						<h5>
							已有账号? <a href="login.action">点击登录</a>
						</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>