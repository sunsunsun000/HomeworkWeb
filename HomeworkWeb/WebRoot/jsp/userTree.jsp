<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	int type = (Integer)request.getSession().getAttribute("type");
	if(type == 1){
%>
						<li><a href="home.action" class="scroll">主页<span class="home"> </span></a></li>
						<li><a href="classInfo.action" class="scroll">作业提交<span class="us-box"> </span></a></li>
						<li><a href="showGrade.action" class="scroll">成绩查看<span class="port-box"> </span></a></li>
						<li><a href="feedback.action" class="scroll">问题反馈<span class="tack-box"> </span></a></li>
                        <li style="position:relative; right:0px; top:0px;"><a href="changePassword.action" class="scroll">${name }<span class="home"></span></a></li>
                        <li style="position:relative; right:0px; top:0px;"><a href="javascript:if(confirm('您确定要注销吗?')) window.location.href='logout.action';" class="scroll">注销<span class="home"></span></a></li>
<%}%>
<%if(type == 2){%>
						<li><a href="home.action" class="scroll">主页<span class="home"> </span></a></li>
						<li><a href="classInfo.action" class="scroll">班级管理<span class="us-box"> </span></a></li>
						<li><a href="feedback.action" class="scroll">问题反馈<span class="tack-box"> </span></a></li>
                        <li style="position:relative; right:0px; top:0px;"><a href="changePassword.action" class="scroll">${name }<span class="home"></span></a></li>
                        <li style="position:relative; right:0px; top:0px;"><a href="javascript:if(confirm('您确定要注销吗?')) window.location.href='logout.action';" class="scroll">注销<span class="home"></span></a></li>
<%} %>