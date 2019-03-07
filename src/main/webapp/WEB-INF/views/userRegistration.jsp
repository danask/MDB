<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	    
	    <title>User Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	    <style>
	    	li:nth-of-type(4){margin-left: 25em;}
		</style>
	
	<body>
		
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="home"><strong>MIS</strong></a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
<!-- 		      <li class="nav-item active">
		        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
		      </li> -->
			  <li class="nav-item">
		        <a class="nav-link" href="listMovie">Movie List</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="addMovie">Movie Database</a>
		      </li>     
		      <li class="nav-item">
		        <a class="nav-link" href="addUser">User Registration</a>
		      </li>	
		       		        
		      <li class="nav-item">
		        <a class="nav-link" href="#">Admin</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="listUser">Users</a>
		      </li>	 
		      <li class="nav-item">
		        <a class="nav-link" href="/">Log out</a>
		      </li>
		    </ul>
		  </div>
		</nav>


		<br/><br/>
	    <div class="container">
	        <h3 id="form_header" align="center">User Registration</h3>
	        <div>&nbsp;</div>
	
        	<c:url var="saveUserUrl" value="/saveUser" />
 	        <form id="user_form" action="${saveUserUrl}" method="POST">
	     <!--    <form:form action="saveUser" method="post" modelAttribute="user">
	         <div class="form-group"><label for="name">User Name:</label>
	        <form:input path="name" /> 
	        </div>-->

			   <input type="hidden" name="id" value='${user.id}'/>
               <div class="form-group">
	                <label for="name">User Name:</label>
	                <input type="text" class="form-control" id="name" placeholder="Enter username" name="name" 
	                value='${user.name}' required/>
	            </div>
	            <div class="form-group">
	                <label for="pwd">Password:</label>
	                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" 
	                value='${user.password}'required>
	            </div>
	            <div class="form-group">
	                <label for="name">Email Address (ID):</label>
	                <input type="text" class="form-control" id="email" placeholder="Enter email address" name="email" 
	                value='${user.email}'required>
	            </div>
	            <div class="form-group">
	                <label for="pwd">Phone Number:</label>
	                <input type="text" class="form-control" id="phone" placeholder="Enter telephone number" name="phone" 
	                value='${user.phone}'required>
	            </div>
	            <div class="form-group">
	                <label for="name">Role:</label>
	                <input type="text" class="form-control" id="role" placeholder="Guest" name="role" 
	                value='${user.role}'disabled>
	            </div>  
	            
	            
	              
	            <div align="center">       	            
	            	<button id="confirm_user" type="submit" class="btn btn-dark">Save</button>
	            </div>  
	        <!-- </form:form> -->
	    </div>
	         <!-- <form action="saveUser" th:action="@{/saveUser}" th:object="${user}" method="post"> -->
	</body>
</html>