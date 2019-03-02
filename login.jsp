<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="resources/css/login.css">

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="wrapper">
			<form action="LoginController" method="post" name="Login_Form" class="form-signin">
				<h3 class="form-signin-heading">WELCOME</h3>
				<hr class="colorgraph">
				<span style="color:red">${LogOutMsg}</span>
				<br> <input type="text" class="form-control" name="uname"
					placeholder="Username" required="" autofocus=""  /> <input
					type="password" class="form-control" name="pass"
					placeholder="Password" required="" />

				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit">Login</button>
			</form>
		</div>
	</div>

</body>

</body>
</html>