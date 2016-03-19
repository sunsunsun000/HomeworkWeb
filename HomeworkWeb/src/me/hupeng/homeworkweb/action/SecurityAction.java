package me.hupeng.homeworkweb.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SecurityAction extends ActionSupport{
	public boolean checkStudent(){
		if (getUserId() == null || getUsername() == null || getType() == null) {
			return false;
		}
		if (getType() == 1 || getType() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkTeacher(){
		if (getUserId() == null || getUsername() == null || getType() == null) {
			return false;
		}
		if (getType() == 2 || getType() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkAdmin(){
		if (getUserId() == null || getUsername() == null || getType() == null) {
			return false;
		}
		if (getType() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkUser(){
		if (getUserId() == null || getUsername() == null || getType() == null) {
			return false;
		}
		return true;
	}
	
	
	public Integer getUserId(){
		return (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
	}
	
	public String getUsername(){
		return (String)ServletActionContext.getRequest().getSession().getAttribute("username");
	}
	
	public Integer getType(){
		return (Integer)ServletActionContext.getRequest().getSession().getAttribute("type");
	}
	
	public String getStuNum(){
		if ((String)ServletActionContext.getRequest().getSession().getAttribute("stuNum") == null) {
			return (String)ServletActionContext.getRequest().getSession().getAttribute("username");
		}
		return (String)ServletActionContext.getRequest().getSession().getAttribute("stuNum");
	}
}
