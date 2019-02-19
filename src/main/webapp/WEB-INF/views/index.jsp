<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<head>	    
	    <title>User Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	    <style>
		</style>
	</head>
	
	<body>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="/"><strong>MIS</strong></a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/">Login</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="addUser">User Registration</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="#">Disabled</a>
		      </li>
		    </ul>
		  </div>
		</nav>


		<br/><br/>
	    <div class="container">
	        <h3 id="form_header" align="center">Login</h3>
	        <div>&nbsp;</div>
	
	        <!-- User input form to validate a user -->
	        <c:url var="loginUrl" value="/login" />
	        <form id="user_form" action="${loginUrl}" method="POST">
	            <div class="form-group">
	                <label for="name">User email:</label>
	                <input type="text" class="form-control" id="name" placeholder="Enter email" name="email" required>
	            </div>
	            <div class="form-group">
	                <label for="pwd">Password:</label>
	                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
	            </div>
	            <div align="center"> 
	            	<button id="confirm_user" type="submit" class="btn btn-primary">Login</button>
	            </div>
	        </form>
    	    <div align="center"> 
	        	<p>	Are you new here? Create a new account. <a href="addUser">here</a></p>
	        </div>
	    </div>


	</body>
</html>