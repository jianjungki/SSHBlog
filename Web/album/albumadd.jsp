<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp">
	<jsp:param value="我的相册"  name="title" />
</jsp:include>
<div id="wrap">

<div class="container-fluid">
 	<div class="page-header">
	  		<h1>It's my Blog</h1>
	 </div>
  <div class="row-fluid">
    <div class="span10">
    <form action="album_addction" method="post" id="form1" class="form-horizontal" enctype ="multipart/form-data">
   		
    	<div  class="control-group">
    		<label  class="control-label">专辑标题</label>
    		<div class="controls">
    			<input type="text"   class="input-large" placeholder="输入你的专辑标题"  name="abname"/>
    		</div>
	    </div>
	    <div  class="control-group">
	    	<label  class="control-label">专辑封面</label>
		    <div class="controls">
		    	<input type="file"  name="album" />
			 </div>
		 </div>
		<div  class="control-group">
			<div class="controls">
				<input type="submit" value="添加专辑" class="btn"/>&nbsp;&nbsp;
				<input type="reset" value="重置" class="btn"/>
			</div>
		</div>
	</form>
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
  <jsp:include page="../common/footer.jsp"></jsp:include>
  </body>
</html>
