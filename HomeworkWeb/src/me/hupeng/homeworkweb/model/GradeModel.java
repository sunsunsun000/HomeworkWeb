package me.hupeng.homeworkweb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.ui.context.Theme;

import me.hupeng.homeworkweb.bean.Homework;
import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.HomeworkService;
import me.hupeng.homeworkweb.service.TaskService;

public class GradeModel {
	private String grade;
	private String className;
	private String taskName;
	private String time;
	private Integer num;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
	public GradeModel(){
//		if (homeworkService == null) {
//			System.out.println("the homework is null");
//		}
//		Homework homework = homeworkService.getHomeworkById(homeworkId);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		time = sdf.format(new Date(Long.parseLong(homework.getTime())));
//		grade = homework.getGrade();
//		Task task = taskService.getTaskById(taskId);
//		taskName = task.getTaskName();
//		className = classesService.getClassByClassId(task.getClassId()).getClassName();
//		this.num = nmu;
	}
	
}
