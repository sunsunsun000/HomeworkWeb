package me.hupeng.homeworkweb.model;

import me.hupeng.homeworkweb.bean.User;

public class UserModel extends User{
	private int errorCode;
	private String errorInfo;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	public UserModel(int errorCode,String errorInfo){
		setErrorCode(errorCode);
		setErrorInfo(errorInfo);
	}
	public UserModel(User user){
		setUserId(user.getUserId());
		setUsername(user.getUsername());
		setPassword(user.getPassword());
		setType(user.getType());
		setClassId(user.getClassId());
		setStuNum(user.getStuNum());
		setRegisterTime(user.getRegisterTime());
		setHashCode(user.getHashCode());
		setIpAddress(user.getIpAddress());
		setLoginTime(user.getLoginTime());
	}
}
