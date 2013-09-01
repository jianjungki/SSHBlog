<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <jsp:include page="../common/header.jsp">
 	<jsp:param value="文章列表页" name="title"/>
 </jsp:include>
 <div id="wrap">
 <div class="container">
	  <div class="passagelist" >
	    <div style="height:60%;">
	    <ol>
		  <s:iterator id="passage" value="pageset.list" status="sta">
		    	<li><div class="passage_title"><a href="passage_show.action?passage_id=${passage.id}">${passage.title }</a></div><div class="passage_time">${passage.posttime }</div></li>
		   </s:iterator>
	    </ol>
	    </div>
	    <div class="buttom-list">
	    	<div class="">
	    	    共<s:property value="pageset.allRow"/> 条记录
        		共<s:property value="pageset.totalPage"/> 页
        		当前第<s:property value="pageset.currentPage"/>页<br/>
        	</div>
	        <div>
	        	<ul class="pager">
	        	<s:if test="%{pageset.currentPage <= 1}">
		            <li  class="previous disabled"><a href="#" onclick='return false;'>&larr;Prev</a></li>
		         </s:if>
		         <s:else>
		            <li class="previous"><a href="passage_list?page=<s:property value="%{pageset.currentPage-1}"/>">&larr;Prev</a></li>
		         </s:else>
		         <s:if test="%{pageset.currentPage != pageset.totalPage}">
		           <li class="next"> <a href="passage_list?page=<s:property value="%{pageset.currentPage+1}"/>">Next &rarr;</a></li>
		         </s:if>
		         <s:else>
		            <li  class="next disabled"><a href="#" onclick='return false;'>Next&rarr;</a></li>
		         </s:else>
		         </ul>
			</div>
		</div>
	  </div>
</div>
</div>
	  <jsp:include page="../common/footer.jsp"></jsp:include>
  </body>
</html>
