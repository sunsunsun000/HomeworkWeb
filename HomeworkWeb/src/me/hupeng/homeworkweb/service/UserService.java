package me.hupeng.homeworkweb.service;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import me.hupeng.homeworkweb.DAO.ClassnameDAO;
import me.hupeng.homeworkweb.DAO.UserDAO;
import me.hupeng.homeworkweb.bean.Classname;
import me.hupeng.homeworkweb.bean.User;
import me.hupeng.homeworkweb.util.JwxtUtil;
import me.hupeng.homeworkweb.util.MD5;

public class UserService {
	private UserDAO userDAO;
	private User user;
	private MD5 md5 = new MD5();
	private ClassnameDAO classnameDAO;
	private StudentService studentService;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public ClassnameDAO getClassnameDAO() {
		return classnameDAO;
	}

	public void setClassnameDAO(ClassnameDAO classnameDAO) {
		this.classnameDAO = classnameDAO;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public int login(String username,String password,String checkCode,String currentCheckCode,String ip){
		if (username == null || password == null || checkCode == null || currentCheckCode == null ) {
			return 101;
		}
		if (checkCode.equals("")) {
			return 102;
		}
		if (username.equals("") || password.equals("")) {
			return 103;
		}
		if (!checkCode.equals(currentCheckCode)) {
			return 104;
		}
		user = new User();
		user.setUsername(username);
		List<User>list = userDAO.findByExample(user);
		if (list.isEmpty()) {
			//此时用户名为空,通过教务系统类获取学生信息,获取成功后添加到用户数据当中
			JwxtUtil jwxtUtil = new JwxtUtil();
			try {
				jwxtUtil.setStuNum(username);
				JwxtUtil.StudentInfo studentInfo = jwxtUtil.getstudentInfo();
				if (studentInfo != null) {
					addStudent(username, studentInfo.getName());
					Classname classname = new Classname();
					classname.setName(studentInfo.getClassName());
					//如果班级名之前不存在，则在添加此班级第一个学生时添加此班级名称
					if (classnameDAO.findByExample(classname).size()==0) {
						classnameDAO.save(classname);
					}
					studentService.addStudent(studentInfo.getName(), username, studentInfo.getClassName());
					User instant = new User();
					instant.setUsername(username);
					list = userDAO.findByExample(instant);
					//list.get(0).setPassword(md5.encryptPassword(username));
				}else {
					return 105;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 105;
			}
			
		}
		user = list.get(0);
		if (!user.getPassword().equals(md5.encryptPassword(password))) {
			return 105;
		}
		this.user = list.get(0);
		this.user.setHashCode(md5.Md5(username+System.currentTimeMillis()));
		this.user.setIpAddress(ip);
		this.user.setLoginTime(System.currentTimeMillis()+"");
		userDAO.save(user);
		return 0;
	}
	

	public int registerStu(String username,String password,String rePassword,String stuNum,String checkCode,String currentCheckCode,String ip){
		if (username == null || password == null || rePassword == null || stuNum == null || checkCode == null || currentCheckCode == null) {
			return 101;
		}
		if (checkCode.equals("")) {
			return 102;
		}
		if (username.equals("") || password.equals("") || rePassword.equals("")) {
			return 103;
		}
		if (!checkCode.equals(currentCheckCode)) {
			return 104;
		}
		if (!password.equals(rePassword)) {
			return 106;
		}
		if (checkUsername(username)) {
			return 107;
		}
//		if (username.contains("<") || password.contains("<") || stuNum .contains("<")) {
//			return 108;
//		}
		user = new User();
		user.setUsername(username);
		user.setPassword(md5.encryptPassword(password));
		user.setType(1);
		user.setRegisterTime(System.currentTimeMillis()+"");
		user.setStuNum(stuNum);
		user.setHashCode(new MD5().Md5(username+System.currentTimeMillis()));
		user.setIpAddress(ip);
		user.setLoginTime(System.currentTimeMillis()+"");
		user.setClassId(0);
		userDAO.save(user);
		user = (User)userDAO.findByExample(user).get(0);
		return 0;
	}
	
	
	public int registerTeacher(String username,String password,String rePassword,String checkCode,String currentCheckCode,String ip){
		if (username == null || password == null || rePassword == null || checkCode == null || currentCheckCode == null) {
			return 101;
		}
		if (checkCode.equals("")) {
			return 102;
		}
		if (username.equals("") || password.equals("") || rePassword.equals("")) {
			return 103;
		}
		if (!checkCode.equals(currentCheckCode)) {
			return 104;
		}
		if (!password.equals(rePassword)) {
			return 106;
		}
		if (checkUsername(username)) {
			return 107;
		}
//		if (username.contains("<") || password.contains("<")) {
//			return 108;
//		}
		user = new User();
		user.setUsername(username);
		user.setPassword(md5.encryptPassword(password));
		user.setType(2);
		user.setRegisterTime(System.currentTimeMillis()+"");
		user.setHashCode(new MD5().Md5(username+System.currentTimeMillis()));
		user.setIpAddress(ip);
		user.setLoginTime(System.currentTimeMillis()+"");
		user.setClassId(0);
		userDAO.save(user);
		user = (User)userDAO.findByExample(user).get(0);
		return 0;
	}

	public User getUser(){
		return this.user;
	}

	public String getHashCode(int userId){
		User user = userDAO.findById(userId);
		if (user == null) {
			return null;
		}else {
			return user.getHashCode();
		}
	}
	

	private boolean checkUsername(String username){
		List<User> list = userDAO.findByUsername(username);
		if (list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public User getUserByUserId(Integer userId){
		return userDAO.findById(userId);
	}

	public void saveClassId(Integer userId,Integer classId){
		user = userDAO.findById(userId);
		if (user == null) {
			return;
		}
		user.setClassId(classId);
		userDAO.save(user);
	}
	
	public int changPassword(int userId,String oldPass,String newPass1,String newPass2){
		if (oldPass == null || newPass1 == null || newPass2 == null) {
			return 101;
		}
		if (oldPass.equals("") || newPass1.equals("") || newPass2.equals("")) {
			return 108;
		}
		if (!newPass1.equals(newPass2)) {
			return 106;
		}
		//判断oldPass是否正确
		User user = userDAO.findById(userId);
		if (!user.getPassword().equals(md5.encryptPassword(oldPass))) {
			return 111;
		}
		user.setPassword(md5.encryptPassword(newPass1));
		userDAO.save(user);
		return 0;
	}
	public User getUserByUsername(String username){
		if (username == null) {
			return null;
		}
		return (User)(userDAO.findByUsername(username).get(0));
	}
	
	public void addStudent(String num,String name){
		if (userDAO.findByUsername(num).size()!=0) {
			return;
		}
		user = new User();
		user.setUsername(num);
		user.setPassword(new MD5().encryptPassword(num));
		user.setType(1);
		user.setStuNum(name);
		userDAO.save(user);
	}
}
