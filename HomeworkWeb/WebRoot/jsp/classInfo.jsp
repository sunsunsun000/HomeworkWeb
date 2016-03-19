<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%boolean adminFlag = (Boolean) request.getAttribute("adminFlag");%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String url; %>
<%int type = (Integer)request.getSession().getAttribute("type");%>
<%if(type == 1) {url="choiceClass.action";}else{url = "classManager.action";}%>
<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style-home.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/angular.min.js"></script>
<script type="text/javascript" src="./js/post-change-notice.js" charset=""></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
					<script type="text/javascript">

					</script>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="content" style="position:relative;  top:100px;">
		<div class="global-design" id="about">
			<div class="container">
				<div class=" idea-get">
					<a href="#"><img src="./images/ca.png" alt="" /></a>
					<h4>当前班级</h4>
					<br> <br> <br> <br>
					<button class="btn btn-danger btn-lg" type="button" onclick="location='<%=url%>'">${classes.className }</button>
					<br> <br> <br>
				</div>
				<div class="idea-get">
					<a href="#"><img src="./images/gla.png" alt="" /></a>
					<h4>班级公告栏</h4>
					<p id="notice">${classes.notice }</p>
					<br><br><br>
					<%if(adminFlag == true){ %>
					<button class="btn btn-danger btn-lg" type="button"
						data-toggle="modal" data-target="#myModal">修改公告</button>
					<div class="modal fade bs-example-modal-lg" id="myModal"
						role="dialog" aria-label="myMoalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h3 class="modal-title" style="color:#000">修改公告</h3>
								</div>
								<div class="modal-body">
									<form>
										<input type="hidden" id="classId" value="${classes.classId }">
										<div class="form-group">
											<label class="control-label"></label> <br> <br>
											<textarea name="New announcement" cols="60" rows="10"
												class="autosave" placeholder="请输入新公告！" id="new_notice"></textarea>
										</div>
									</form>
								</div>
								<div class="modal-footer" ng-controller="car">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="button" id="button" class="btn btn-danger post-change-notice">保存</button>
								</div>
							</div>
						</div>
					</div>
					<%} %>
					<br> <br> <br>
				</div>
				<div class=" idea-get">
					<a href="#"><img src="./images/glo.png" alt="" /></a>
					<h4>PPT列表</h4>
					<br> <br>
					<button class="btn btn-danger btn-lg" type="button" data-toggle="modal" data-target="#myModal1">点击查看PPT</button>
					<%if(adminFlag == true){ %>
					<br><br>
					<button class="btn btn-danger btn-lg" type="button" onclick="location='coursewareInfo.action?classId=${classes.classId }'">点击管理PPT</button>
					<%} %>
					<div class="modal fade bs-example-modal-lg" id="myModal1"
						role="dialog" aria-label="myMoalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h3 class="modal-title" style="color:#000">课件PPT列表</h3>
								</div>
								<div class="modal-body">
									<form>
										<div class="form-group">
											<label class="control-label"></label> <br> <br>
											<div class="list-group"
												style="width:70%; position:relative; left:128px;">
											<s:iterator value="coursewareModelList" id="result">
												<a href="<s:property value="#result.url"/>" class="list-group-item"><s:property value="#result.name"/></a> 
												
											</s:iterator>
											</div>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								</div>
							</div>
						</div>
					</div>
					<br> <br> <br>
				</div>
				<div class=" idea-get we-get-grid">
					<a href="#"><img src="./images/glo.png" alt="" /></a>
					<h4>作业列表</h4>
					<div class="list-group">
						<br> <br>
						<button class="btn btn-danger btn-lg" type="button" data-toggle="modal" data-target="#myModal2">点击查看作业</button>
						<%if(adminFlag){ %>
						<br><br>
						<button class="btn btn-danger btn-lg" type="button" onclick="location='taskManager.action?classId=${classes.classId }'">点击管理作业</button>
						<%} %>
						<div class="modal fade bs-example-modal-lg" id="myModal2"
							role="dialog" aria-label="myMoalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" style="color:#000">作业列表</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="control-label"></label> <br> <br>
												<div class="list-group"
													style="width:70%; position: relative;left:128px;">
												<s:iterator value="taskList" id="result">
													<a href="<s:property value="#result.url"/>" class="list-group-item"><s:property value="#result.taskName"/></a>
												</s:iterator> 
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
									</div>
								</div>
							</div>
						</div>
						<br> <br>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		<a href="#" id="toTop" style="display: block;"> <span
			id="toTopHover" style="opacity: 1;"> </span></a>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script>
		</script>
	</div>
</body>
</html>