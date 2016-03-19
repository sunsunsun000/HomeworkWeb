package me.hupeng.homeworkweb.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub֤
		if (new SecurityAction().checkUser()== false) {
			return "login";
		}
		return SUCCESS;
	}
	
}
