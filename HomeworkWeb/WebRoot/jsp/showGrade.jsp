<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!--theme-style-->
<link href="css/style-show-grade.css" rel="stylesheet" type="text/css"
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
<script src="js_score/jquery.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--script-->
<script src="js_score/responsiveslides.min.js"></script>
<script>
	// You can also use "$(window).load(function() {"
	$(function() {
		// Slideshow 1
		$("#slider1").responsiveSlides({
			auto : true,
			nav : true,
			speed : 500,
			namespace : "callbacks",
		});
	});
</script>
</head>
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
						$("label.menu").click(function() {
							$(".top-nav ul").slideToggle(700, function() {
							});
						});
					</script>
					<script type="text/javascript">
						jQuery(document).ready(function($) {
							$(".scroll").click(function(event) {
								event.preventDefault();
								$('html,body').animate({
									scrollTop : $(this.hash).offset().top
								}, 1000);
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
	<div class="container" style="position:relative; top:160px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-education"></span>&nbsp;作业成绩查看
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>序号</th>
						<th>班级名称</th>
						<th>作业名称</th>
						<th>提交时间</th>
						<th>当前分数</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="list" id="result">
					<tr>
						<td><s:property value="#result.num"/></td>
						<td><s:property value="#result.className"/></td>
						<td><s:property value="#result.taskName"/></td>
						<td><s:property value="#result.time"/></td>
						<td><s:property value="#result.grade"/></td>
					</tr>
					</s:iterator> 
				</tbody>
			</table>
			<div class="panel-footer">
				<span class="glyphicon glyphicon-paperclip"></span>&nbsp;当作业批改完成后，会自动生成作业成绩，方可查询
			</div>
		</div>
	</div>
	<!--/possible-->
	<%Integer size = (Integer)request.getAttribute("size"); %>
	<%for(int i=0;i<24-2*size;i++){ %>
	<br>
	<%} %>
	<!--footer-->
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
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