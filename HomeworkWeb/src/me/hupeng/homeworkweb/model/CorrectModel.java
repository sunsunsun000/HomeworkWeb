package me.hupeng.homeworkweb.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import me.hupeng.homeworkweb.bean.Homework;
import me.hupeng.homeworkweb.bean.User;

public class CorrectModel {
	public String stuNum;
	public String username;
	public String submitTime;
	public String downloadUrl;
	public String homeworkId;
	public String grade;
	public List<User>userList;
	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public String getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public CorrectModel(User user,Homework homework){
		if (user == null || homework == null) {
			return;
		}
		username = user.getUsername();
		stuNum = user.getStuNum();
		submitTime = getTime(Long.parseLong(homework.getSubmitTime()));
		downloadUrl = "fileDownload.action?homeworkId=" + homework.getHomeworkId();
		homeworkId = homework.getHomeworkId() + "";
		grade = homework.getGrade();
	}
	
	private String getTime(long time){
		Date endDate=new Date(time);
		DateFormat format=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String submitTime=format.format(endDate);
		return submitTime;
	}
	
	
	public CorrectModel(User user){
		if (user == null) {
			return;
		}
		username = user.getUsername();
		stuNum = user.getStuNum();
		submitTime = "未提交作业";
		downloadUrl = "#";
		homeworkId = null;
		grade = "无";
	}
}
