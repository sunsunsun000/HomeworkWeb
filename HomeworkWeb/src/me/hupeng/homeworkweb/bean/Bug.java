package me.hupeng.homeworkweb.bean;

/**
 * Bug entity. @author MyEclipse Persistence Tools
 */

public class Bug implements java.io.Serializable {

	// Fields

	private Integer bugId;
	private String time;
	private Integer userId;
	private String email;
	private String text;
	private Integer status;

	// Constructors

	/** default constructor */
	public Bug() {
	}

	/** full constructor */
	public Bug(String time, Integer userId, String email, String text,
			Integer status) {
		this.time = time;
		this.userId = userId;
		this.email = email;
		this.text = text;
		this.status = status;
	}

	// Property accessors

	public Integer getBugId() {
		return this.bugId;
	}

	public void setBugId(Integer bugId) {
		this.bugId = bugId;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}