package me.hupeng.homeworkweb.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Id;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.TaskService;

import com.opensymphony.xwork2.ActionSupport;

public class AddTaskAction extends ActionSupport{
	
	private TaskService taskService;
	private String taskName;
	private String description;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String classId;
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String execute() throws Exception {
//		System.out.println(taskName);
//		System.out.println(description);
//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(day);
//		System.out.println(hour);
//		System.out.println(classId);
		// TODO Auto-generated method stub
		//验证用户身份
		SecurityAction securityAction = new SecurityAction();
		MessageModel messageModel = new MessageModel();
		if (!securityAction.checkTeacher()) {
//			messageModel.setData("系统提示", "用户权限验证失败", "logout.action");
//			return "message";
			ServletActionContext.getResponse().setStatus(500);
		}
		//验证数据
		if (!checkData(taskName, description,classId)) {
//			messageModel.setData("系统提示", "参数非法", "classInfo.action");
//			return "message";
			ServletActionContext.getResponse().setStatus(500);
		}
		long endtime = getTime(year, month, day, hour, 0+"", 0+"");
		if (endtime == 0) {
//			messageModel.setData("系统提示", "输入的时间参数非法", "classInfo.action");
//			return "message";
			ServletActionContext.getResponse().setStatus(500);
		}
		taskService.add(taskName, description, endtime+"", securityAction.getUserId(), Integer.parseInt(classId));
//		messageModel.setData("系统提示", "作业添加成功", "classInfo.action");
//		return "message";
		return SUCCESS;
	}
	
	private boolean checkData(String taskName,String description,String classId){
		if (taskName == null || description == null || taskName.equals("") || classId == null || classId.equals("")) {
			return false;
		}
		Integer classIdInteger;
		try {
			classIdInteger = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	private long getTime(String year,String month,String day,String hour,String minute,String second){
		int y;
		int mon;
		int d;
		int h;
		int min;
		int s;
		try {
			y = Integer.parseInt(year);
			mon = Integer.parseInt(month);
			d = Integer.parseInt(day);
			h = Integer.parseInt(hour);
			min = Integer.parseInt(minute);
			s = Integer.parseInt(second);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		//判断字符的合法性
		if (y < 2015 || y > 2030) {
			return 0;
		}
		if (mon < 1 || mon > 12) {
			return 0;
		}
		if (d < 1 || d > getDaysOfMonth(y, mon)) {
			return 0;
		}
		if (h > 23 || h < 0) {
			return 0;
		}
		if (min > 59 || min < 0) {
			return 0;
		}
		if (s > 59 || s < 0) {
			return 0;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		String dateString=year+":"+month+":"+day+":"+hour+":"+minute+":"+second;
		try {
			Date date=format.parse(dateString);
			return date.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	private int getDaysOfMonth(int y,int mon){
		switch (mon) {
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
			if (checkYear(y)) {
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
