<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%Integer size = (Integer)request.getAttribute("size"); %>
<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="css/style-choice-class.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js_class/move-top.js"></script>
<script type="text/javascript" src="js_class/easing.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
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
						$("label.menu").click(function() {
							$(".top-nav ul").slideToggle(700, function() {
							});
						});
					</script>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="mybody container">
		<div class="container" style="position:relative; top:150px;">
			<div class="row">
				<div class="leftmenu col-md-4 ">
					<form>
						<div class="input-group" style="width:300px;">
							<%-- 
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span> 
							
							<form>
								<input type="search" name="keyword" class="form-control" placeholder="请输入您要搜索的班级">
							</form>
							--%>
						</div>
						<br> <br>
						<%if(size==0){ %>
						你当前未加入任何班级
						<%} %>
						<div class="btn-group">
							<s:iterator value="list" id="result">
							<button type="button" class="btn btn-lg btn-danger" onclick="window.location.href='<s:property value="#result.url"/>'"
								class="dropdown-toggle" data-toggle="dropdown">
								<span class="glyphicon glyphicon-th-list"></span> &nbsp;
								&nbsp;<s:property value="#result.className"/>
								<button type="button" class="btn btn-lg btn-danger "
									class="dropdown-toggle" data-toggle="dropdown">
									&times;</button>
							</button>
							<br>
							</s:iterator> 
					</form>
				</div>
			</div>
			<div class="content col-md-5 col-md-offset-2">
				<p>
				<%Boolean flag = (Boolean)request.getAttribute("flag"); %>
				<%if(!flag) {%>
				<span class="glyphicon glyphicon-remove-circle"></span>&nbsp;&nbsp;对不起！您搜索的班级没有找到！
				<%} %>
					
				</p>
				<div class="list-group">
				<s:iterator value="classModelList" id="result">
					<a href="<s:property value="#result.url"/>" class="list-group-item"><s:property value="#result.className"/></a> 
				</s:iterator> 
				</div>
			</div>
		</div>
	</div>
	</div>
	
	<%for(int i=0;i<30-2*size;i++){ %>
	<br>
	<%} %>
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
</body>
</html>