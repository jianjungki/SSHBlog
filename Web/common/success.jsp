<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="refresh" content="3;URL=passage_list"/>
    <title>操作成功</title>
  </head>
  <body>
    	操作成功，将会跳转... 也可以直接<a href="passage_list">点击跳转</a><br>
  </body>
</html>
