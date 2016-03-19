package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import me.hupeng.homeworkweb.bean.Choiceclass;
import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.bean.User;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.model.ShowStudentModel;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowStudentAction extends ActionSupport{

	private String classId;
	private Classes classes;
	private MessageModel messageModel;
	private int cId;
	private ClassesService classesService;
	private UserService userService;
	private ChoiceclassService choiceclassService;
	private List<ShowStudentModel>list;
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
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

	public ChoiceclassService getChoiceclassService() {
		return choiceclassService;
	}

	public void setChoiceclassService(ChoiceclassService choiceclassService) {
		this.choiceclassService = choiceclassService;
	}


	public List<ShowStudentModel> getList() {
		return list;
	}

	public void setList(List<ShowStudentModel> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		SecurityAction securityAction = new SecurityAction();
		messageModel = new MessageModel();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		try {
			cId = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "参数错误！", "classManager.action");
			return "message";
		}
		classes = classesService.getClassByClassId(cId);
		if (!classes.getUserId().equals(securityAction.getUserId())) {
			messageModel.setData("系统提示", "您无权操此页面", "classManager.action");
			return "message";
		}
		
		List<Choiceclass>tempList = choiceclassService.getByClassId(cId);
		list = new ArrayList<>();
		for (int i = 0; i < tempList.size(); i++) {
			Choiceclass tempChoiceclass = tempList.get(i);
			User user = userService.getUserByUserId(tempChoiceclass.getUserId());
			ShowStudentModel showStudentModel = new ShowStudentModel(user,tempChoiceclass.getChoiceClassId());
			list.add(showStudentModel);
		}
		
		return SUCCESS;
	}
	
}
