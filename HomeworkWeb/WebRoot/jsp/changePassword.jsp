<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!--theme-style-->
<link href="css/style-change-password.css" rel="stylesheet" type="text/css"
	media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="js_score/jquery.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--script-->
<script src="js/responsiveslides.min.js"></script>
<script>
    // You can also use "$(window).load(function() {"
    $(function () {
      // Slideshow 1
      $("#slider1").responsiveSlides({
         auto: true,
		 nav: true,
		 speed: 500,
		 namespace: "callbacks",
      });
    });
  </script>
</head>
<script type="text/javascript">
${result}
</script>
<body>
	<!--header-->
	<!---->
	<div class="top-header">
		<div class="container">
			<div class="footer-bottom"
				style=" position:fixed; top:0px; width:100%; left:0px;">
				<div class="top-nav">
					<label class="menu"></label>
					<ul>
						<jsp:include page="userTree.jsp"></jsp:include>
					</ul>

					<!-- script-nav -->
					<script>
						$("label.menu").click(function(){
							$(".top-nav ul").slideToggle(700, function(){
							});
						});
					</script>
					<!-- //script-nav -->
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="container"
		style="position:relative; top:180px; width:500px;">
		<ol class="breadcrumb">
			<li><a href="#" style="color:#E72318">${username }</a></li>
			<li><a href="#" style="color:#E72318">用户信息</a></li>
			<li class="active">密码修改</li>
		</ol>
		<form method="post">
			<p>
				<lable> *</lable>
				&nbsp;用户名
			</p>
			<input type="text" class="form-control" class="input" value="${username }"
				id="username" placeholder="Username" readonly="readonly"> <br>
			<p>
				<lable> *</lable>
				&nbsp;原密码
			</p>
			<input type="password" class="form-control" class="input" value=""
				name="oldPass" placeholder="Old Password"> <br>
			<p>
				<lable> *</lable>
				&nbsp;新密码
			</p>
			<input type="password" class="form-control" class="input" value=""
				name="newPass1" placeholder="New Password"> <br>
			<p>
				<lable> *</lable>
				&nbsp;确认密码
			</p>
			<input type="password" class="form-control" class="input" value=""
				name="newPass2" placeholder="ReEnter Password"> <br>

			<button type="submit" class=" btn btn-block  btn-lg btn-danger">提交修改</button>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
						$(document).ready(function() {
							$().UItoTop({ easingType: 'easeOutQuart' });
						});
					</script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
	<!--//footer-->

</body>
</html>