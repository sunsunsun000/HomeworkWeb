package me.hupeng.homeworkweb.service;

import java.util.List;

import org.junit.Test;

import me.hupeng.homeworkweb.DAO.ClassesDAO;
import me.hupeng.homeworkweb.bean.Classes;
import me.hupeng.homeworkweb.model.ClassModel;
import me.hupeng.homeworkweb.model.UserModel;

public class ClassesService {
	private ClassesDAO classesDAO;

	public ClassesDAO getClassesDAO() {
		return classesDAO;
	}

	public void setClassesDAO(ClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}
	
	public int add(String className,String notice, Integer userId){
		if (className == null || notice == null || userId == null) {
			return 101;
		}
		if (className.contains("<")) {
			return 101;
		}
		if (className.equals("")) {
			return 108;
		}
		if (className.contains("<") || notice.contains("<")) {
			return 108;
		}
		Classes classes = new Classes();
		classes.setClassName(className);
		classes.setNotice(notice);
		classes.setUserId(userId);
		classesDAO.save(classes);
		return 0;
	}
	
	public List<Classes>getClassesByUserId(Integer userId){
		return classesDAO.findByUserId(userId);
	}
	
	public Classes getClassByClassId(Integer classId){
		return classesDAO.findById(classId);
	}
	
	public List getClassesByKeyWord(String keyword){
		return classesDAO.findByKeyWord(keyword);
	}
	
	
	public void changeNotice(Integer classId,String notice){
		Classes classes = classesDAO.findById(classId);
		if (classes == null) {
			return;
		}
		classes.setNotice(notice);
		classesDAO.save(classes);
	}
	
	public void deleteById(Integer id){
		Classes classes = classesDAO.findById(id);
		if (classes !=  null) {
			classesDAO.delete(classes);
		}
	}
	
}
