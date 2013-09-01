<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
   <jsp:include page="common/header.jsp">
   		<jsp:param value="添加文章" name="title"/>
   </jsp:include>
 <div id="wrap">

<div class="container-fluid">
 	<div class="page-header">
	  		<h1>It's my Blog</h1>
	 </div>
  <div class="row-fluid">
    <div class="span10">
    	<div id="passagelist">
    		<ol>
		  		<s:iterator id="passage" value="pslist" status="sta">
		    		<li><div class="passage_title"><a href="passage_show.action?passage_id=${passage.id}">${passage.title }</a></div><div class="passage_time">${passage.posttime }</div></li>
		   		</s:iterator>
	   	 	</ol>
    	</div>
    	<div id="photolist">这是第二个</div>
    	<div id="commentlist">这是第三个</div>
    	<div id="aboutme">这是第四个</div>
	</div>
	<div class="span2">
    	<div class="row-fluid">
          <div class="span6">我的主页</div>
        </div>
        <div class="row-fluid">
          <div class="span6">文章列表</div>   
        </div>
        <div class="row-fluid">
          <div class="span6"><a href="http://about.me/jianjun.ye">关于我</a></div>   
        </div>
        <div class="row-fluid">
          <div class="span6"><a href="./album_list.action">留言板</a></div>   
        </div>
         <div class="row-fluid">
          <div class="span6">涂鸦墙</div>   
        </div>
         <div class="row-fluid">
          <div class="span6"><a href="./album_list.action">相册</a></div>   
        </div>
    </div>
</div>
</div>
</div>
 <jsp:include page="common/footer.jsp"></jsp:include>
<!--<div id="footer">
      <div class="container">
        <p class="muted credit">Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.</p>
      </div>
</div>-->
  </body>
</html>
