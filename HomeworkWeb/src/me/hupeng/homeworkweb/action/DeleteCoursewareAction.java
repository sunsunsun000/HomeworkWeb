package me.hupeng.homeworkweb.action;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.Courseware;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.CoursewareService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCoursewareAction extends ActionSupport{
	private String cid;
	private String classId;
	private Integer coursewareId;
	private MessageModel messageModel;
	private CoursewareService coursewareService;
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public CoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setCoursewareService(CoursewareService coursewareService) {
		this.coursewareService = coursewareService;
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
		try {
			coursewareId = Integer.parseInt(cid);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "操作非法，你的IP地址:" + ServletActionContext.getRequest().getRemoteAddr()+"已被系统记录", "home.action");
			return "message";
		}
		Courseware courseware = coursewareService.getByCoursewareId(coursewareId);
		
		if ((securityAction.getType() == 0) ||( courseware != null && courseware.getUserId().equals(securityAction.getUserId()))) {
			classId = courseware.getClassId() + "";
			coursewareService.delete(coursewareId);
		}else {
			messageModel.setData("系统提示", "操作非法，你的IP地址:" + ServletActionContext.getRequest().getRemoteAddr()+"已被系统记录", "home.action");
			return "message";
		}
		return SUCCESS;
	}
}
