package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.model.UserModel;
import me.hupeng.homeworkweb.service.BugService;
import me.hupeng.homeworkweb.service.UserService;
import me.hupeng.homeworkweb.util.Information;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FeedbackAction extends ActionSupport{
	
	private String email;
	private String text;
	private UserModel userModel;
	private BugService bugService;
	
	public BugService getBugService() {
		return bugService;
	}

	public void setBugService(BugService bugService) {
		this.bugService = bugService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
		if (new SecurityAction().checkUser() == false) {
			return "login";
		}
		userModel = null;
		if (ServletActionContext.getRequest().getMethod().equals("POST")) {
			int stateCode = bugService.add(getUserId(), email, text);
			if (stateCode != 0) {
				userModel = new UserModel(stateCode,"alert('"+ new Information().getErrorInfo(stateCode) + "');");
			}else {
				userModel = new UserModel(stateCode,"alert('反馈提交成功！');");
			}
		}
		return SUCCESS;
	}
	
	public int getUserId(){
		return (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
	}
}
