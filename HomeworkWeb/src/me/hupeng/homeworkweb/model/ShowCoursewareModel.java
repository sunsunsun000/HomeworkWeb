package me.hupeng.homeworkweb.model;

import me.hupeng.homeworkweb.bean.Courseware;

public class ShowCoursewareModel {
	private String name;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ShowCoursewareModel(){}
	public ShowCoursewareModel(Courseware courseware){
		this.name = courseware.getFilename();
		this.url = "downloadCourseware.action?cid=" + courseware.getCoursewareId();
	}
}
