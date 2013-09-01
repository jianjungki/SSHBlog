package com.blog.orm;

public class Photo extends Content{
	
	private static final long serialVersionUID = -8603946099727389959L;
	private String filename;
	private long size;
	private String thumbnailFilename;
	private String newFilename;
    private String contentType;
    private String url;
    private String thumbnail_url;
    private String delete_url;
    private String delete_type;

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getThumbnailFilename() {
		return thumbnailFilename;
	}
	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}
	public String getNewFilename() {
		return newFilename;
	}
	public void setNewFilename(String newFilename) {
		this.newFilename = newFilename;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String getDelete_url() {
		return delete_url;
	}
	public void setDelete_url(String delete_url) {
		this.delete_url = delete_url;
	}
	public String getDelete_type() {
		return delete_type;
	}
	public void setDelete_type(String delete_type) {
		this.delete_type = delete_type;
	}
}
