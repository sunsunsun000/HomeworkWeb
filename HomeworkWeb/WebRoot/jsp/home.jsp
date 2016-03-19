<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<link href="./css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--theme-style-->
<link href="./css/student_home_style.css" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
<body style="background-color:#262626">
	<!--header-->
	<div class="header">
		<div class="slider">
			<ul class="rslides" id="slider1">
			
				<li><img src="./images/banner.jpg" alt="">
					<div class="header-matter">
						<h2>
							作业批改<span>系统</span>
						</h2>
						<label class="make"> </label>
						<div class="matter-we">
							<a class="we-better" href="#"> <span> </span>
							</a>
							<div class=" better">
								<h4>作业课件</h4>
								<label>管理系统</label>
								<p>2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div></li>
					
				<li><img src="./images/banner.jpg" alt="">
					<div class="header-matter">
						<h2>
							作业批改<span>系统</span>
						</h2>
						<label class="make"> </label>
						<div class="matter-we">
							<a class="we-better" href="#"> <span> </span>
							</a>
							<div class=" better">
								<h4>系统</h4>
								<label>公告1</label>
								<p>2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div></li>

				<li><img src="./images/banner.jpg" alt="">
					<div class="header-matter">
						<h2>
							作业批改<span>系统</span>
						</h2>
						<label class="make"> </label>
						<div class="matter-we">
							<a class="we-better" href="#"> <span> </span>
							</a>
							<div class=" better">
								<h4>系统</h4>
								<label>公告2</label>
								<p><p>2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！2.0全新概念版，尽请期待！</p></p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div></li>
			</ul>
		</div>
		<!---->
		<div class="top-header">
			<div class="container">
				<div class="top-nav">
					<label class="menu"> </label>
					<ul>
<jsp:include page="/jsp/userTree.jsp"></jsp:include>
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
	<!--//header-->
	<!--content-->
	<!---->

	<!---->

	<!--script-->
	<script>
							$(document).ready(function(){
								$(".tab1 p").hide();
								$(".tab2 p").hide();
								$(".tab3 p").hide();
								$(".tab4 p").hide();
								$(".tab5 p").hide();
								$(".tab1 ul").click(function(){
									$(".tab1 p").slideToggle(300);
									$(".tab2 p").hide();
									$(".tab3 p").hide();
									$(".tab4 p").hide();
									$(".tab5 p").hide();
								})
								$(".tab2 ul").click(function(){
									$(".tab2 p").slideToggle(300);
									$(".tab1 p").hide();
									$(".tab3 p").hide();
									$(".tab4 p").hide();
									$(".tab5 p").hide();
								})
								$(".tab3 ul").click(function(){
									$(".tab3 p").slideToggle(300);
									$(".tab4 p").hide();
									$(".tab5 p").hide();
									$(".tab2 p").hide();
									$(".tab1 p").hide();
								})
								$(".tab4 ul").click(function(){
									$(".tab4 p").slideToggle(300);
									$(".tab3 p").hide();
									$(".tab2 p").hide();
									$(".tab1 p").hide();
									$(".tab5 p").hide();
								})
								$(".tab5 ul").click(function(){
									$(".tab5 p").slideToggle(300);
									$(".tab4 p").hide();
									$(".tab3 p").hide();
									$(".tab2 p").hide();
									$(".tab1 p").hide();
									
								})
								
							});
						</script>
	<!-- script -->
	<!---->

	<!---->

	<!---->

	<!---->

	<!--//content-->
	<!--footer-->

	<!--footer-->
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
	<script type="text/javascript"> 		
					$(document).ready(function() {
					$().UItoTop({ easingType: 'easeOutQuart' });
				});
			</script>
	<a href="#" id="toTop" style="display: block;"> 
	<span
		id="toTopHover" style="opacity: 1;">
	</span></a>
	<!--//footer-->

	<!--//footer-->
</body>
</html>