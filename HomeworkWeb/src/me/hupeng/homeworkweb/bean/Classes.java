package me.hupeng.homeworkweb.bean;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classId;
	private String className;
	private String notice;
	private Integer userId;

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(String className, String notice, Integer userId) {
		this.className = className;
		this.notice = notice;
		this.userId = userId;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}