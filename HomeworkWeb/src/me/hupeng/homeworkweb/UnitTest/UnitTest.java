package me.hupeng.homeworkweb.UnitTest;

import me.hupeng.homeworkweb.util.MD5;

import org.aspectj.apache.bcel.generic.NEW;
import org.junit.Test;

public class UnitTest {
	@Test
	public void test(){
		System.out.println(System.currentTimeMillis());
	}
	
	@Test
	public void test2(){
		//System.out.println(new MD5().encryptPassword("123"));
		String fileName ="abc.jpg";
		System.out.println(fileName.split("\\.")[1]);
	}
	
	
	@Test
	public void test3(){
		String s = "123abc";
		int n ;
		try {
			n = Integer.parseInt(s);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sajfnbdas");
		}
		
		
	}
	
	@Test
	public void testt(){
		System.out.println(new MD5().encryptPassword("123"));
	}
}
