package me.hupeng.homeworkweb.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.ChangeTaskModel;
import me.hupeng.homeworkweb.service.TaskService;

import com.opensymphony.xwork2.ActionSupport;


public class ChangeTaskInfoAction extends ActionSupport{
	private String taskId;
	private ChangeTaskModel changeTaskModel;
	private TaskService taskService;
	public ChangeTaskModel getChangeTaskModel() {
		return changeTaskModel;
	}

	public void setChangeTaskModel(ChangeTaskModel changeTaskModel) {
		this.changeTaskModel = changeTaskModel;
	}

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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(changeTaskModel.getName());
//		System.out.println(changeTaskModel.getDescription());
//		System.out.println(changeTaskModel.getYear());
//		System.out.println(changeTaskModel.getMonth());
//		System.out.println(changeTaskModel.getDay());
//		System.out.println(changeTaskModel.getHour());
		long endTime = checkData() ;
		if (endTime == 0) {
			ServletActionContext.getResponse().setStatus(500);
		}else {
			int taskIdInt = Integer.parseInt(taskId);
			Task task = taskService.getTaskById(taskIdInt);
			task.setTaskName(changeTaskModel.getName());
			task.setDescription(changeTaskModel.getDescription());
			task.setEndTime(endTime + "");
			taskService.saveTask(task);
		}
		return SUCCESS;
	}
	private long checkData(){
		Integer taskIdInteger;
		try {
			taskIdInteger = Integer.parseInt(taskId);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		int year;
		int month;
		int day;
		int hour;
		try {
			year = Integer.parseInt(changeTaskModel.getYear());
			month = Integer.parseInt(changeTaskModel.getMonth());
			day = Integer.parseInt(changeTaskModel.getDay());
			hour = Integer.parseInt(changeTaskModel.getHour());
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		if (year > 2025 || year < 2015 || month < 1 || month >12 || day < 1 || day > getMonthDays(year, month) || hour > 23 || hour < 0) {
			return 0;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		String dateString=year+":"+month+":"+day+":"+hour+":"+0+":"+0;
		try {
			Date date=format.parse(dateString);
			return date.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	private int getMonthDays(int year, int month){
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (checkYear(year)) {
				return 29;
			}else {
				return 28;
			}
		default:
			break;
		}
		return 0;
	}
	
	private boolean checkYear(int year){
		if (year%400==0) {
			return true;
		}
		if (year%4==0&&year%100!=0) {
			return true;
		}
		return false;
	}
}
