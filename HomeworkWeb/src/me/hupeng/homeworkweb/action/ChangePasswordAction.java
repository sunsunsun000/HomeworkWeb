package me.hupeng.homeworkweb.action;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.service.UserService;
import me.hupeng.homeworkweb.util.Information;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport{
	private String oldPass;
	private String newPass1;
	private String newPass2;
	private String result;
	private UserService userService;
	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass1() {
		return newPass1;
	}

	public void setNewPass1(String newPass1) {
		this.newPass1 = newPass1;
	}

	public String getNewPass2() {
		return newPass2;
	}

	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkUser()) {
			return LOGIN;
		}
		if (ServletActionContext.getRequest().getMethod().equals("GET")) {
			return SUCCESS;
		}
		int status = userService.changPassword(securityAction.getUserId(), oldPass, newPass1, newPass2);
		if (status != 0) {
			result = "alert('" + new Information().getErrorInfo(status) + "');";
		}else {
			result ="alert('ÃÜÂëÐÞ¸Ä³É¹¦£¡')";
		}
		return SUCCESS;
	}
}
