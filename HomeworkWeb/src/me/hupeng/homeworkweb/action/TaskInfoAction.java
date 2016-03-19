package me.hupeng.homeworkweb.action;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.model.TaskInfoModel;
import me.hupeng.homeworkweb.service.TaskService;

import com.opensymphony.xwork2.ActionSupport;

public class TaskInfoAction extends ActionSupport{

	private String taskId;
	private TaskService taskService;
	private TaskInfoModel taskInfoModel;
	private MessageModel messageModel;
	private boolean adminFlag;
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public TaskInfoModel getTaskInfoModel() {
		return taskInfoModel;
	}

	public void setTaskInfoModel(TaskInfoModel taskInfoModel) {
		this.taskInfoModel = taskInfoModel;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkUser()) {
			return LOGIN;
		}
		Integer taskIdInteger = null;
		try {
			taskIdInteger = Integer.parseInt(taskId);
			taskInfoModel =new TaskInfoModel(taskService.getTaskById(taskIdInteger));
		} catch (Exception e) {
			// TODO: handle exception
			messageModel = new MessageModel();
			messageModel.setText("操作非法，您的IP地址" + ServletActionContext.getRequest().getRemoteAddr()+"已被系统记录");
			messageModel.setTitle("提示：");
			messageModel.setUrl("classInfo.action");
			return "message";
		}
		if (securityAction.getType() == 0 || taskService.getTaskById(taskIdInteger).getUserId().equals(securityAction.getUserId())) {
			adminFlag = true;
		}else {
			adminFlag = false;
		}
		return SUCCESS;
	}
}
