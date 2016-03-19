package me.hupeng.homeworkweb.service;

import java.util.List;

import me.hupeng.homeworkweb.DAO.ClassnameDAO;
import me.hupeng.homeworkweb.bean.Classname;

public class ClassnameService {
	private ClassnameDAO classnameDAO;

	public ClassnameDAO getClassnameDAO() {
		return classnameDAO;
	}

	public void setClassnameDAO(ClassnameDAO classnameDAO) {
		this.classnameDAO = classnameDAO;
	}
	
	public List<Classname> getListByKeyword(String keyword){
		return classnameDAO.findByKeyWord(keyword);
	}
	
	public String getNameStringbyId(Integer id){
		return classnameDAO.findById(id).getName();
	}
}
