package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.ClassesService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改班级公告*/
public class ChangeNoticeAction extends ActionSupport{
	private String notice;
	private String classId;
	private ClassesService classesService;
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//验证用户什么为教师或管理员
		Integer classIdInteger;
		MessageModel messageModel = new MessageModel();
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			messageModel.setData("系统提示", "用户身份验证失败", "logout.action");
			return "message";
		}
		//验证参数的合法性
		if (notice == null || classId == null) {
			messageModel.setData("系统提示", "参数不合法", "logout.action");
			return "message";
		}
		try {
			classIdInteger = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "参数不合法", "logout.action");
			return "message";
		}
		Classes classes = classesService.getClassByClassId(classIdInteger);
		if (classes == null) {
			messageModel.setData("系统提示", "参数不合法", "logout.action");
			return "message";
		}
		if (securityAction.getType() == 0 || classes.getUserId() == securityAction.getUserId()) {
			classesService.changeNotice(classes.getClassId(), notice);
		}
		return SUCCESS;
	}
	
}
