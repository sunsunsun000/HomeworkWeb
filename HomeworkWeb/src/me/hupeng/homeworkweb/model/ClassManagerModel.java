package me.hupeng.homeworkweb.model;

import me.hupeng.homeworkweb.bean.Classes;

public class ClassManagerModel {
	private String className;
	private String notice;
	private String deleteUrl;
	private Integer i;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
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
	public ClassManagerModel(Classes classes){
		if (classes == null) {
			return;
		}
		className  = classes.getClassName();
		notice = classes.getNotice();
		deleteUrl = "deleteClass.action?classId=" + classes.getClassId();
		i = classes.getClassId();
	}
}
