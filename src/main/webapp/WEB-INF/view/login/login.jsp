<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardPan Login</title>

<!-- basicLib -->
<%@ include file="../common/basicLib.jsp"%>

<link href="/css/signin.css" rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function(){
		console.log("test");
		
		if(getCookie("rememberMe")=="Y"){
			$("#checkbox").attr("checked",checked);	
			$("#inputId").val(getCookie("userId"));
		}
	});
	
	function getCookie(cookieName){
	var cookies = document.cookie.split("; ");
	var cookieValue="";
	
	for(var i=0 ; i< cookies.length; i++){
		var str = cookies[i];
		if(str.startsWith(cookieName+"=")){
			cookieValue = str.substring((cookieName+"=").length);
		}
	}
	return cookieValue;
}
</script>

</head>
<body>
	<div class="container">
		<form class="form-signin" method="post" action="/loginCheck">
			<h2 class="form-signin-heading">Please sign in</h2>
			
			<label for="inputId" class="sr-only">UserId</label>
			<input id="inputId"  type="text" name="userid" value="boss"
				class="form-control" placeholder="아이디를 입력하세요"> <br />
			
			<label for="inputPassword" class="sr-only">Password</label>	
			<input type="password" name="userpass" value="passboss"
				class="form-control" placeholder="비밀번호를 입력하세요"> <br />
				
			<div class="checkbox">
				<label> 
					<input id="checkbox" type="checkbox" name="remember-me" >
					Remember me
				</label>
			</div>
			<button type="submit" value="로그인"
				class="btn btn-lg btn-primary btn-block">Sign in</button>
		</form>
	</div>
</body>
</html>