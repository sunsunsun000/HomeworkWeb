package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.bean.Courseware;
import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.ShowCoursewareModel;
import me.hupeng.homeworkweb.model.TaskModel;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.CoursewareService;
import me.hupeng.homeworkweb.service.TaskService;
import me.hupeng.homeworkweb.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassInfoAction extends ActionSupport{

	private ClassesService classesService;
	private UserService userService;
	private TaskService taskService;
	private Classes classes;
	private List<TaskModel> taskList;
	private List<ShowCoursewareModel>coursewareModelList;
	private String classId;
	private Boolean adminFlag;
	private CoursewareService coursewareService;
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

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public List<TaskModel> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<TaskModel> taskList) {
		this.taskList = taskList;
	}
	public TaskService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public Boolean getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(Boolean adminFlag) {
		this.adminFlag = adminFlag;
	}
	public CoursewareService getCoursewareService() {
		return coursewareService;
	}
	public void setCoursewareService(CoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}
	
	public List<ShowCoursewareModel> getCoursewareModelList() {
		return coursewareModelList;
	}
	public void setCoursewareModelList(List<ShowCoursewareModel> coursewareModelList) {
		this.coursewareModelList = coursewareModelList;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		SecurityAction securityAction = new SecurityAction();
		Integer classIdiInteger;
		if (securityAction.checkUser() == false) {
			return "login";
		}
		if (classId == null) {
			if (userService.getUserByUserId(securityAction.getUserId()).getClassId()== null || userService.getUserByUserId(securityAction.getUserId()).getClassId() == 0) {
				if(securityAction.getType() != 1){
					return "classManager";
				}else {
					return "choiceClass";
				}
				
			}
			classIdiInteger = userService.getUserByUserId(securityAction.getUserId()).getClassId();
			classes = classesService.getClassByClassId(userService.getUserByUserId(securityAction.getUserId()).getClassId());
		}else {
			classIdiInteger = Integer.parseInt(classId);
			classes = classesService.getClassByClassId(classIdiInteger);
		}
		if (classes == null) {
			if(securityAction.getType() != 1){
				return "classManager";
			}else {
				return "choiceClass";
			}
		}
		taskList = taskService.getModelListByClassId(classes.getClassId());
		userService.saveClassId(securityAction.getUserId(), classIdiInteger);
		
		if (classesService.getClassByClassId(classIdiInteger).getUserId().equals(securityAction.getUserId()) || securityAction.getType() == 0) {
			adminFlag = true;
		}else {
			adminFlag = false;
		}
		List<Courseware>tempCoursewares = coursewareService.getCoursewareListByClassId(classIdiInteger);
		coursewareModelList = new ArrayList<>();
		//遍历原来的list集合，产生新的list集合
		for (int i = 0; i < tempCoursewares.size(); i++) {
			ShowCoursewareModel showCoursewareModel = new ShowCoursewareModel(tempCoursewares.get(i));
			coursewareModelList.add(showCoursewareModel);
		}
		return SUCCESS;
	}	
}
