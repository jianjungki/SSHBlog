<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:include page="../common/header.jsp">
	<jsp:param value="我的相册"  name="title" />
</jsp:include>
<div id="wrap">

 <div class="container">
 	  <div style="position:relative;height:50px;">
 	  		<a href="./photo_add?albid=<% out.print(request.getParameter("album_id")); %>"  class="btn btn-small" style="float:left">上传新照片</a>
 	  		<a href="./album_list"  class="btn btn-small" style="float:right">返回相册集</a>
 	  </div>
	  <div id="albumlist" >
	  			<s:iterator id="photo" value="plist" status="get">
		    		<img src="photoimg/${photo.filename}"  alt="${photo.filename}"  />
		  		 </s:iterator>
	  </div>
  </div>
</div>
  <jsp:include page="../common/footer.jsp"></jsp:include>
  <script src="js/galleria.js"></script>
  <script src="js/galleria.history.js"></script>
  <script>
            Galleria.loadTheme('js/themes/classic/galleria.classic.min.js');
            Galleria.run('#albumlist', {
  				height: 500,
  				wait: true
 			});
 </script>
  </body>
</html>
