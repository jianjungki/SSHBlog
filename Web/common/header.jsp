<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = (String)session.getAttribute("pageshow");
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <base href="<%=basePath%>">
    
    <title>${param.title}</title>
    <!--   <link rel="stylesheet/less" type="text/css" href="bootstrap/less/bootstrap.less">
	  <script src="less.min.js" type="text/javascript"></script>
	 -->
	 <link rel="stylesheet" href="css/jquery.fileupload-ui.css">
	<link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
	  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
	<!--   <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-ie6.css">-->
	
	  <!--[if lte IE 6]>
	  <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-ie6.css">
	  <![endif]-->
	  <!--[if lte IE 7]>
	  <link rel="stylesheet" type="text/css" href="/bootstrap/css/ie.css">
	  <![endif]-->
	  <!-- CSS adjustments for browsers with JavaScript disabled -->
	<noscript><link rel="stylesheet" href="css/jquery.fileupload-ui-noscript.css"></noscript>
		<style>
		.passagelist li{
			display:block;
		}
		.passage_title{
  			float:left;
  			width:500px;
  		}
  		.buttom-list{
  			text-align:center;
  		}
  		/* Set the fixed height of the footer here */
      #push,
      #footer {
        height: 60px;
      }
      #footer {
        background-color: #f5f5f5;
      }

      /* Lastly, apply responsive CSS fixes as necessary */
      @media (max-width: 767px) {
        #footer {
          margin-left: -20px;
          margin-right: -20px;
          padding-left: 20px;
          padding-right: 20px;
        }
      }
      #wrap{
      	min-height: 83%
      }
  	</style>  
  	
  </head>
<body>
<div class="navbar">
    <div class="navbar-inner">
      <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
        <a class="brand" href="#">freedom博客</a>
        <div class="nav-collapse collapse navbar-responsive-collapse">
          <ul class="nav">
            <%if(url.equals("passageindex")){ %><li class="active"><%}else {%><li><%} %><a href="./index.jsp">主页</a></li>
            <%if(url.equals("albumlist")){ %><li class="active"><%}else {%><li><%} %><a href="./album_list">相册</a></li>
            <%if(url.equals("passagelist")){ %><li class="active"><%}else {%><li><%} %><a href="./passage_list">文章列表</a></li>
            <li><a href="http://about.me/jianjun.ye">关于我</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" style="" data-toggle="dropdown">增值功能 <b class="caret"></b></a>
              <ul class="dropdown-menu" style="">
                <li><a href="#">涂鸦墙</a></li>
                <li><a href="#">留言板</a></li>
              </ul>
            </li>
          </ul>
          <!--<form class="navbar-search pull-left" action="">
            <input type="text" class="search-query span2" placeholder="Search">
          </form>  -->
          <ul class="nav pull-right">
            <li><a href="#">Username</a></li>
            <li class="divider-vertical"></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">控制面板 <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="./passage_add">发表新文章</a></li>
                <li><a href="./photo_add">上传新照片</a></li>
                <li class="divider"></li>
                <li><a href="#">退出</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div>
    </div><!-- /navbar-inner -->
  </div>