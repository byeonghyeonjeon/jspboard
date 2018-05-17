<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    		$('#insertBoard').on('click',function(){
    			if($('#board_title').val().trim() == "" ){    				
    				alert("게시판명을 입력해주세요");
    			}else {    				
	    			$('#frm').submit();
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
          <h1 class="page-header">게시판 추가하기</h1>
				<div class="row placeholders">
					<div class="form-group">
						<label class="col-sm-2 control-label">게시판명</label>
						<form id = "frm" action="${pageContext.request.contextPath }/boardAdd" method="post">
							<div class="col-sm-4">
								<input type="text" class="form-control" id="board_title"
									name="board_title" placeholder="게시판명"	>
							</div>
						</form>					
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="insertBoard" type="button" class="btn btn-default">게시판 등록</button>
						</div>
					</div>
					
				</div>			
          <div class="table-responsive">
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
