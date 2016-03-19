package me.hupeng.homeworkweb.bean;

/**
 * Homework entity. @author MyEclipse Persistence Tools
 */

public class Homework implements java.io.Serializable {

	// Fields

	private Integer homeworkId;
	private Integer userId;
	private String submitTime;
	private Integer taskId;
	private String path;
	private String grade;

	// Constructors

	/** default constructor */
	public Homework() {
	}

	/** full constructor */
	public Homework(Integer userId, String submitTime, Integer taskId,
			String path, String grade) {
		this.userId = userId;
		this.submitTime = submitTime;
		this.taskId = taskId;
		this.path = path;
		this.grade = grade;
	}

	// Property accessors

	public Integer getHomeworkId() {
		return this.homeworkId;
	}

	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}