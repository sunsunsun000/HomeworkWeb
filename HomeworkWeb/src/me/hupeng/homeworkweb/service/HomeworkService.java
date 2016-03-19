package me.hupeng.homeworkweb.service;

import java.util.ArrayList;
import java.util.List;

import me.hupeng.homeworkweb.DAO.HomeworkDAO;
import me.hupeng.homeworkweb.bean.Homework;
import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.GradeModel;

public class HomeworkService {
	private HomeworkDAO homeworkDAO;
	private GradeModel gradeModel;
	
	public GradeModel getGradeModel() {
		return gradeModel;
	}

	public void setGradeModel(GradeModel gradeModel) {
		this.gradeModel = gradeModel;
	}

	public HomeworkDAO getHomeworkDAO() {
		return homeworkDAO;
	}

	public void setHomeworkDAO(HomeworkDAO homeworkDAO) {
		this.homeworkDAO = homeworkDAO;
	}
	
	public void add(Integer userId,Integer taskId ,String path){
		Homework homework = new Homework();
		homework.setTaskId(taskId);
		homework.setUserId(userId);
		if (!homeworkDAO.findByExample(homework).isEmpty()) {
			homework = (Homework)homeworkDAO.findByExample(homework).get(0);
		}
		homework.setSubmitTime(System.currentTimeMillis()+"");
		homework.setPath(path);
		homeworkDAO.save(homework);
	}
	
	public void setGrade(Integer homeworkId, String grade){
		Homework homework = homeworkDAO.findById(homeworkId);
		if (homework == null) {
			return;
		}
		homework.setGrade(grade);
		homeworkDAO.save(homework);
	}
	
	public Homework getHomeworkById(Integer id){
		return homeworkDAO.findById(id);
	}
	
	public boolean checkHomeworkId(Integer id){
		if (homeworkDAO.findById(id) == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public List<Homework>gethHomeworkList(Integer userId){
		List<Homework>oldList = homeworkDAO.findByUserId(userId);
		return oldList;
	}
	
	public List<Homework>getHomeworkByTaskId(Integer taskId){
		List<Homework> list = homeworkDAO.findByTaskId(taskId);
		return list;
	}
}
