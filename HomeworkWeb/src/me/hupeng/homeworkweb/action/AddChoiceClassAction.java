package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.service.ChoiceclassService;

import com.opensymphony.xwork2.ActionSupport;

public class AddChoiceClassAction extends ActionSupport{
	private String classId;
	private ChoiceclassService choiceclassService;
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public ChoiceclassService getChoiceclassService() {
		return choiceclassService;
	}

	public void setChoiceclassService(ChoiceclassService choiceclassService) {
		this.choiceclassService = choiceclassService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkUser()) {
			return LOGIN;
		}
		Integer classIdInteger;
		try {
			classIdInteger = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			return SUCCESS;
		}
		choiceclassService.add(classIdInteger, securityAction.getUserId());
		return SUCCESS;
	}
}
