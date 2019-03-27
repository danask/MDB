<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String role = (String)request.getAttribute("sessionInfo"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Management</title>
</head>
<body>

	<head>	    
	    <title>Movie Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	    <style>
	    	#list {
			    margin-left: 2em;
			    margin-right: 2em;
			}
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
					  <a class="nav-link" href="searchMovie">Search</a>
					</li> 			      
		      
   			   <%if(role.equals("Movie Database Administrator")	|| role.equals("Administrator")){%>
   			   
				  <li class="nav-item">
			        <a class="nav-link" href="listMovie">Movie List</a>
			      </li>   			   
			      <li class="nav-item">
			        <a class="nav-link" href="addMovie">Movie Database</a>
			      </li>  
		       <%}%>
	       			         
		      <li class="nav-item">
		        <a class="nav-link" href="addUser">User Registration</a>
		      </li>	
		       		
			   <%if(role.equals("Administrator")){%>
		      	  <li class="nav-item">
			        <a class="nav-link" href="listRole">Admin</a>
			      </li>
		       <%}%>
			   
			   <%if(role.equals("User Manager")	|| role.equals("Administrator")){%>			   
			      <li class="nav-item">
			        <a class="nav-link" href="listUser">Users</a>
			      </li>	 
			   <%}%>
		       		        
		      <li class="nav-item">
		        <a class="nav-link" href="/">Log out</a>
		      </li>
		    </ul>
		  </div>
		</nav>

		<br/><br/>
		<div id="list">
			<div class="containter">
				
				<h3 id="form_header" align="center">Movie List</h3>
		        <div>&nbsp;</div>		
		        <!-- h2>
		            <a href="movieManagement">Movie List</a>
		        </h2-->
		        
		        <c:if test="${!empty listMovie }">
			        <table class="table table-striped">
			 
			 			<th>ID</th>
			            <th>Title</th>
			            <th>Aritist</th>
			            <th>Released Year</th>
			            <th>Description</th>
			            <th></th>
			             
			            <c:forEach var="movie" items="${listMovie}">
			                <tr>
			                    <td>${movie.id}</td>
			                    <td>${movie.movieTitle}</td>
			                    <td>${movie.movieArtist}</td>
			                    <td>${movie.year}</td>
			                    <td>${movie.description}</td>
		 						<td><a href="editMovie?id=${movie.id}">Edit</a>&nbsp;&nbsp;
			                      <a href="deleteMovie?id=${movie.id}">Delete</a></td>
			                </tr>
			            </c:forEach>
			        </table>
			    </c:if>
		    </div>
		</div>
	</div>
</body>
</html>