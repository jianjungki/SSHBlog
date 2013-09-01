package com.blog.orm;
import java.util.*;
/*
 * @author:jianjungki
 * @time:4.27
 * @function: for the content basic module 
 */
public class Content implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1244516185971476817L;
	private String author;
	private Date posttime;
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
}
