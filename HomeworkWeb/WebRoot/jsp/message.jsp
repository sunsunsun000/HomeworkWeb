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
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="css/style-change-password.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="refresh" content="5;url=${messageModel.url }">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
    $(function () {
      $("#slider1").responsiveSlides({
         auto: true,
		 nav: true,
		 speed: 500,
		 namespace: "callbacks",
      });
    });
  </script>
</head>
<body>
	<div class="top-header">
		<div class="container">
			<div class="footer-bottom"
				style=" position:fixed; top:0px; width:100%; left:0px;">
				<div class="top-nav">
					<label class="menu"></label>
					<ul>
						<jsp:include page="userTree.jsp"></jsp:include>
					</ul>
					<script>
					$("label.menu").click(function(){
						$(".top-nav ul").slideToggle(700, function(){
						});
					});
					</script>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="container" style="position:relative; top:150px;">
		<div class="portfolio-top">
			<h3>${messageModel.title }</h3>
			<img class="img-responsive line-grid" src="./images/li-1.png" alt="" />
			<br> <br>
			<h4>${messageModel.text }</h4>
		</div>
		<div class="bottom-portfolio">
			<img class="img-responsive grid-line" src="./images/li-2.png" alt=""
				style="position:relative; bottom:20px;" />
		</div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>