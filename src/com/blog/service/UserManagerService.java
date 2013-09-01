package com.blog.service;

import java.util.List;

import com.blog.dao.BaseDao;

public class UserManagerService<T> {
	
	private BaseDao dao;
	
	public T doLogin(String userName,String password) throws Exception{
		if(userName == null || password == null) return null;
		String queryString = "SELECT u FROM Userinfo u WHERE u.uname = '"+userName +"' AND u.password = "+password;
		List<T> users = dao.getObjects(queryString);
		return users.get(0);
	}
	
	public List<T> queryUsers(String uname,Class<T> clazz){
		if(uname == null || "".equals(uname))
			return dao.getAllObjects(clazz);
		String queryString = "SELECT u FROM Userinfo u WHERE u.uname like '"+uname+"%'";
		return dao.getObjects(queryString);
	}
	
	public void addUser(T user) throws Exception{
		dao.addObject(user);
	}
	
	public void modifyUser(T user) throws Exception{
		dao.updateObject(user);
	}
	
	public void deleteUser(int id,Class<T> clazz) throws Exception{
		T u = dao.getObject(clazz, id);
		dao.deleteObject(u);
	}
	
	public T getUser(Class<T> clazz, int id){
		return dao.getObject(clazz, id);
	}
	
	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
}
