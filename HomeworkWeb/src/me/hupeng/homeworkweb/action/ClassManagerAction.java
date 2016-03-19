package me.hupeng.homeworkweb.action;

import java.util.ArrayList;
import java.util.List;

import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.model.ClassManagerModel;
import me.hupeng.homeworkweb.service.ChoiceclassService;
import me.hupeng.homeworkweb.service.ClassesService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassManagerAction extends ActionSupport{
	private ClassesService classesService;
	private ChoiceclassService choiceclassService;
	private List<ClassManagerModel>list;
	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public ChoiceclassService getChoiceclassService() {
		return choiceclassService;
	}

	public void setChoiceclassService(ChoiceclassService choiceclassService) {
		this.choiceclassService = choiceclassService;
	}

	public List<ClassManagerModel> getList() {
		return list;
	}

	public void setList(List<ClassManagerModel> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkTeacher()) {
			return LOGIN;
		}
		List<Classes> tempList = classesService.getClassesByUserId(securityAction.getUserId());
		list = new ArrayList<>();
		for (int i = 0; i < tempList.size(); i++) {
			ClassManagerModel classManagerModel = new ClassManagerModel(tempList.get(i));
			list.add(classManagerModel);
		}
		return SUCCESS;
	}
	
}
