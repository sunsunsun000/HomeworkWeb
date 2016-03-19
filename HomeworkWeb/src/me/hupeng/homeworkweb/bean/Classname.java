package me.hupeng.homeworkweb.bean;

/**
 * Classname entity. @author MyEclipse Persistence Tools
 */

public class Classname implements java.io.Serializable {

	// Fields

	private Integer classnameId;
	private String name;

	// Constructors

	/** default constructor */
	public Classname() {
	}

	/** full constructor */
	public Classname(String name) {
		this.name = name;
	}

	// Property accessors

	public Integer getClassnameId() {
		return this.classnameId;
	}

	public void setClassnameId(Integer classnameId) {
		this.classnameId = classnameId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}