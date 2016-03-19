package me.hupeng.homeworkweb.bean;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */

public class Task implements java.io.Serializable {

	// Fields

	private Integer taskId;
	private String taskName;
	private String description;
	private String endTime;
	private Integer userId;
	private Integer classId;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** full constructor */
	public Task(String taskName, String description, String endTime,
			Integer userId, Integer classId) {
		this.taskName = taskName;
		this.description = description;
		this.endTime = endTime;
		this.userId = userId;
		this.classId = classId;
	}

	// Property accessors

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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