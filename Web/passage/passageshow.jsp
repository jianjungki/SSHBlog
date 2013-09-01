<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <jsp:include page="../common/header.jsp">
 	<jsp:param value="${psinfo.title}" name="title"/>
 </jsp:include>
   <div id="wrap">

      <!-- Begin page content -->
      <div class="container">
	        <div class="page-header">
	          <h1>${psinfo.title}</h1>
	        </div>
       		 <p class="lead">${psinfo.content}</p>
      </div>

      <div id="push"></div>
    </div>

     <jsp:include page="../common/footer.jsp"></jsp:include>
     
     
  </body>
</html>
