<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="favicon.ico" />
    <link rel="icon" href="../../favicon.ico">
    <title>main</title>
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>
    <script>
    	$(function(){
    		//게시판 추가하기위한 페이지 이동
    		$('#boardAdd').on('click',function(){
    			document.location = "${pageContext.request.contextPath }/NoticeBoard/boardAdd.jsp" 
    		})
    		
   		})
    </script>
    <script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$('#postFrm').submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}
	return true;
}

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
        
		<!--content  -->        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Section title</h2>
                    
          <div class="table-responsive">
			<form id="postFrm"
					action="${pageContext.request.contextPath }/postAdd"
					method="post">
			 <div class="form-group">
				<label class="col-sm-1 control-label">제목 : </label>
				<div class="col-sm-8">
				 <input type="text" class="form-control" id="post_title"
						name="post_title" placeholder="제목">
				 <input type="hidden" name="board_nm" value = "${board_nm }">
				</div>				
			 	</div>
			
			<table>
               	<tr>
               		<td><input type="file"></td>
               	</tr>
               	<tr>
               		<td><input type="file"></td>
               	</tr>
               	<tr>
               		<td><input type="file"></td>
               	</tr>
               	<tr>
               		<td><input type="file"></td>
               	</tr>
               	<tr>
               		<td><input type="file"></td>
                </tr>               
               </table>               
            
			 <br><br><br>
					<!-- Smart Editor  -->
              
               
               <textarea name="post_cnt" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea>
			   <input type="button" id="savebutton" value="게시글 작성" />
               
               		<!-- Smart Editor  -->
               <!--
			   <textarea name="post_cnt" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
			   <input type="button" id="savebutton" value="게시글 작성" />             
               -->  
               
               <br><br>               
               </form>
               
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
