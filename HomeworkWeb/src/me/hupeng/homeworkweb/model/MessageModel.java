package me.hupeng.homeworkweb.model;

public class MessageModel {
	private String url;
	private String title;
	private String text;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MessageModel(String title,String text,String url){
		this.title = title;
		this.text =text;
		this.url = url;
	}
	public MessageModel(){
		
	}
	public void setData(String title,String text,String url){
		this.title = title;
		this.text =text;
		this.url = url;
	}
}
