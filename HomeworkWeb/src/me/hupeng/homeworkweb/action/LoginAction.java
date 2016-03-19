package me.hupeng.homeworkweb.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.User;
import me.hupeng.homeworkweb.model.UserModel;
import me.hupeng.homeworkweb.service.UserService;
import me.hupeng.homeworkweb.util.Information;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String username;
	private String password;
	private String checkCode;
	private UserService userService;
	private UserModel userModel;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (ServletActionContext.getRequest().getMethod().equals("GET")) {
			return ERROR;
		}else {
			int stateCode = userService.login(username, password, checkCode, getCurrentCheckCode(),getIp());
			if (stateCode==0) {
				userModel = new UserModel(userService.getUser());
				setSession(userModel.getUserId(), userModel.getUsername(), userModel.getType());
				return SUCCESS;
			}else {
				userModel = new UserModel(stateCode,"alert('"+new Information().getErrorInfo(stateCode)+"');");
			}
		}
		return ERROR;
	}
	
	private String getCurrentCheckCode(){
		return (String) ActionContext.getContext().getSession().get("checkCode");
		//return (String) ServletActionContext.getRequest().getSession().getAttribute("checkCode");
	}
	
	private String getIp(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	private void setSession(int userId,String username,int type){
		ServletActionContext.getRequest().getSession().setAttribute("userId", userId);
		ServletActionContext.getRequest().getSession().setAttribute("username", username);
		ServletActionContext.getRequest().getSession().setAttribute("type", type);
		ServletActionContext.getRequest().getSession().setAttribute("name", userModel.getStuNum());
	}
}
