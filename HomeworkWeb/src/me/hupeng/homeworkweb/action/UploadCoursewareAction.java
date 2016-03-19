package me.hupeng.homeworkweb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import me.hupeng.homeworkweb.model.MessageModel;
import me.hupeng.homeworkweb.service.CoursewareService;
import me.hupeng.homeworkweb.service.HomeworkService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//ppt文件上传类
public class UploadCoursewareAction extends ActionSupport{
	private String allowType="application/vnd.ms-powerpoint,application/x-ppt，application/vnd.openxmlformats-officedocument.presentationml.presentation";
    // 封装上传文件域的属性
    private File file;
    // 封装上传文件类型的属性
    private String fileContentType;
    // 封装上传文件名的属性
    private String fileFileName;
    // 接受依赖注入的属性
    private String savePath;
    private MessageModel messageModel;
    private CoursewareService coursewareService;
    private String filePath;
    private String fullPath;
    private String classId;
    public File getFile() {
		return file;
	}
    
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public CoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setCoursewareService(CoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
    public String execute() throws Exception {
		//用户身份认证
		Integer classIdInteger;
		messageModel = new MessageModel();
		try {
			classIdInteger = Integer.parseInt(classId);
			if (!(classIdInteger+"").equals(classId)) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
			messageModel.setText("原因：操作非法，您的IP地址" + ServletActionContext.getRequest().getRemoteAddr()+"已被系统记录");
			messageModel.setTitle("上传结果：上传失败");
			messageModel.setUrl("taskInfo.action");
			return "message";
		}
		
		
		if (fileContentType == null ) {
			messageModel.setTitle("上传结果：上传失败");
			messageModel.setText("原因：请先选择文件再上传");
			messageModel.setUrl("coursewareInfo.action?classId=" + classId);
			return "message";
		}
		if (!allowType.contains(fileContentType)) {
			messageModel.setTitle("上传结果：上传失败");
			messageModel.setText("原因：文件类型不允许，当前允许的文件类型：" + allowType + "，若需要支持更多文件类型，请联系管理员！");
			messageModel.setUrl("coursewareInfo.action?classId=" + classId);
			return "message";
		}
		
		SecurityAction securityAction = new SecurityAction();
		if (!securityAction.checkUser()) {
			return LOGIN;
		}
		
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            // 建立文件输出流
            filePath = getSavePath();
            savePath += "/" + "courseware/"+ classId;
            File tempFile = null;
            tempFile = new File(savePath);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
    		}
            fullPath = savePath + "/" + classId + "_" + System.currentTimeMillis() + "." +getFileFileName().split("\\.")[getFileFileName().split("\\.").length-1];
            fos = new FileOutputStream(fullPath);
            // 建立文件上传流 
            fis = new FileInputStream(getFile());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            System.out.println("文件上传失败");
            messageModel.setTitle("上传结果：上传失败");
			messageModel.setText("原因：" + e);
			messageModel.setUrl("coursewareInfo.action?classId=" + classId);
            e.printStackTrace();
			return "message";
        } finally {
            close(fos, fis);
        }
        //这里完成数据库写入操作*********************************x
//        homeworkService.add(securityAction.getUserId(),taskIdInteger, fullPath.replace(filePath.replace("uploadFile", ""), ""));
        coursewareService.add(fileFileName, fullPath, securityAction.getUserId(), classIdInteger);
        //homeworkService.add(securityAction.getUserId(),taskIdInteger, fullPath);
        //************************************************
        messageModel.setTitle("上传结果：上传成功");
		messageModel.setText("上传者：" + securityAction.getUsername() + "<br>" + "时间戳：" + System.currentTimeMillis()/1000 + "<br>" + "文件名：" + fileFileName);
		messageModel.setUrl("coursewareInfo.action?classId=" + classId);
        return "message";
    }

    /**
     * 返回上传文件的保存位置
     * 
     * @return
     */
    public String getSavePath() throws Exception{

    	if (savePath == null) {
    		 ServletActionContext.getServletContext().getRealPath(savePath);
		}
    	savePath = "/home/HomeworkWeb" +savePath;
        return savePath;
    }

    
    private void close(FileOutputStream fos, FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }
    }
}
