package me.hupeng.homeworkweb.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;

import me.hupeng.homeworkweb.DAO.ChoiceclassDAO;
import me.hupeng.homeworkweb.bean.Choiceclass;
import me.hupeng.homeworkweb.model.ChoiceClassModel;

public class ChoiceclassService {
	private ChoiceclassDAO choiceclassDAO;
	public ChoiceclassDAO getChoiceclassDAO() {
		return choiceclassDAO;
	}

	public void setChoiceclassDAO(ChoiceclassDAO choiceclassDAO) {
		this.choiceclassDAO = choiceclassDAO;
	}

	public int add(Integer classId,Integer userId){
		if (classId == null || userId == null) {
			return 101;
		}
		Choiceclass choiceclass =  new Choiceclass();
		choiceclass.setClassId(classId);
		choiceclass.setUserId(userId);
		if (!choiceclassDAO.findByExample(choiceclass).isEmpty()) {
			return 0;
		}else {
			choiceclassDAO.save(choiceclass);
		}
		return 0;
	}
	
	public Choiceclass getChoiceclassById(Integer id){
		return choiceclassDAO.findById(id);
	}
	
	public List<Choiceclass>getListByUserId(Integer userId){
		return choiceclassDAO.findByUserId(userId);
	}
	
	public int deleteChoiceClass(Integer userId,Integer choiceClassId){
		Choiceclass choiceclass = new Choiceclass();
		choiceclass = choiceclassDAO.findById(choiceClassId);
		if (choiceclass == null) {
			return 110;
		}
		if (!choiceclass.getUserId().equals(userId) ) {
			return 110;
		}
		choiceclassDAO.delete(choiceclass);
		return 0;
	}
	
	public void deleteByClassId(Integer classId){
		List<Choiceclass> list = choiceclassDAO.findByClassId(classId);
		for (int i = 0; i < list.size(); i++) {
			choiceclassDAO.delete(list.get(i));
		}
	}
	
	public List<Choiceclass> getByClassId(int classId){
		List<Choiceclass>list = choiceclassDAO.findByClassId(classId);
		return list;
	}
	
	public void deleteChoiceClass(int choiceClassId){
		Choiceclass choiceclass = new Choiceclass();
		choiceclass = choiceclassDAO.findById(choiceClassId);
		if (choiceclass == null) {
			return;
		}
		choiceclassDAO.delete(choiceclass);
	}
	
	public void deleteByClassId(int classId){
		List<Choiceclass>list = choiceclassDAO.findByClassId(classId);
		for (int i = 0; i < list.size(); i++) {
			choiceclassDAO.delete(list.get(i));
		}
	}
	
	public List<Choiceclass>getListByClassId(int classId){
		return choiceclassDAO.findByClassId(classId);
	}
}