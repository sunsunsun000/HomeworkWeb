package me.hupeng.homeworkweb.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.hupeng.homeworkweb.bean.Task;


public class TaskInfoModel {
	private String taskName;
	private String description;
	private String status;
	private String endTime;
	private boolean isCan;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isCan() {
		return isCan;
	}
	public void setCan(boolean isCan) {
		this.isCan = isCan;
	}
	public TaskInfoModel(Task task){
		this.taskName = task.getTaskName();
		this.description = task.getDescription();
		Date endDate=new Date(Long.parseLong(task.getEndTime()));
		DateFormat format=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		this.endTime = format.format(endDate);
		if (Long.parseLong(task.getEndTime())>System.currentTimeMillis()) {
			this.status = "当前可以提交";
			isCan = true;
		}else {
			this.status = "当前无法提交";
			isCan = false;
		}
	}
}
