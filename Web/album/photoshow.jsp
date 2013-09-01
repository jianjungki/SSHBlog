<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:include page="../common/header.jsp">
	<jsp:param value="我的相册"  name="title" />
</jsp:include>
<div id="wrap">
 <div class="container">
	  <div id="albumlist" >
	  		<div class="albumpic"><a href="photo_show?photo_id=${photo.id+1}" ><img src="photoimg/${photo.filename}"  alt="${photo.filename}"  /></a></div>
	  </div>
  </div>
</div>
  <jsp:include page="../common/footer.jsp"></jsp:include>
  </body>
</html>
