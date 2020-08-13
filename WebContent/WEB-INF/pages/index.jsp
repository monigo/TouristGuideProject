<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style>
	  /* Remove the navbar's default margin-bottom and rounded borders */ 
	  .navbar {
	    margin-bottom: 0;
	    border-radius: 0;
	  }
	  
	  /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
	  .row.content {height: 450px}
	  
	  /* Set gray background color and 100% height */
	  .sidenav {
	    padding-top: 20px;
	    background-color: #f1f1f1;
	    height: 100%;
	  }
	  
	  /* Set black background color, white text and some padding */
	  footer {
	    background-color: #555;
	    color: white;
	    padding: 15px;
	  }
	  
	  /* On small screens, set height to 'auto' for sidenav and grid */
	  @media screen and (max-width: 767px) {
	    .sidenav {
	      height: auto;
	      padding: 15px;
	    }
	    .row.content {height:auto;} 
	  }
	</style>
</head>

<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">HOME</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	      
	        <li class="active"><a href="<s:url value="/get_login_page"/>">Login</a></li>
	        <li><a href="<s:url value="/get_signup_page"/>">SignUp</a></li>
	     
	     
	        <li><a href="https://www.facebook.com">ABOUT</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="https://www.facebook.com"><span class="glyphicon glyphicon-log-in"></span> CONTACT</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
  
	<div class="container-fluid text-center">    
	  <div class="row content">
	    <div class="col-sm-2 sidenav">
	      <p><a href="#"></a></p>
	      <p><a href="#"></a></p>
	      <p><a href="#"></a></p>
	    </div>
	    <div class="col-sm-8 text-left"> 
	      <h1>Welcome</h1>
	      <p>Tourism in India has shown a phenomenal growth in the past decade. One of the reasons is that the Ministry of tourism, India has realized the immense potential of tourism in India during vacations. India travel tourism has grown rapidly with a great influx of tourists from all across the globe who have been irresistibly attracted to the rich culture, heritage, and incredible natural beauty of India.</p>
	      <hr>
	      <h3>About</h3>
	      <p>This portal will help you finding nearby guides for various tourist places to make your journey much comfortable.</p>
	    </div>
	    <div class="col-sm-2 sidenav">
	      <div class="well">
	        <p>A</p>
	      </div>
	      <div class="well">
	        <p>A</p>
	      </div>
	    </div>
	    
	  </div>
	</div>
	<br>
    <br>
    <br>
    <br>
    <br>
    
    
   
	<footer class="container-fluid text-center">
	  <p>You Are Warmly Welcome Here Every Time. </p>
	</footer>
</body>
</html>