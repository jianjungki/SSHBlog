package com.blog.service;

import java.util.List;

import com.blog.dao.BaseDao;
import com.blog.orm.Photo;

public class PhotoService<T> {
	private BaseDao dao;
	//获取相册
	public Photo doGetPhoto(int id) throws Exception{
		if(id <= 0 ) return null;
		String queryString = "SELECT p FROM Photo p WHERE p.id = "+id ;
		List<Photo> plist = dao.getObjects(queryString);
		//System.out.println(queryString+plist.size());
		return plist.get(0);
	}
	//修改文章
	public void doEditPhoto(T photoinfo) throws Exception{
		dao.updateObject(photoinfo);
	}
	//添加文章
	public int doAddPhoto(T photoinfo) throws Exception{
		return (Integer) dao.addObject(photoinfo);
	}
	//删除文章
	public void deletePhoto(int id,Class<T> clazz) throws Exception{
		T p = dao.getObject(clazz, id);
		dao.deleteObject(p);
	}
	//获取文章列表
	public List<Photo> doGetPhotoList(){
		return dao.getAllObjects(Photo.class);
	}
	
	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
	
}
