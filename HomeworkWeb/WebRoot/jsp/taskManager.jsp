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
<script type="text/javascript" src="js/post-manager-task.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	$("#myModal4").on("show.bs.modal",function(e){
	var button=$(e.relatedTarget)
	var recipient=button.data("whatever");
	var modal=$(this);
	modal.find(".media-body input").val(recipient);
	})
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
			<h3>作业管理</h3>
			<img class="img-responsive line-blog" src="images/li-3.png" alt="" />
		</div>
		<br> <br>
		<table class="table table-bordered table-hover table-responsive">
			<thead>
				<tr>
					<th><h4>作业名称</h4></th>
					<th><h4>作业描述</h4></th>
					<th><h4>操作</h4></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="list" id="result">
				<tr>
					<td><a href="<s:property value="#result.url"/>"><s:property value="#result.name"/></a></td>
					<td><s:property value="#result.description"/></td>
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
												是否真的删除&nbsp;<strong><s:property value="#result.name"/></strong>&nbsp;
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
					<td>新建作业</td>
					<td>
						<div style="float:left;">
							<button class="btn btn-danger " type="submit" data-toggle="modal" data-target="#Modal3">点击添加作业</button>
						</div>
						<!-- 模态框开始 -->
						<div class="modal fade bs-example-modal-lg" id="Modal3"
							role="dialog" aria-label="myMoalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" style="color:#000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改作业信息</h3>
									</div>
									<div class="modal-body">
										<form ng-controller="car">
											<input type="hidden" id="classId" value="${classId }">
											<div class="form-group">
												<h3>作业名称：</h3>
												<input type="text" class="form-control" id="name" value="">
												<h3>作业描述：</h3>
												<textarea id="description" class="form-control" cols="100"
													rows="6" class="autosave"></textarea>
												<h3>截止提交时间：</h3>
												<div class="form-group" style="float:left;">
													<input type="text" class="form-control"
														style="width: auto;" id="year">
												</div>
												<div style="float:left;">
													<p>&nbsp;年&nbsp;</p>
												</div>
												<div class="form-group" style="float:left;">
													<input type="text" class="form-control"
														style="width: auto;" id="month">
												</div>
												<div style="float:left;">
													<p>&nbsp;月&nbsp;</p>
												</div>
												<div class="form-group" style="float:left;">
													<input type="text" class="form-control"
														style="width: auto;" id="day">
												</div>
												<div style="float:left;">
													<p>&nbsp;日&nbsp;</p>
												</div>
												<div class="form-group" style="float:left;">
													<input type="text" class="form-control"
														style="width: auto;" id="hour">
												</div>
												<div style="float:left;">
													<p>&nbsp;时&nbsp;</p>
												</div>
											</div>
										</form>
									</div>
									<br> <br> <br>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
										<button type="button" class="btn btn-danger" id="button">保存</button>
									</div>
								</div>
							</div>
						</div>
					<!-- 模态框结束 -->
					</td>
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
