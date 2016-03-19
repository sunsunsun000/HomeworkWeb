package me.hupeng.homeworkweb.action;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.ClassesService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 教师用户或者管理员用户添加班级
 * */
public class AddClassAction extends ActionSupport{
	private MessageModel messageModel;
	private String className;
	private String notice;
	private ClassesService classesService;
	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
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
		//判断用户身份，添加班级为教师账户拥有的权限
		SecurityAction securityAction = new SecurityAction();
		messageModel = new MessageModel();
		if (!(securityAction.checkAdmin() || securityAction.checkTeacher())) {
//			messageModel.setData("系统提示","用户校验失败","logout.action");
//			return "message";
			ServletActionContext.getResponse().setStatus(500);
		}
		if (className == null || notice == null) {
//			messageModel.setData("系统提示", "参数非法", "classInfo.action");
			ServletActionContext.getResponse().setStatus(500);
		}
		if (className.equals("")) {
//			messageModel.setData("系统提示", "班级名称不能为空", "classInfo.action");
			ServletActionContext.getResponse().setStatus(500);
		}
		classesService.add(className, notice, securityAction.getUserId());
//		messageModel.setData("系统提示", "班级添加成功！", "classInfo.action");
		return SUCCESS;
	}
}
