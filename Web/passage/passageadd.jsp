<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

   <jsp:include page="../common/header.jsp">
   		<jsp:param value="添加文章" name="title"/>
   </jsp:include>
   
 <div id="wrap">

<div class="container-fluid">
 	<div class="page-header">
	  		<h1>It's my Blog</h1>
	 </div>
  <div class="row-fluid">
    <div class="span10">
    <form action="passage_addction" method="post" id="form1" class="form-horizontal">
   		
    	<div  class="control-group">
    		<label  class="control-label">文章标题</label>
    		<div class="controls">
    			<input type="text"   class="input-xxlarge" placeholder="输入你的标题"  name="title"/>
    		</div>
	    </div>
	    <div  class="control-group">
	    	<label  class="control-label">文章内容</label>
		    <div class="controls">
		    	<textarea id="editor_id" name="content" style="width:700px;height:300px;">
				</textarea>
			 </div>
		 </div>
		<div  class="control-group">
			<div class="controls">
				<input type="submit" value="添加文章" class="btn"/>&nbsp;&nbsp;
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
<!--<div id="footer">
      <div class="container">
        <p class="muted credit">Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.</p>
      </div>
</div>-->
  </body>

<script charset="utf-8" src="js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="js/kindeditor/lang/zh_CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script>
</html>
