<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style-courseware-info.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="./js/angular.min.js"></script>
<script type="text/javascript" src="js/post-manager-class.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
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
			<h3>查看班级成员</h3>
			<img class="img-responsive line-blog" src="images/li-3.png" alt="" />
		</div>
		<br> <br>
		<table class="table table-bordered table-hover table-responsive">
			<thead>
				<tr>
					<th><h4>序号</h4></th>
					<th><h4>学号</h4></th>
					<th><h4>姓名</h4></th>
					<th><h4>操作</h4></th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="list" id="result" status="index">
				<tr>
					<td><s:property value="#index.index+1"/></td>
					<td><s:property value="#result.num"/></td>
					<td><s:property value="#result.name"/></td>
					<td><a href='deleteChoiceClass.action?choiceClassId=<s:property value="#result.choiceClassId"/>'>删除</a></td>
				</tr>
			</s:iterator>
				<tr>
					<td>添加成员</td>
					<td><a href="addGroup.action?classId=${classId }">批量添加</a></td>
					<td><a href="addStudent.action?classId=${classId }">单个添加</a></td>
					<td><a href="deleteChoiceClass.action?classId=${classId }">全部删除</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	
		<jsp:include page="footer.jsp"></jsp:include>
	<a href="#" id="toTop" style="display: block;"> 
	<span
		id="toTopHover" style="opacity: 1;">
	</span>
	</a>
</body>
</html>
