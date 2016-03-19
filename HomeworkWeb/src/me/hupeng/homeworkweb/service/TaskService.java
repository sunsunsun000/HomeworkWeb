package me.hupeng.homeworkweb.service;

import java.util.ArrayList;
import java.util.List;

import me.hupeng.homeworkweb.DAO.TaskDAO;
import me.hupeng.homeworkweb.bean.Task;
import me.hupeng.homeworkweb.model.TaskModel;

public class TaskService {
	private TaskDAO taskDAO;

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	
	public int add(String taskName,String description,String endTime,Integer userId,Integer classId){
		if(taskName == null || description == null || endTime == null || userId == null || classId == null){
			return 101;
		}
		if (taskName.contains("<")) {
			return 101;
		}
		Task task = new Task();
		task.setDescription(description);
		task.setEndTime(endTime);
		task.setClassId(classId);
		task.setUserId(userId);
		task.setTaskName(taskName);
		taskDAO.save(task);
		return 0;
	}
	
	public List<TaskModel>getModelListByClassId(Integer classId){
		List<Task>oldList = taskDAO.findByClassId(classId);
		List<TaskModel> list = new ArrayList<TaskModel>();
		for (int i = 0; i < oldList.size(); i++) {
			TaskModel taskModel = new TaskModel();
			taskModel.setTaskName(oldList.get(i).getTaskName());
			taskModel.setUrl("taskInfo.action?taskId=" + oldList.get(i).getTaskId());
			list.add(taskModel);
		}
		return list;
		
	}
	
	public Task getTaskById(Integer id){
		if (id == null) {
			return null;
		}
		return taskDAO.findById(id);
	}
	
	public Boolean CheckTaskByTaskIdAndUserId(Integer taskId , Integer userId){
		if (taskId == null || userId == null) {
			return false;
		}
		Task task = taskDAO.findById(taskId);
		if (task == null) {
			return false;
		}
		if (task.getUserId().equals(userId)) {
			return true;
		}else{
			return false;
		}
	}
	
	public void saveTask(Task task){
		if (task == null) {
			return;
		}
		taskDAO.save(task);
	}
	
	public List<Task>getListbyClassId(Integer classId){
		return taskDAO.findByClassId(classId);
	}
	
	public void deleteByTaskId(Integer id){
		Task task = taskDAO.findById(id);
		taskDAO.delete(task);
	}
}
