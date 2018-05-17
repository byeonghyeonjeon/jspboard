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
    		
    		/* $('#postInfoTb tr').on('click',function(){
    			var post_nm = $(this).find("td:eq(0)").text();    			
    			var board_nm = $(this).attr("id");
    			 $('#post_nm').val(post_nm); 
    			$('#board_nm').val(board_nm);
    			
    			$('#postList').submit();
    			
    		}) */
    		
    		$('#insertCmt').on('click', function(){
    			if($('#cmt_cnt').val().trim()==""){
    				alert("댓글 내용을 입력하세요");
    			}else{
	    			$('#cmtFrm').submit();    				
    			}    					
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
          <form id ="postList" 
          	    action="${pageContext.request.contextPath }/postDetail"
       			method="post">
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
              <tbody>              	
               
                <tr id="${postVO.board_nm }" >                
                  <td>${postVO.post_nm }</td>
                  <td>${postVO.post_title }</td>
                  <td>${postVO.mem_id }</td>
                  <td><fmt:formatDate value="${postVO.post_dt }" pattern="yyyy-MM-dd"/> </td>                
               </tr>
               <tr>
               	  <td>글 내용</td>
               </tr> 
               <tr>
                  <td>${postVO.post_cnt }</td>
               </tr> 
               </tbody>
            </table>
            <br><br><br><br>
            
            
             <table class="table table-striped">
              <thead>
                <tr>
                  <th>댓글 번호</th>
                  <th>댓글 내용</th>
                  <th>작성자</th>
                  <th>작성일자</th>
                </tr>
              </thead>
              <tbody>              	
               <c:forEach items="${cmtList }" var="cmtList">
                <tr >                
                  <td>${cmtList.cmt_nm }</td>
                  <td>${cmtList.cmt_cnt }</td>
                  <td>${cmtList.mem_id }</td>
                  <td><fmt:formatDate value="${cmtList.cmt_dt }" pattern="yyyy-MM-dd"/> </td>                
                </tr>
              </c:forEach>
             </tbody>
            </table>
          </div>
        </form>			
	  </div>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h4 class="page-header">댓글 추가하기</h4>
				<div class="row placeholders">
					<div class="form-group">
						<label class="col-sm-2 control-label">내용</label>
						<form id="cmtFrm" action="${pageContext.request.contextPath }/cmtAdd"
							method="post">
							<div class="col-sm-4">
								<input type="text" class="form-control" id="cmt_cnt"
									name="cmt_cnt">
								<input type="hidden" name="post_nm" value="${postVO.post_nm }">
								<input type="hidden" name="board_nm" value="${postVO.board_nm }">
							</div>
						</form>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="insertCmt" type="button" class="btn btn-default">댓글
								등록</button>
						</div>
					</div>

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
