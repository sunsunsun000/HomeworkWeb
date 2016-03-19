package me.hupeng.homeworkweb.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.Homework;
import me.hupeng.homeworkweb.model.GradeModel;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.HomeworkService;
import me.hupeng.homeworkweb.service.TaskService;
import me.hupeng.homeworkweb.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowGradeAction extends ActionSupport{
	private UserService userService;
	private HomeworkService homeworkService;
	private TaskService taskService;
	private ClassesService classesService;
	private Integer size;
	private List<GradeModel>list;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<GradeModel> getList() {
		return list;
	}

	public void setList(List<GradeModel> list) {
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
		//验证身份--学生
		if (!new SecurityAction().checkStudent()) {
			return LOGIN;
		}
		//homeworkService.getHomeworkById(1);
		List<Homework> oldList = homeworkService.gethHomeworkList(new SecurityAction().getUserId());
		list = new ArrayList<GradeModel>();
		for(int i=0;i<oldList.size();i++){
			GradeModel gradeModel = new GradeModel();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = sdf.format(new Date( Long.parseLong( oldList.get(i).getSubmitTime() ) ));
			gradeModel.setTime(oldList.get(i).getSubmitTime());
			gradeModel.setTime(time);
			gradeModel.setGrade(oldList.get(i).getGrade());
			gradeModel.setTaskName(taskService.getTaskById(oldList.get(i).getTaskId()).getTaskName());
			gradeModel.setClassName(classesService.getClassByClassId(taskService.getTaskById(oldList.get(i).getTaskId()).getClassId()).getClassName());
			gradeModel.setNum(i+1);
			list.add(gradeModel);
		}
		size = list.size();
		ServletActionContext.getRequest().setAttribute("size", size);
		return SUCCESS;
	}
	
}
