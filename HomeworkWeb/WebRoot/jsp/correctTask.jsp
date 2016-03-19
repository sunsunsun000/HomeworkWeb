<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%int length = ((List)request.getAttribute("list")).size(); %>

<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="css/style-correct-task.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/post.js"></script>
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
<body ng-app="app">
	<div class="top-header">
		<div class="container">
			<div class="footer-bottom"
				style=" position:fixed; top:0px; width:100%; left:0px;">
				<div class="top-nav">
					<label class="menu"></label>
					<ul>
						<jsp:include page="userTree.jsp"></jsp:include>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="container" style=" position:relative; top:150px;">
		<div class="blog-top">
			<h3>作业批改</h3>
			<img class="img-responsive line-blog" src="images/li-3.png" alt="" />
		</div>
		<br> <br>
		<table class="table table-bordered table-hover table-responsive">
			<thead>
				<tr>
					<th>姓名</th>
					<th>学号</th>
					<th>提交时间</th>
					<th>操作</th>
					<th style="width:15%">提交成绩</th>
					<th>成绩</th>
				</tr>
			</thead>

			<tbody ng-controller="car">
				<s:iterator value="list" id="result">
				<tr>
					<td><s:property value="#result.stuNum"/></td>
			      	<td><s:property value="#result.username"/></td>
			        <td><s:property value="#result.submitTime"/></td>
			        <td><a href="<s:property value="#result.downloadUrl"/>">下载作业</a></td>
					<td>
						<div class="input-group">
							<input type="hidden" id="homeworkId" value="<s:property value="#result.homeworkId"/>">
							<input type="number" class="form-control" placeholder="输入成绩" id="grade"> 
							<span class="input-group-btn">
								<button class="btn btn-default post" type="button">提交</button>
							</span>
						</div>
					</td>
					<td>
						<p id="showGrade_<s:property value="#result.homeworkId"/>"><s:property value="#result.grade"/></p>
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
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
	<%for(int i=0;i<20-length;i++){ %>
	<br>
	<%} %>
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