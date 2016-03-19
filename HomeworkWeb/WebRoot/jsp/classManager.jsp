<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			<h3>班级管理</h3>
			<img class="img-responsive line-blog" src="images/li-3.png" alt="" />
		</div>
		<br> <br>
		<table class="table table-bordered table-hover table-responsive">
			<thead>
				<tr>
					<th><h4>班级名称名称</h4></th>
					<th><h4>班级公告</h4></th>
					<th><h4>查看班级成员</h4></th>
					<th><h4>操作</h4></th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="list" id="result">
				<tr>
					<td><a href='classInfo.action?classId=<s:property value="#result.i"/>'><s:property value="#result.className"/></a></td>
					<td><s:property value="#result.notice"/></td>
					<td>
						<button class="btn btn-danger" type="button" data-toggle="modal" onclick="location='showStudent.action?classId=<s:property value="#result.i"/>'" >查看成员</button>
					</td>
					<td>
						<button class="btn btn-danger" type="button" data-toggle="modal"
							data-target="#myModal<s:property value="#result.i"/>">点击删除</button>
						<div class="modal fade bs-example-modal-lg" id="myModal<s:property value="#result.i"/>"
							role="dialog" aria-label="myMoalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" style="color:#000">删除提醒</h3>
									</div>
									<div class="modal-body">
										<form>
											<h4 align="center">
												是否真的删除&nbsp;<strong><s:property value="#result.className"/></strong>&nbsp;
											</h4>
										</form>
									</div>
									<br> <br> <br>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger" onclick="location='<s:property value="#result.deleteUrl"/>'">删除</button>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
				</s:iterator>
				<tr>
					<td>新建班级</td>
					<td>
						<div style="float:left;">
							<button class="btn btn-danger " type="submit" data-toggle="modal" data-target="#theModal3">点击添加班级</button>
						</div>
						<!-- 模态框开始 -->
						<div class="modal fade bs-example-modal-lg" id="theModal3"
							role="dialog" aria-label="myMoalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" style="color:#000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加班级</h3>
									</div>
									<div class="modal-body">
										<form ng-controller="car">
											<input type="hidden" id="classId" value="1">
											<div class="form-group">
												<h3>班级名称：</h3>
												<input type="text" class="form-control" id="name" value="">
												<h3>班级公告：</h3>
												<textarea id="notice" class="form-control" cols="100"
													rows="6" class="autosave"></textarea>
											</div>
										</form>
									</div>
									<br> <br> <br>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
										<button type="button" class="btn btn-danger" id="button">添加</button>
									</div>
								</div>
							</div>
						</div>
					<!-- 模态框结束 -->
					</td>
					<td><button class="btn btn-danger " type="button"
							disabled="disabled">查看成员</button></td>
					<td><button class="btn btn-danger " type="button"
							disabled="disabled">点击删除</button></td>
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
