package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.bean.Classname;
import me.hupeng.homeworkweb.bean.Student;
import me.hupeng.homeworkweb.bean.User;
import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.ClassnameService;
import me.hupeng.homeworkweb.service.StudentService;
import me.hupeng.homeworkweb.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class AddGroupAction extends ActionSupport{
	private String classId;
	private int cId;
	private MessageModel messageModel;
	private ClassesService classesService;
	private String keyword;
	private List<Classname>list;
	private ClassnameService classnameService;
	private String classnameId;
	private StudentService studentService;
	private UserService userService;
	private ChoiceclassService choiceclassService;
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public MessageModel getMessageModel() {
		return messageModel;
	}
	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public ClassesService getClassesService() {
		return classesService;
	}
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Classname> getList() {
		return list;
	}
	public void setList(List<Classname> list) {
		this.list = list;
	}
	public ClassnameService getClassnameService() {
		return classnameService;
	}
	public void setClassnameService(ClassnameService classnameService) {
		this.classnameService = classnameService;
	}

	public String getClassnameId() {
		return classnameId;
	}
	public void setClassnameId(String classnameId) {
		this.classnameId = classnameId;
	}

	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		SecurityAction securityAction = new SecurityAction();
		messageModel = new MessageModel();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		try {
			cId = Integer.parseInt(classId);
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setData("系统提示", "参数非法", "classManager.action");
			return "message";
		}
		Classes classes = classesService.getClassByClassId(cId);
		if (!classes.getUserId().equals(securityAction.getUserId())) {
			messageModel.setData("系统提示", "参数错误", "classManager.action");
			return "message";
		}
		
		if (keyword != null) {
			list = classnameService.getListByKeyword(keyword);
			//System.out.println(list.size());
		}
		
		if (classnameId != null) {
			int cnId = 0;
			String classname;
			try {
				cnId = Integer.parseInt(classnameId);
			} catch (Exception e) {
				// TODO: handle exception
				messageModel.setData("系统提示", "参数错误", "classManager.action");
				return "message";
			}
			//将对应的学生添加入对应的班级
			classname = classnameService.getNameStringbyId(cnId);
			List<Student>students = studentService.getStudentsByClassName(classname);
			for(int i=0;i<students.size();i++){
				Student student = students.get(i);
				choiceclassService.add(cId, userService.getUserByUsername(student.getNum()).getUserId());
			}
			return "back";
		}
		return SUCCESS;
	}
}
