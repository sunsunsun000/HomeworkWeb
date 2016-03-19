package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.ClassesService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteClassAction extends ActionSupport{
	private String classId;
	private ClassesService classesService;
	private ChoiceclassService choiceclassService;
	private Integer classIdInteger;
	private MessageModel messageModel;
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

	public ChoiceclassService getChoiceclassService() {
		return choiceclassService;
	}

	public void setChoiceclassService(ChoiceclassService choiceclassService) {
		this.choiceclassService = choiceclassService;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		messageModel = new MessageModel();
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		try {
			classIdInteger = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "参数错误", "home.action");
			return "message";
		}
		Classes classes = classesService.getClassByClassId(classIdInteger);
		if (securityAction.getType() == 0 || classes.getUserId().equals(securityAction.getUserId())) {
			classesService.deleteById(classIdInteger);
			choiceclassService.deleteByClassId(classIdInteger);
		}
		return SUCCESS;
	}
	
}
