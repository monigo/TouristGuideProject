<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script>document.getElementsByTagName("html")[0].className += " js";</script>
  
  <link rel="stylesheet" href="assets/css/style.css">
  
		<style>
		   .overflowproperty{
		   background-color: white;
			  width: 800px;
			  height: 410px;
			  overflow: scroll;
			  margin-left : 235px;
		   }
		  .wrapper{
		      display:grid;
		      grid-template-columns:repeat(3, 1fr);
		      grid-gap:1em;
		      grid-auto-rows:325px;
		      margin: 50px 50px 50px 50px;
		      
		    }
		
		    .wrapper > div{
		      background:#eee;
		      padding:1em;
		    }
		    .wrapper > div:nth-child(odd){
		      background:#ddd;
		
		    }
		
		    .card {
		    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
		    max-width: 200px;
		    max-height: 325px;
		    margin:auto ;
		    text-align: center;
		    font-family: arial;
		    }
		
		    .title {
		    color: black;
		    font-size: 13px;
		    }
		    .myclass {
		    color: black;
		    font-size: 17px;
		    
		    }
		    .cd-content-wrapper {
			  background-image: url("https://www.brisbanetreeexperts.com.au/wp-content/uploads/home-header-bg-1.png");
			  background-color: #cccccc;
			  height: 100%;
			  background-position: center;
			  background-repeat: no-repeat;
			  background-size: cover;
			  position: relative;
			}
		    button {
		    border: none;
		    outline: 0;
		    display: inline-block;
		    padding: 8px;
		    color: white;
		    background-color: rgb(173, 134, 180);
		    text-align: center;
		    cursor: pointer;
		    width: 70%;
		    font-size: 12px;
		    }
		
		
		    button:hover, a:hover {
		    opacity: 0.7;
		    }
		    
		    
		  
		    
		    
		    /* css for horizontal scroll image */
		   
  			.slider {
		      width: 70%;
		      height: 500px;
		      margin: 20px auto;
		      box-sizing: border-box;
		      overflow: hidden;
		      margin-left : 195px;
		
		    }
		
		    img {
		      width: 100%;
		      height: 100%;
		      animation: ani 2s linear;
		
		    }
		
		    @keyframes ani {
		      0% {
		        transform: scale(1.2);
		      }
		      10% {
		        transform: scale(1);
		      }
		      100% {
		        transform: scale(1);
		      }
		    }
  	
			</style>
		<!-- script for horizontal scroll -->
		<script>
		
	    
		</script>
			
</head>
<body>
		
		
		
		<header class="cd-main-header js-cd-main-header">
	    <div class="cd-logo-wrapper">
	      <a href="#0" class="cd-logo"><img src="assets/img/cd-logo.svg" alt="Logo"></a>
	     
	    </div>
	    
	    <div class="cd-search js-cd-search">
	      <form >
	        <input class="reset" type="search" placeholder="Search...">
	        
	      </form>
	      
	    </div>
	
	   
	    <button class="reset cd-nav-trigger js-cd-nav-trigger" aria-label="Toggle menu"><span></span></button>
	  
	    <ul class="cd-nav__list js-cd-nav__list">
	      
	      <li class="cd-nav__item cd-nav__item--has-children cd-nav__item--account js-cd-item--has-children">
	        <a href="#0">
	          <img src="assets/img/hacker_img.jpg" alt="avatar">
	          <span>Account</span>
	        </a>
	    
	        <ul class="cd-nav__sub-list">
	          
			  
			  <li class="cd-nav__sub-item"><a href="#0">My Account</a></li>
              <li class="cd-nav__sub-item"><a href="#0">Edit Account</a></li>
              <li class="cd-nav__sub-item"><a href="#0">Logout</a></li>
				
	          
	        </ul>
	      </li>
	    </ul>
	  </header> <!-- .cd-main-header -->
	  
	  <main class="cd-main-content">
	    <nav class="cd-side-nav js-cd-side-nav">
	        <ul class="cd-side__list js-cd-side__list">
	            <li class="cd-side__item cd-side__item--has-children cd-side__item--overview js-cd-item--has-children">
	            <a href="#0">About</a>
	            
	            
	            </li>
	
	            
	        
	            
	        </ul>
	        
	        <ul class="cd-side__list js-cd-side__list">
	            <li class="cd-side__item cd-side__item--has-children cd-side__item--bookmarks js-cd-item--has-children">
	            <a href="#0">Popular</a>
	            </li>
	
	            <li class="cd-side__item cd-side__item--has-children cd-side__item--images js-cd-item--has-children">
	            <a href="#0">Images</a>
	            </li>
	        
	            <li class="cd-side__item cd-side__item--has-children cd-side__item--users js-cd-item--has-children">
	            <a href="#0">Things To Do</a>
	            </li>
				<li class="cd-side__item cd-side__item--has-children cd-side__item--comments js-cd-item--has-children">
	            <a href="<s:url value="/guide_signup"/>">Signup as Guide</a>
	            
	            </li>
	            <li class="cd-side__item cd-side__item--has-children cd-side__item--comments js-cd-item--has-children">
	            <a href="<s:url value="/guide_login"/>">Login as Guide</a>
	            
	            </li>
	        </ul>
	        
	        </nav>
	   
	    <div class="cd-content-wrapper">
	     <div style="margin-left:100px;margin-up:10px;">Welcome <c:out value="${username}" /> !!!</div>
	      <div class="text-component text-center">
	      <h1 style="text-align:center ;color:pink">Guides Near You</h1>
	      <br>
	       
	        
	        <div class="overflowproperty">
	
	                <div class="wrapper">
	
	                      
	                        <c:forEach var="guide" items="${guidelist}">
	                        
	                        
	                        		<div class='card'>
	                        			<form action="show_guide">
			                                  <img src='assets/img/hacker_img.jpg' alt='John' style='width:100%'>
			                                  <input type="hidden" name ="name" value=${guide.name }>
			                                  <h6 class='myclass' style="padding:7px;"  ><c:out  value="${guide.name}" /></h6>
			                                  <p class='title' >City : <c:out value="${guide.city}"/></p>
			                                  <p class='title'>Fee : <c:out value="${guide.fee}"/> $/hour</p>
			                                  <input type="hidden" name ="email" value=${guide.email }>
			                                  <button type = "submit">Contact</button>
		                                </form>  
		                        	</div>
	                        
		                        
	                        </c:forEach>
	                        
	                        
	                        
	                        
	                </div>
	
	
	            
	
	        </div>
	        
	        
	      </div>
	      <!-- ye upar input type hidden kiya h na vo email and name attribute ko save krne ke liye h taki jb contact button press kre to email and name request parameter me chla jaye -->
	      <!--image view div  -->
	      <br>
	      <h1 style="text-align:center ;color:orange">Tourist Destination</h1>
	      <br>
	      <div class="slider">

			    <div id="img">
			      <img src="e.jpg">
			    </div>
			
			  </div>
			
			  <script>
			
			    var images = ['i2.jpg', 'i2.jpg', 'i3.jpg', 'i4.jpg', 'i5.jpg'];
			
			    var x = 0;
			
			    var imgs = document.getElementById('img');
			
			    setInterval(slider, 2000);
			
			
			    function slider() {
			
			      if (x < images.length) {
			        x = x + 1;
			      } else {
			        x = 1;
			      }
			
			
			      imgs.innerHTML = "<img src=assets/img/" + images[x - 1] + ">";
			
			
			    }
			
			
			  </script>


  
	      <!--  -->
	      
	    </div> <!-- .content-wrapper -->
	    
	  </main> <!-- .cd-main-content -->
	  <script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
	  <script src="assets/js/menu-aim.js"></script>
	  <script src="assets/js/main.js"></script>
</body>
</html>