package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.bean.Choiceclass;
import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 此页面存在漏洞，暂不处理*/
public class DeleteChoiceClassAction extends ActionSupport{
	private String choiceClassId;
	private ChoiceclassService choiceclassService;
	private String classId;
	private ClassesService classesService;
	private UserService userService;
	public String getChoiceClassId() {
		return choiceClassId;
	}

	public void setChoiceClassId(String choiceClassId) {
		this.choiceClassId = choiceClassId;
	}

	public ChoiceclassService getChoiceclassService() {
		return choiceclassService;
	}

	public void setChoiceclassService(ChoiceclassService choiceclassService) {
		this.choiceclassService = choiceclassService;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
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
		if (classId!=null) {
			int cId = 0;
			try {
				cId = Integer.parseInt(classId);
				Classes classes = classesService.getClassByClassId(cId);
				if (classes.getUserId().equals(securityAction.getUserId())) {
					choiceclassService.deleteByClassId(cId);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return SUCCESS;
			}
			return SUCCESS;
		}
		Integer choiceClassIdiInteger;
		try {
			choiceClassIdiInteger = Integer.parseInt(choiceClassId);
		} catch (Exception e) {
			// TODO: handle exception
			return SUCCESS;
		}
		Choiceclass choiceclass = choiceclassService.getChoiceclassById(choiceClassIdiInteger);
		int cId = choiceclass.getClassId();
		try {
			classId = cId + "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		Classes classes = classesService.getClassByClassId(cId);
		if (classes.getUserId().equals(securityAction.getUserId())) {
			choiceclassService.deleteChoiceClass(choiceClassIdiInteger);
		}
		return SUCCESS;
	}
}
