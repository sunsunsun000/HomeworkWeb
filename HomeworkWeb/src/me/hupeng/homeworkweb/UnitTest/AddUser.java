package me.hupeng.homeworkweb.UnitTest;

import java.util.List;

import me.hupeng.homeworkweb.DAO.StudentDAO;
import me.hupeng.homeworkweb.DAO.UserDAO;
import me.hupeng.homeworkweb.bean.Student;
import me.hupeng.homeworkweb.bean.User;
import me.hupeng.homeworkweb.util.MD5;

import org.junit.Test;


public class AddUser {
	private StudentDAO studentDAO;
	private UserDAO userDAO;
	@Test
	public void addUser(){
//		studentDAO = new StudentDAO();
//		userDAO = new UserDAO();
//		List<Student>list = studentDAO.findAll();
//		for (int i = 0; i < list.size(); i++) {
//			User user = new User();
//			user.setUsername(list.get(i).getNum());
//			user.setStuNum(list.get(i).getName());
//			user.setType(1);
//			user.setPassword(new MD5().encryptPassword(list.get(i).getNum()));
//			userDAO.save(user);
//		}
	}
}
