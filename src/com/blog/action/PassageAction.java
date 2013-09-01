package com.blog.action;


import com.blog.orm.Passage;
import com.blog.orm.Userinfo;
import com.blog.plugin.PageBean;
import com.blog.service.PassageManager;
import com.blog.service.UserManagerService;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PassageAction extends ActionSupport {
	private static final long serialVersionUID = 7531642801708266510L;
	private PassageManager<Passage> passageService;
	private UserManagerService<Userinfo> userService;
	private List<Passage> pslist;
	private Passage psinfo;
	private int pageNow = 1 ; //初始化为1,默认从第一页开始显示  
	private int pageSize = 15 ; //每页显示5条记录  
	private PageBean pageset;
	public PageBean getPageset() {
		return pageset;
	}

	public void setPageset(PageBean pageset) {
		this.pageset = pageset;
	}

	public Passage getPsinfo() {
		return psinfo;
	}

	public void setPsinfo(Passage psinfo) {
		this.psinfo = psinfo;
	}

	PassageAction(){
		
	}
	
	public UserManagerService<Userinfo> getUserService() {
		return userService;
	}

	public void setUserService(UserManagerService<Userinfo> userService) {
		this.userService = userService;
	}
	
	public PassageManager<Passage> getPassageService() {
		return passageService;
	}

	public void setPassageService(PassageManager<Passage> passageService) {
		this.passageService = passageService;
	}

	public List<Passage> getPslist() {
		return pslist;
	}

	public void setPslist(List<Passage> pslist) {
		this.pslist = pslist;
	}
	
	
	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String showPassage() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","passageshow");
		String param = ServletActionContext.getRequest().getParameter("passage_id");
		int id = Integer.parseInt(param);
		try {
			setPsinfo(passageService.doGetPassage(id));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "show";
	}
	
	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String listPassage() {
		// TODO Auto-generated method stub
		//ActionContext ac= ActionContext.getContext();
		//HttpServletRequest request = (HttpServletRequest)ac.get(StrutsStatics.HTTP_REQUEST);
		//String pscontent= (String)request.getAttribute("content");
		//String psauthor= (String)request.getAttribute("author");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","passagelist");
		 try {
			 setPageset(passageService.getPassageByPage(pageNow, pageSize));
		  } catch (Exception e) {
			   e.printStackTrace();
	      }
		  System.out.println(pageset.getList().size());
		  
		return "list";
	}
	
	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String editPassage() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","passageedit");
		
		String param = ServletActionContext.getRequest().getParameter("passage_id");
		int id = Integer.parseInt(param);
		try {
			setPsinfo(passageService.doGetPassage(id));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "edit";
	}
	
	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String deletePassage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String param = ServletActionContext.getRequest().getParameter("passage_id");
		int id = Integer.parseInt(param);
		try {
			passageService.deletePassage(id, Passage.class);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "delete";
	}
	
	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String addPassage() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","passageadd");
		
		return "add";
	}
	
	
	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String addctionPassage() {
		ServletActionContext.getRequest();
		String title=ServletActionContext.getRequest().getParameter("title");
		String passage_content=ServletActionContext.getRequest().getParameter("content");
		Date posttime = new Date();
		Passage passageinfo = new Passage();
		passageinfo.setAuthor("admin");
		passageinfo.setContent(passage_content);
		passageinfo.setTitle(title);
		passageinfo.setPosttime(posttime);
		 try {
			 passageService.doAddPassage(passageinfo);
		  } catch (Exception e) {
			   e.printStackTrace();
			   return "error";
	      }
		return "success";
	}
	
	public String indexPassage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("pageshow","passageindex");
		
		return "index";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}



	

}
