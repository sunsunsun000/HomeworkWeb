package me.hupeng.homeworkweb.action;

import java.io.FileInputStream;
import java.io.InputStream;

import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.HomeworkService;
import me.hupeng.homeworkweb.service.TaskService;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{
	private String filename;
	private MessageModel messageModel;
	private String homeworkId;
	private HomeworkService homeworkService;
	private TaskService taskService;
	private Integer homeworkIdInteger;
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public String getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}

	public HomeworkService getHomeworkService() {
		return homeworkService;
	}

	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public InputStream getTargetFile() throws Exception{
		String string  = homeworkService.getHomeworkById(homeworkIdInteger).getPath();
		filename = string.split("/")[string.split("/").length-1];
		return new FileInputStream(string);

	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		messageModel = new MessageModel();
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return "login";
		}
		//验证用户是否有下载文件的权限
		
		try {
			homeworkIdInteger = Integer.parseInt(homeworkId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "操作非法，你的ip：" + ServletActionContext.getRequest().getRemoteAddr() +"已被系统记录。", "classInfo.action");
			return "message";
		}
		Task task = null;
		try {
			task = taskService.getTaskById(homeworkService.getHomeworkById(homeworkIdInteger).getTaskId());
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "您无权下载此文件，你的ip：" + ServletActionContext.getRequest().getRemoteAddr() +"已被系统记录。", "classInfo.action");
			return "message";
		}
		
		if (securityAction.getType() == 0) {
			return SUCCESS;
		}
		if (task == null || !task.getUserId().equals(securityAction.getUserId())) {
			messageModel.setData("系统提示", "您无权下载此文件，你的ip：" + ServletActionContext.getRequest().getRemoteAddr() +"已被系统记录。", "classInfo.action");
			return "message";
		}
		return SUCCESS;
	}
	
}
