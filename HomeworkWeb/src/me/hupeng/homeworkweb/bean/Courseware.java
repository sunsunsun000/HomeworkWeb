package me.hupeng.homeworkweb.bean;

/**
 * Courseware entity. @author MyEclipse Persistence Tools
 */

public class Courseware implements java.io.Serializable {

	// Fields

	private Integer coursewareId;
	private Integer classId;
	private Integer userId;
	private String path;
	private String filename;
	private String updateTime;

	// Constructors

	/** default constructor */
	public Courseware() {
	}

	/** full constructor */
	public Courseware(Integer classId, Integer userId, String path,
			String filename, String updateTime) {
		this.classId = classId;
		this.userId = userId;
		this.path = path;
		this.filename = filename;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getCoursewareId() {
		return this.coursewareId;
	}

	public void setCoursewareId(Integer coursewareId) {
		this.coursewareId = coursewareId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}