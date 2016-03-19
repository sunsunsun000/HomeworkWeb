package me.hupeng.homeworkweb.bean;

/**
 * Choiceclass entity. @author MyEclipse Persistence Tools
 */

public class Choiceclass implements java.io.Serializable {

	// Fields

	private Integer choiceClassId;
	private Integer userId;
	private Integer classId;

	// Constructors

	/** default constructor */
	public Choiceclass() {
	}

	/** full constructor */
	public Choiceclass(Integer userId, Integer classId) {
		this.userId = userId;
		this.classId = classId;
	}

	// Property accessors

	public Integer getChoiceClassId() {
		return this.choiceClassId;
	}

	public void setChoiceClassId(Integer choiceClassId) {
		this.choiceClassId = choiceClassId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

}