package me.hupeng.homeworkweb.service;

import java.util.List;

import me.hupeng.homeworkweb.DAO.CoursewareDAO;
import me.hupeng.homeworkweb.bean.Courseware;

public class CoursewareService {
	private CoursewareDAO coursewareDAO;
	private Courseware courseware;
	public CoursewareDAO getCoursewareDAO() {
		return coursewareDAO;
	}
	public void setCoursewareDAO(CoursewareDAO coursewareDAO) {
		this.coursewareDAO = coursewareDAO;
	}
	public Courseware getByCoursewareId(Integer id){
		return coursewareDAO.findById(id);
	}
	public List<Courseware> getCoursewareListByClassId(Integer classId){
		return coursewareDAO.findByClassId(classId);
	}
	
	public void add(String name,String path,int userId,int classId){
		courseware = new Courseware();
		courseware.setUserId(userId);
		courseware.setClassId(classId);
		courseware.setFilename(name);
		courseware.setPath(path);
		courseware.setUpdateTime(System.currentTimeMillis()+"");
		coursewareDAO.save(courseware);
	}
	
	public void delete(Integer id){
		courseware = coursewareDAO.findById(id);
		if (courseware != null) {
			coursewareDAO.delete(courseware);
		}
	}
}
