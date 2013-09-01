package com.blog.orm;

/*
 * @author:jianjungki
 * @time:4.27
 * @function: for the passage module 
 */
public class Passage extends Content {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1270731764534631296L;
	private String title;
	private String content;
	
	public Passage(){
		
	}
	
	public Passage(int id){
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
