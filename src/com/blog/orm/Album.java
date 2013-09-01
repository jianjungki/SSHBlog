package com.blog.orm;

import java.util.Set;

/*
 * @author:jianjungki
 * @time:4.27
 * @function: for the album module 
 */
public class Album extends Content{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8603946099727389959L;
	private String albumtumb;
	private String albumname;
	private int albumsize;
	private Set<Photo> photos;
	
	
	public String getAlbumtumb() {
		return albumtumb;
	}
	public void setAlbumtumb(String albumtumb) {
		this.albumtumb = albumtumb;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	public int getAlbumsize() {
		return albumsize;
	}
	public void setAlbumsize(int albumsize) {
		this.albumsize = albumsize;
	}
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	
	
}
