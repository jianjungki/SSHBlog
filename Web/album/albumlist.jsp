<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:include page="../common/header.jsp">
	<jsp:param value="我的相册"  name="title" />
</jsp:include>
<div id="wrap">
 <div class="container">
	  <div id="albumlist" >
	  		<ol>
	  			<s:iterator id="album" value="allist" status="get">
		    		<li><div class="albumpic"><a href="album_show?album_id=${album.id}" ><img src="albumimg/${album.albumtumb}"  alt="${album.albumname}"  /></a></div>
		  		 </s:iterator>
	  		</ol>
	  </div>
  </div>
</div>
  <jsp:include page="../common/footer.jsp"></jsp:include>
  </body>
</html>
