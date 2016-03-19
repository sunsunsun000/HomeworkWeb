package me.hupeng.homeworkweb.service;

import java.util.List;

import me.hupeng.homeworkweb.DAO.BugDAO;
import me.hupeng.homeworkweb.bean.Bug;

public class BugService {
	private BugDAO bugDAO;

	public BugDAO getBugDAO() {
		return bugDAO;
	}

	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	
	public int add(Integer userId,String email,String text){
		if (email == null || text == null) {
			return 108;
		}
		if (email.equals("") || text.equals("")) {
			return 109;
		}
		Bug bug = new Bug();
		bug.setEmail(email);
		bug.setText(text);
		bug.setUserId(userId);
		bug.setStatus(0);
		bug.setTime(System.currentTimeMillis()+"");
		bugDAO.save(bug);
		return 0;
	}
	
	public List<Bug> getAllBug(){
		return bugDAO.findAll();
	}
	
	public List<Bug> getBugByStatus(Integer status){
		return bugDAO.findByStatus(status);
	}
}
