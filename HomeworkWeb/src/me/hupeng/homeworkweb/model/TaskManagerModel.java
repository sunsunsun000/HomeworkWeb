package me.hupeng.homeworkweb.model;

import me.hupeng.homeworkweb.bean.Task;

public class TaskManagerModel {
	private String name;
	private String description;
	private String deleteUrl;
	private Integer i;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeleteUrl() {
		return deleteUrl;
	}
	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}
	public Integer getI() {
		return i;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public TaskManagerModel(){
		
	}
	
	public TaskManagerModel(Task task){
		this.name = task.getTaskName();
		this.description = task.getDescription();
		this.deleteUrl = "deleteTask.action?taskId=" + task.getTaskId();
		this.url = "taskInfo.action?taskId=" + task.getTaskId();
		this.i = task.getTaskId();
	}
}
