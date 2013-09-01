<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>user login page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    	<form action="userManagerAct" method="post">
    		<table>
    			<tr>
    				<td>username</td><td><input type="text" name="user.uname"/></td>
    				<td>password</td><td><input type="password" name="user.password"/></td><td>密     码</td><td></td>
    				<td colspan="2">
    					<input type="submit" value="提交">
    					<input type="reset" value="重置">
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
