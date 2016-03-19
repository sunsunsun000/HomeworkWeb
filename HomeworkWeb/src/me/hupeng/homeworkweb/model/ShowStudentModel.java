package me.hupeng.homeworkweb.model;

import me.hupeng.homeworkweb.bean.User;

public class ShowStudentModel {
	private int choiceClassId;
	private String name;//ÐÕÃû
	private String num;//Ñ§ºÅ
	public int getChoiceClassId() {
		return choiceClassId;
	}
	public void setChoiceClassId(int choiceClassId) {
		this.choiceClassId = choiceClassId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public void setData(User user,int choiceClassId){
		if (user == null) {
			return;
		}
		name = user.getStuNum();
		num = user.getUsername();
		this.choiceClassId = choiceClassId;
	}
	
	public ShowStudentModel(User user,int choiceClassId){
		setData(user, choiceClassId);
	}
	
	public ShowStudentModel(){
		
	}
}
