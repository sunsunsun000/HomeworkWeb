package me.hupeng.homeworkweb.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;

public class CheckCode extends HttpServlet{

	private static int width=100;
	private static int height=30;
	private String code;
	
	public CheckCode() {
		// TODO Auto-generated constructor stub
	}	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		code="";
		BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=bufferedImage.getGraphics();
		
		setBackColor(g);
		setBorder(g);
		drawRandomLine(g);
		drawRandomNum((Graphics2D)g);
		
		response.addHeader("Cache-control", "no-cache");
		response.addHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

		HttpSession session = request.getSession();
		session.setAttribute("checkCode", code);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}
	
	public void setBackColor(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
	}
	
	public void setBorder(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(1, 1, width-2, height-2);
	}
	
	public void drawRandomLine(Graphics g){
		g.setColor(Color.GREEN);
		for (int i = 0; i < 4; i++) {
			int x1,x2,y1,y2;
			x1=new Random().nextInt(width);
			y1=new Random().nextInt(height);
			
			x2=new Random().nextInt(width);
			y2=new Random().nextInt(height);
			
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	public void drawRandomNum(Graphics2D g){
		g.setColor(Color.GREEN);
		g.setFont(new Font("ËÎÌו", Font.BOLD, 30));
		String base[] = {"0","1","2","3","4","5","6","7","8","9"};
		int x=10,y=25;
		for(int i=0;i<4;i++){
			int RandNum=new Random().nextInt(base.length);
			int degree=new Random().nextInt()%30;
			g.rotate(degree*Math.PI/180, x, y);
			g.drawString(base[RandNum], x, y);
			code+=base[RandNum];
			g.rotate(-degree*Math.PI/180, x, y);
			x+=20;
		}
	}
}
