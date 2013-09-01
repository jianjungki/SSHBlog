package com.blog.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.blog.orm.Userinfo;
import com.blog.service.UserManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAct extends ActionSupport {


	private static final long serialVersionUID = -281275682819237996L;
	
	private Userinfo user = new Userinfo(); 
	
	private UserManagerService<Userinfo> userService;
	
	private List<Userinfo> users;
	
	private String searchText;
	
	public String doLogin(){
		if(this.user.getUname() == null || this.user.getPassword() == null) return INPUT;
		try {
			Userinfo user = userService.doLogin(this.user.getUname(), this.user.getPassword());
			if(user != null){
				ActionContext.getContext().getSession().put("userinfo", user);
				return doQuery();
			}else
				return INPUT;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String doQuery(){
		searchText = getParam("queryText");
		users = userService.queryUsers(searchText,Userinfo.class);
		return SUCCESS;
	}

	public String doAdd(){
		String result = "";
		try {
			String param = getParam("param");
			if(Integer.parseInt(param) > 0){
				user.setId(0);
				userService.addUser(user);
				result = doQuery();
			}else
				result = "addUser";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String doEdit(){
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				Integer id = Integer.parseInt(getParam("id"));
				user = userService.getUser(Userinfo.class, id);
				return "editUser";
			}else if(param == 1){
				userService.modifyUser(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doQuery();
	}
	
	public String doDelete(){
		try {
			Integer param = Integer.parseInt(getParam("id"));
			userService.deleteUser(param,Userinfo.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doQuery();
	}
	
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}
	
	public UserManagerService<Userinfo> getUserService() {
		return userService;
	}

	public void setUserService(UserManagerService<Userinfo> userService) {
		this.userService = userService;
	}

	public List<Userinfo> getUsers() {
		return users;
	}

	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
}
