<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<<<<<<< Updated upstream
		        <a class="nav-link" href="addUser">User Registraton</a>
=======
		        <a class="nav-link" href="addUser">User Registration</a>
>>>>>>> Stashed changes
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="#">Disabled</a>
		      </li>
		    </ul>
		  </div>
		</nav>

		<br/><br/>
	    <div class="container">
	        <h3 id="form_header" align="center">New User</h3>
	        <div>&nbsp;</div>
	
	        <c:url var="saveUserUrl" value="/saveUser" />
	        <form id="user_form" action="${saveUserUrl}" method="POST">
	        <!-- <form:form action="saveUser" method="post" modelAttribute="user"> -->
	         <!-- <form action="saveUser" th:action="@{/saveUser}" th:object="${user}" method="post"> -->
               <div class="form-group">
	                <label for="name">User Name:</label>
<<<<<<< Updated upstream
	                <input type="text" class="form-control" id="name" placeholder="Enter username" name="name">
	            </div>
	            <div class="form-group">
	                <label for="pwd">Password:</label>
	                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
	            </div>
	            <div class="form-group">
	                <label for="name">Email Address (ID):</label>
	                <input type="text" class="form-control" id="name" placeholder="Enter email address" name="email">
	            </div>
	            <div class="form-group">
	                <label for="pwd">Phone Number:</label>
	                <input type="password" class="form-control" id="pwd" placeholder="Enter telephone number" name="phone">
=======
	                <input type="text" class="form-control" id="name" placeholder="Enter username" name="name" required>
	            </div>
	            <div class="form-group">
	                <label for="pwd">Password:</label>
	                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
	            </div>
	            <div class="form-group">
	                <label for="name">Email Address (ID):</label>
	                <input type="text" class="form-control" id="name" placeholder="Enter email address" name="email" required>
	            </div>
	            <div class="form-group">
	                <label for="pwd">Phone Number:</label>
	                <input type="text" class="form-control" id="pwd" placeholder="Enter telephone number" name="phone" required>
>>>>>>> Stashed changes
	            </div>
	            <div class="form-group">
	                <label for="name">Role:</label>
	                <input type="text" class="form-control" id="name" placeholder="Guest" name="role" disabled>
<<<<<<< Updated upstream
	            </div>            	            
	            <button id="confirm_user" type="submit" class="btn btn-primary">Save</button>
=======
	            </div>    
	            <div align="center">       	            
	            	<button id="confirm_user" type="submit" class="btn btn-primary">Save</button>
	            </div> 
>>>>>>> Stashed changes
	        </form>
	    </div>

</body>
</html>