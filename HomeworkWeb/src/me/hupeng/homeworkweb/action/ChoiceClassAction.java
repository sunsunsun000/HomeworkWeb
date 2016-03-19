package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import me.hupeng.homeworkweb.bean.Choiceclass;
import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.model.ChoiceClassModel;
import me.hupeng.homeworkweb.model.ClassModel;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.ClassesService;
import me.hupeng.homeworkweb.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ChoiceClassAction extends ActionSupport{
	private UserService userService;
	private ChoiceclassService choiceclassService;
	private ClassesService classesService;
	List<ChoiceClassModel>list;
	private Integer size;
	private String keyword;
	private List<ClassModel>classModelList;
	private boolean flag;
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

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public List<ChoiceClassModel> getList() {
		return list;
	}

	public void setList(List<ChoiceClassModel> list) {
		this.list = list;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<ClassModel> getClassModelList() {
		return classModelList;
	}

	public void setClassModelList(List<ClassModel> classModelList) {
		this.classModelList = classModelList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		flag = true;
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkUser()) {
			return LOGIN;
		}
		Integer userId = securityAction.getUserId();
		list = new ArrayList<>();
		if (securityAction.getType() == 1) {
			List<Choiceclass>oldList = choiceclassService.getListByUserId(userId);
			
			//±éÀúoldList,²úÉúnewList
			for (int i = 0; i < oldList.size(); i++) {
				ChoiceClassModel choiceClassModel = new ChoiceClassModel();
				choiceClassModel.setClassName(classesService.getClassByClassId(oldList.get(i).getClassId()).getClassName());
				choiceClassModel.setDeleteUrl("window.location.href='deleteChoiceClass.action?choiceClassId=" + oldList.get(i).getChoiceClassId()+"'");
				choiceClassModel.setUrl("classInfo.action?classId=" + oldList.get(i).getClassId());
				list.add(choiceClassModel);
			}
			
		}
		size = list.size();
		if (keyword != null) {
			classModelList = new ArrayList<>();
			List<Classes>oldList2 = classesService.getClassesByKeyWord(keyword);
			for (int i = 0; i < oldList2.size(); i++) {
				ClassModel classModel = new ClassModel();
				classModel.setClassName(oldList2.get(i).getClassName());
				classModel.setUrl("addChoiceClass.action?classId=" + oldList2.get(i).getClassId());
				classModelList.add(classModel);
			}
			if (classModelList.isEmpty()) {
				flag = false;
			}
		}
		return SUCCESS;
	}
	
}
