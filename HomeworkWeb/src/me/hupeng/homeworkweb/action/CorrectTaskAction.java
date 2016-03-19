package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import me.hupeng.homeworkweb.bean.Choiceclass;
import me.hupeng.homeworkweb.bean.Homework;
import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.bean.User;
import me.hupeng.homeworkweb.model.CorrectModel;
import me.hupeng.homeworkweb.model.GradeModel;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.HomeworkService;
import me.hupeng.homeworkweb.service.TaskService;
import me.hupeng.homeworkweb.service.UserService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CorrectTaskAction extends ActionSupport{
	private String taskId;
	private Integer taskIdInteger;
	private MessageModel messageModel;
	private TaskService taskService;
	private HomeworkService homeworkService;
	private List<CorrectModel> list;
	private UserService userService;
	private String grade;
	private String homeworkId;
	private ChoiceclassService choiceclassService;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public MessageModel getMessageModel() {
		return messageModel;
	}
	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public TaskService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public HomeworkService getHomeworkService() {
		return homeworkService;
	}
	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	public List<CorrectModel> getList() {
		return list;
	}
	public void setList(List<CorrectModel> list) {
		this.list = list;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
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
		//判断方法为POST还是GET
		messageModel = new MessageModel();
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		if (ServletActionContext.getRequest().getMethod().equals("GET")) {
			try {
				taskIdInteger = Integer.parseInt(taskId);
			} catch (Exception e) {
				// TODO: handle exception
				messageModel.setData("系统提示", "操作非法，你的ip：" + ServletActionContext.getRequest().getRemoteAddr() +"已被系统记录。", "classInfo.action");
				return "message";
			}
			//验证用户是否有权查看此页面
			if (securityAction.getType() !=0 && !taskService.CheckTaskByTaskIdAndUserId(taskIdInteger, securityAction.getUserId())) {
				messageModel.setData("系统提示", "您无权查看此页面", "classInfo.action");
				return "message";
			}
			//获取列表
			List<Homework>homeworks = homeworkService.getHomeworkByTaskId(taskIdInteger);
			list = new ArrayList<>();
			int classId = taskService.getTaskById(taskIdInteger).getClassId();
			List<User>userList = new ArrayList<>();
			List<Choiceclass>choiceclasseList = choiceclassService.getListByClassId(classId);
			for (int i = 0; i < choiceclasseList.size(); i++) {
				User user = userService.getUserByUserId(choiceclasseList.get(i).getUserId());
				userList.add(user);
			}
			
			for (int i = 0; i < homeworks.size(); i++) {
				Homework homework = homeworks.get(i);
				User user = userService.getUserByUserId(homework.getUserId());
				userList.remove(user);
				CorrectModel correctModel = new CorrectModel(user, homework);
				list.add(correctModel);
			}
			
			for (int i = 0; i < userList.size(); i++) {
				CorrectModel correctModel = new CorrectModel(userList.get(i));
				list.add(correctModel);
			}
			
		}else {
			//System.out.println(grade);
			//System.out.println(homeworkId);
			Integer homeworkIdInteger = 0;
			try {
				homeworkIdInteger = Integer.parseInt(homeworkId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//判断用户是否有足够的权限来给出分数
			Task task = null;
			try {
				task = taskService.getTaskById(homeworkService.getHomeworkById(homeworkIdInteger).getTaskId());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (!(task == null || !task.getUserId().equals(securityAction.getUserId()))) {
				homeworkService.setGrade(homeworkIdInteger, grade);
			}
			return "blank";
		}
		return SUCCESS;
	}
}
