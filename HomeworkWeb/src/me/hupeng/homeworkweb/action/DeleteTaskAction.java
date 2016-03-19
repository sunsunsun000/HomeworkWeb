package me.hupeng.homeworkweb.action;

import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.TaskService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteTaskAction extends ActionSupport{
	private TaskService taskService;
	private MessageModel messageModel;
	private String taskId;
	private Integer taskIdInteger;
	private String classId;
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		messageModel = new MessageModel();
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		//验证此用户是否有权限删除
		try {
			taskIdInteger = Integer.parseInt(taskId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "参数非法", "home.action");
			return "message";
		}
		Task task = taskService.getTaskById(taskIdInteger);
		if (task != null && (task.getUserId().equals(securityAction.getUserId()) || securityAction.getType() == 0)) {
			taskService.deleteByTaskId(taskIdInteger);
			classId = task.getClassId()+"";
		}
		return SUCCESS;
	}
}
