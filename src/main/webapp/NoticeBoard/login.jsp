<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>byeonghyeon</title>
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    
    <script>
    	function init(){
			$('#mem_id').val("test");
			$('#mem_pass').val("1234");
		}
    	
    	$(function(){    		
    		init();
    	})    
    </script>
    
  </head>

  <body>

    <div class="container">
      <form class="form-signin" action = "${pageContext.request.contextPath }/loginServlet" method = "post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text"  class="form-control" placeholder="Id" id="mem_id" name = "mem_id" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  class="form-control" placeholder="Password" id="mem_pass" name = "mem_pass" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div> 
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
