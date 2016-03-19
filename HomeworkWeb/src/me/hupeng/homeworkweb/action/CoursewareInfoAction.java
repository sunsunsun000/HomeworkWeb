package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.bean.Courseware;
import me.hupeng.homeworkweb.model.CoursewareModel;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.CoursewareService;

import com.opensymphony.xwork2.ActionSupport;

public class CoursewareInfoAction extends ActionSupport{
	private String classId;
	private Integer classIdInteger;
	private CoursewareService coursewareService;
	private List<CoursewareModel>list;
	private ClassesService classesService;
	private MessageModel messageModel;
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public CoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setCoursewareService(CoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}

	public List<CoursewareModel> getList() {
		return list;
	}

	public void setList(List<CoursewareModel> list) {
		this.list = list;
	}

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		messageModel = new MessageModel();
		//验证用户身份
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		try {
			classIdInteger = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "参数非法，你的IP地址：" + ServletActionContext.getRequest().getRemoteAddr() + "已被系统记录", "home.action");
			return "message";
		}
		Classes  classes = classesService.getClassByClassId(classIdInteger);
		if (classes == null || !classes.getUserId().equals(securityAction.getUserId())) {
			messageModel.setData("系统提示", "您无权查看此页面", "home.action");
			return "message";
		}
		List<Courseware> tempList = coursewareService.getCoursewareListByClassId(classIdInteger);
		list = new ArrayList<>();
		for (int i = 0; i < tempList.size(); i++) {
			CoursewareModel coursewareModel = new CoursewareModel(tempList.get(i));
			list.add(coursewareModel);
		}
		return SUCCESS;
	}
}
