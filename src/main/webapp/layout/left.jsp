<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	   

<!-- /////////////////////////////////////Board제목 출력///////////////////////////////////////////////////  -->        
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">게시판 목록 <span class="sr-only">(current)</span></a></li>
            
			<c:forEach items="${boardList }" var = "boardList">
				<li class="boardList"><a href="${pageContext.request.contextPath }/boardContent?board_nm=${boardList.board_nm}&page=1&pageSize=10">${boardList.board_title }</a></li>			
			</c:forEach>
			                  
          </ul>
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////  -->