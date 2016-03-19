package me.hupeng.homeworkweb.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		removeSession();
		return SUCCESS;
	}
	
	private void removeSession(){
		ServletActionContext.getRequest().getSession().removeAttribute("userId");
		ServletActionContext.getRequest().getSession().removeAttribute("username");
		ServletActionContext.getRequest().getSession().removeAttribute("type");
	}
}
