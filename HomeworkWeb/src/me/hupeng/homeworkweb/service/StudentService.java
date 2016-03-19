package me.hupeng.homeworkweb.service;

import java.util.List;

import me.hupeng.homeworkweb.DAO.StudentDAO;
import me.hupeng.homeworkweb.bean.Student;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public List<Student> getStudentsByClassName(String className){
		return studentDAO.findByClassName(className);
	}
	
	public boolean addStudent(String name,String num){
		Student student = new Student();
		student.setName(name);
		student.setNum(num);
		if (studentDAO.findByNum(num).size()!=0) {
			return false;
		}
		studentDAO.save(student);
		return true;
	}
	
	public void addStudent(String name,String num,String classname){
		Student student = new Student();
		student.setName(name);
		student.setNum(num);
		student.setClassName(classname);
		if (studentDAO.findByNum(num).size()!=0) {
			return;
		}
		studentDAO.save(student);
	}
}
