<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<link href="./css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--theme-style-->
<link href="./css/style-feedback.css" rel="stylesheet" type="text/css"
	media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/move-top.js"></script>
<script type="text/javascript" src="./js/easing.js"></script>
<!--script-->
<script src="./js/responsiveslides.min.js"></script>
</head>
<script type="text/javascript">
	${ userModel.errorInfo}
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
						<jsp:include page="/jsp/userTree.jsp"></jsp:include>
					</ul>

					<!-- script-nav -->
					<script>
						$("label.menu").click(function() {
							$(".top-nav ul").slideToggle(700, function() {
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
	<!--//content-->
	<!--footer-->
	<div class="contact" id="contact">
		<div class="container" style="position:relative; top:140px;">
			<div class="contact-top">
				<h3>问题反馈</h3>
				<img class="img-responsive line-grid" src="./images/li-1.png" alt="" />
				<p>
					请详细填写您的 <b>邮箱地址</b> ，方便我们与您取得联系。请您详细填写 <b>问题描述、包括问题发生的界面、问题发生后的表现等</b>，以方便与我们的改进！
				</p>
			</div>
			<form method="post">
				<div class="contact-grid">
					<div class="col-md-6 contact-us">
						<input type="text" class="input" value="${ username}"
							placeholder="用户名" readonly="readonly">
					</div>
					<div class="col-md-6 contact-us">
						<input type="text" class="input" value="" name="email"
							placeholder="邮箱地址">
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="contact-grid">

					<div class="clearfix"></div>
				</div>
				<textarea cols="77" rows="6" name="text"
					placeholder="请填写您的宝贵意见 ... ..."></textarea>
				<div class="send">
					<input type="submit" value="提交反馈">
				</div>
			</form>
			<div class="contact-bottom">
				<div class="col-md-5 sit-contact">
					<h5>您可以通过以下方式与我们取得联系：</h5>
					<div class="contact-add">
						<p>联系电话：188-4716-3389</p>
						<p>电子邮箱：hupeng@imudges.com</p>
					</div>
					<%--
					<h5>您可以通过右侧的地图导航找到我们：</h5>
					<div class="contact-add">
						<p>通讯地址：内蒙古大学计算机学院404</p>
						<p>邮政编码：010010</p>
					</div>
					<ul class="face">
						<li class="active"><a href="#">Facebook </a><span>/</span></li>
						<li><a href="#">Twitter </a><span>/</span></li>
						<li><a href="#">Personal Web </a><span>/</span></li>
						<li><a href="#">Link In</a></li>
					</ul>
				</div>
				 --%>
					<div class="col-md-7">
						<div class="map">
							<!--位置信息位置信息位置信息位置信息位置信息位置信息位置信息位置信息位置信息位置信息-->
						</div>
						<span class="map-icon"> </span>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
	<!--//footer-->

</body>
</html>