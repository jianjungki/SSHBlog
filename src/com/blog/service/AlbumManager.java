package com.blog.service;

import java.util.List;

import com.blog.dao.BaseDao;
import com.blog.orm.Album;

public class AlbumManager<T> {
	private BaseDao dao;
	//获取相册
	public Album doGetAlbum(int id) throws Exception{
		if(id <= 0 ) return null;
		String queryString = "SELECT a FROM Album a WHERE a.id = "+id ;
		List<Album> album = dao.getObjects(queryString);
		return album.get(0);
	}
	//修改文章
	public void doEditAlbum(T albuminfo) throws Exception{
		dao.updateObject(albuminfo);
	}
	//添加文章
	public void doAddAlbum(T albuminfo) throws Exception{
		dao.addObject(albuminfo);
	}
	//删除文章
	public void deleteAlbum(int id,Class<T> clazz) throws Exception{
		T p = dao.getObject(clazz, id);
		dao.deleteObject(p);
	}
	//获取文章列表
	public List<Album> doGetAlbumList(){
		return dao.getAllObjects(Album.class);
	}
	
	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
}
