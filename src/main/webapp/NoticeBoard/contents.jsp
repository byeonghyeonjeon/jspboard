<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>main</title>
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <script>
    	$(function(){
    		//게시판 추가하기위한 페이지 이동
    		$('#boardAdd').on('click',function(){
    			document.location = "${pageContext.request.contextPath }/NoticeBoard/boardAdd.jsp" 
    		})
    		
    		$('.boardList').on('click',function(){
    		//	document.location = "${pageContext.request.contextPath }/NoticeBoard/contents.jsp"
    		})
    		
    		$('#postInfoTb tr').on('click',function(){
    			var post_nm = $(this).find("td:eq(0)").text();    			
    			var board_nm = $(this).attr("id");
    			 $('#post_nm').val(post_nm); 
    			$('#board_nm').val(board_nm);
    			
    			$('#postList').submit();
    			
    		})
    		
    		//게시글작성    		
    		$('#insertPost').on('click',function(){
    			//document.location = "${pageContext.request.contextPath }/NoticeBoard/postAdd.jsp"
    			var board_nm = ${board_nm};
    			$('#board_nm').val(board_nm);
   				$('#postList').attr('action',"${pageContext.request.contextPath }/postAdd");
   				$('#postList').submit();
    		})
   		})
    
    </script>

  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="boardAdd" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">게시판 추가하기</a></li>
				</ul>
			</div>
		</div>
	</nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">    
      <%@ include file="/layout/left.jsp" %>

           </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Section title</h2>
           <input id = "insertPost" type="button" value="글쓰기" >
           
          <form id ="postList" 
          	    action="${pageContext.request.contextPath }/postDetail"
       			method="get">
   			<input id="board_nm" type="hidden" name="board_nm" >
   			<input id="post_nm" type="hidden" name="post_nm" >
          <div class="table-responsive">
          
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>글번호</th>
                  <th>글제목</th>
                  <th>작성자</th>
                  <th>작성일자</th>
                </tr>
              </thead>
              <tbody id = "postInfoTb" >                            	
                <c:forEach items="${postList }" var="postList">
                <tr id="${postList.board_nm }" >                
                  <td>${postList.post_nm }</td>
                  <td>${postList.post_title }</td>
                  <td>${postList.mem_id }</td>
                  <td><fmt:formatDate value="${postList.post_dt }" pattern="yyyy-MM-dd"/> </td>                
                </tr>
                </c:forEach>                 
               </tbody>
            </table>
            
          </div>
        </form>
        
                    
          <!-- 페이지네이션 -->
          ${pageNav }          
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${pageContext.request.contextPath }/js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath }/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
