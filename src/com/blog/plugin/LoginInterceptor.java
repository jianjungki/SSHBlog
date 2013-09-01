package com.blog.plugin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.blog.orm.Userinfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 取得请求相关的ActionContext实例
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Userinfo user = (Userinfo) session.getAttribute(Constants.USER_SESSION);

		// 如果没有登陆，或者登陆所有的用户名不是yuewei，都返回重新登陆
		String uname = user.getUname();
		System.out.println(uname);
		if (uname != null && uname.equals("jianjungki")) {
			System.out.println("test");
			return invocation.invoke();
		}
		return Action.LOGIN;

	}

}
