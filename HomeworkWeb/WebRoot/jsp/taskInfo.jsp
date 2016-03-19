<%@page import="me.hupeng.homeworkweb.model.TaskInfoModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
boolean adminFlag = (Boolean)request.getAttribute("adminFlag");
%>
<!DOCTYPE html>
<html>
<head lang="en">
<title>作业提交批改系统</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style-task-info.css" rel="stylesheet" type="text/css" media="all" />
<script src="./js/jquery.js"></script> 
<script type="text/javascript" src="./js/angular.min.js"></script>
<script type="text/javascript" src="./js/post-change-task.js" charset="utf8"></script>
<script src="js/bootstrap.min.js"></script> 
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<script>
	window.onload = function() {
		//定时器每秒调用一次fnDate()
		setInterval(function() {
			fnDate();
		}, 1000);
		setTimeout('myrefresh()',60000); //指定1秒刷新一次
	}
	function myrefresh() 
	{ 
       window.location.reload(); 
	} 
	 
	//js 获取当前时间
	function fnDate() {
		var oDiv = document.getElementById("div1");
		var date = new Date();
		var year = date.getFullYear();//当前年份
		var month = date.getMonth();//当前月份
		var data = date.getDate();//天
		var hours = date.getHours();//小时
		var minute = date.getMinutes();//分
		var second = date.getSeconds();//秒
		var time ="当前系统时间："+ year + "年" + fnW((month + 1)) + "月" + fnW(data) + "日"
				+ fnW(hours) + "时" + fnW(minute) + "分" + fnW(second) + "秒";
		oDiv.innerHTML = time;
	}
	//补位 当某个字段不是两位数时补0
	function fnW(str) {
		var num;
		str >= 10 ? num = str : num = "0" + str;
		return num;
	}
</script>

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
			<h3>作业提交</h3>
			<img class="img-responsive line-blog" src="images/li-3.png" alt="" />
		</div>
		<div class="jumbotron" style="position:relative; top:50px;">
			<h2 style="position: relative; left:200px'">作业名称：${taskInfoModel.taskName }</h2>
			<h2>作业描述：${taskInfoModel.description }</h2>
			<h2>作业状态：${taskInfoModel.status }</h2>
			<h2>截止提交时间：${taskInfoModel.endTime}</h2>
			<h2 id="div1"></h2>
			<h3>
				<span class="glyphicon glyphicon-bell"></span> &nbsp;好好学习，不要抄袭
			</h3>
			<br>
			<p>
			<div class="form-group">
			<%boolean isCan = ((TaskInfoModel)request.getAttribute("taskInfoModel")).isCan(); %>
			<%if(adminFlag == false){ %>
				<%if(isCan){ %>
				<form enctype="multipart/form-data" method="post" action="fileUpload.action">
					<p class="help-block">
						<span class="glyphicon glyphicon-bullhorn"></span> :请选择您要上传的作业文件
					</p>
					<input type="hidden" name="taskId" value="${taskId }">
					<input type="file" name="file" class="btn btn-danger btn-lg"> <br>
					<input type="submit" class="btn  btn-danger btn-lg btn-block" style="width:325px;" value="提交作业&nbsp;&raquo;&raquo;&raquo;">
				</form>
				<%} %>
			<%}else{ %>
				<button class="btn btn-danger btn-lg" type="button"
					data-toggle="modal" data-target="#myModal3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改作业信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
				<div class="modal fade bs-example-modal-lg" id="myModal3"
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
									<input type="hidden" id="taskId" value="${taskId }">
									<div class="form-group">
										<h3>作业名称：</h3>
										<input type="text" class="form-control" id="name" value="${taskInfoModel.taskName }">
										<h3>作业描述：</h3>
										<textarea id="description" class="form-control"
											cols="100" rows="6" class="autosave">${taskInfoModel.description }</textarea>
										<h3>截止提交时间：</h3>
										<div class="form-group" style="float:left;">
											<input type="text" class="form-control" style="width: auto;" id="year">
										</div>
										<div style="float:left;">
											<p>&nbsp;年&nbsp;</p>
										</div>
										<div class="form-group" style="float:left;">
											<input type="text" class="form-control" style="width: auto;" id="month">
										</div>
										<div style="float:left;">
											<p>&nbsp;月&nbsp;</p>
										</div>
										<div class="form-group" style="float:left;">
											<input type="text" class="form-control" style="width: auto;" id="day">
										</div>
										<div style="float:left;">
											<p>&nbsp;日&nbsp;</p>
										</div>
										<div class="form-group" style="float:left;">
											<input type="text" class="form-control" style="width: auto;" id="hour">
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
				<br> <br>
				<button class="btn btn-danger btn-lg" type="button" onclick="window.location.href='correctTask.action?taskId=${taskId}'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;批改作业&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
			<%} %>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="footer.jsp"></jsp:include>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>