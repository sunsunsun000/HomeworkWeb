package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.model.UserModel;
import me.hupeng.homeworkweb.service.UserService;
import me.hupeng.homeworkweb.util.Information;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport{
	private UserService userService;
	private String username;
	private String password;
	private String rePassword;
	private String checkCode;
	private String stuNum;
	private String reg_type;
	private UserModel userModel;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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



	public String getRePassword() {
		return rePassword;
	}



	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}



	public String getCheckCode() {
		return checkCode;
	}



	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}



	public String getStuNum() {
		return stuNum;
	}



	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	

	public String getReg_type() {
		return reg_type;
	}

	public void setReg_type(String reg_type) {
		this.reg_type = reg_type;
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
			if (reg_type == null || !reg_type.contains("teacher")) {
				return "error_stu";
			}else {
				return "error_teacher";
			}
		}
		else {
			int stateCode;
			if (reg_type == null || !reg_type.contains("teacher")) {
				stateCode = userService.registerStu(username, password, rePassword, stuNum, checkCode, getCurrentCheckCode(),getIp());
			}else {
				stuNum = username;
				stateCode = userService.registerTeacher(username, password, rePassword, checkCode, getCurrentCheckCode(),getIp());
			}
			if (stateCode==0) {
				userModel = new UserModel(userService.getUser());
				setSession(userModel.getUserId(), userModel.getUsername(), userModel.getType());
				return SUCCESS;
			}else {
				userModel = new UserModel(stateCode,"alert('"+new Information().getErrorInfo(stateCode)+"');");
			}
		}
		if (reg_type == null || !reg_type.contains("teacher")) {
			return "error_stu";
		}else {
			return "error_teacher";
		}
	}
	
	private String getCurrentCheckCode(){
		return (String) ActionContext.getContext().getSession().get("checkCode");
		//return (String) ServletActionContext.getRequest().getSession().getAttribute("checkCode");
	}
	
	private String getIp(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	private void setSession(int userId,String username,int type){
		ServletActionContext.getRequest().getSession().setAttribute("stuNum", stuNum);
		ServletActionContext.getRequest().getSession().setAttribute("userId", userId);
		ServletActionContext.getRequest().getSession().setAttribute("username", username);
		ServletActionContext.getRequest().getSession().setAttribute("type", type);
	}
	
}
