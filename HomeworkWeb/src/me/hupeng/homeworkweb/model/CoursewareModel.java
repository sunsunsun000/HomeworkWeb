package me.hupeng.homeworkweb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.hupeng.homeworkweb.bean.Courseware;

public class CoursewareModel {
	private String name;
	private String updateTime;
	private String deleteUrl;
	private Integer i;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
	public CoursewareModel(){
		
	}
	public CoursewareModel(String name,String updateTime,String deleteUrl){
		this.name = name;
		this.updateTime = updateTime;
		this.deleteUrl = deleteUrl;
	}
	public void setData(String name,String updateTime,String deleteUrl){
		this.name = name;
		this.updateTime = updateTime;
		this.deleteUrl = deleteUrl;
	}
	public CoursewareModel(Courseware courseware){
		if (courseware == null) {
			return;
		}
		this.name = courseware.getFilename();
		this.updateTime = getStringTime(courseware.getUpdateTime());
		this.deleteUrl = "deleteCourseware.action?cid=" + courseware.getCoursewareId(); 
		this.i = courseware.getCoursewareId();
	}
	
	private String getStringTime(String time){
		long t;
		try {
			t = Long.parseLong(time);
			Date date = new Date(t);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
			return simpleDateFormat.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
