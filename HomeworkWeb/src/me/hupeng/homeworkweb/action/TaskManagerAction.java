package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.usertype.UserType;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.model.TaskManagerModel;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.TaskService;

import com.opensymphony.xwork2.ActionSupport;

public class TaskManagerAction extends ActionSupport{
	private String classId;
	private TaskService taskService;
	private MessageModel messageModel;
	private Integer classIdInteger;
	private List<TaskManagerModel>list;
	private ClassesService classesService;
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

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

	public List<TaskManagerModel> getList() {
		return list;
	}

	public void setList(List<TaskManagerModel> list) {
		this.list = list;
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
		messageModel = new MessageModel();
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		try {
			classIdInteger = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "操作非法：你的IP地址：" + ServletActionContext.getRequest().getRemoteAddr() + "已经被系统记录", "home.action");
			return "message";
		}
		Classes classes = classesService.getClassByClassId(classIdInteger);
		if (!(securityAction.getType() == 0 || classes.getUserId().equals(securityAction.getUserId()))) {
			messageModel.setData("系统提示", "你无权查看此页面", "home.action");
			return "message";
		}
		List<Task> tempList = taskService.getListbyClassId(classIdInteger);
		list = new ArrayList<>();
		for (int i = 0; i < tempList.size(); i++) {
			TaskManagerModel taskManagerModel = new TaskManagerModel(tempList.get(i));
			list.add(taskManagerModel);
		}
		return SUCCESS;
	}
}
