<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Guide</title>
<script type="text/javascript">

	function isOneChecked() {
	  
	  var chx = document.getElementsByTagName('input');
	  for (var i=0; i<chx.length; i++) {
	    
	    if (chx[i].type == 'radio' && chx[i].checked) {
	      return true;
	    } 
	  }
	  alert("Please check atleast one checkbox");
	  return false;
	}
</script>
</head>
<body>
	<section >		
		<div >
			<div >
				<h3> <c:out  value="${baba.name}" /></h3>
				<p>I am Govt. approved tourist Guide. I am familiar with all the major tourist destinations in <c:out  value="${baba.city}"/>. </p>
			</div>
			<table>
				<tbody>
					<tr>
						<td>
							<div >
								<h3>General Info</h3>
								<ul>
									<li><span>Hobbies : </span><c:out  value="${baba.hobby}" /></li>
									<li><span>E-mail : </span><c:out  value="${baba.email}" /></li>
									<li><span>Phone : </span><c:out  value="${baba.phone}" /></li>
									<li><span>Places : </span><c:out  value="${baba.places}" /></li>
									<li><span>City : </span><c:out  value="${baba.city}" /></li>
									<li><span>Fee : </span><c:out  value="${baba.fee}" />$ per hour</li>
									
									
									
									<li><span>languages : </span>
									
								    <c:forEach var="baa" items="${baba.languages}">
										<c:out value="${baa}"/>			                                  
									</c:forEach>
									
									</li>
									<br>
									<li><span>Check Availability</span>
									
								   	<form action="check_free_slots" onSubmit="isOneChecked(this)">
								   			<input type="radio" id="today" name="day" value="today">
										    <label for="today">Today</label><br>
										    <input type="radio" id="tmrw" name="day" value="tmrw">
										    <label for="tmrw">Tomorrow</label><br>
										    <input type="radio" id="tmrww" name="day" value="tmrww">
										    <label for="tmrww">Day After Tomorrow</label><br><br>
										    <input type="hidden" name ="email" value=${baba.email }>
										    <input type="submit" value="Check">
								   		
								   	</form>
								   	
									
									</li>
									
									<%-- <li><span>Available at time slot : </span>
									<br>
								    <c:forEach var="baa" items="${baba.freeslots}">
										<c:out value="${baa}"/><br>	                                  
									</c:forEach>
									
									</li> --%>
									
									
									
								</ul>
							</div>

						</td>
						<td>

							<div >
								<figure >
									<img src="assets/img/hacker_img.jpg" alt="Guide">
								</figure>
							</div>


						</td>

					</tr>
					
				</tbody>
				

			</table>
		</div>
	
	</section>
	

	
	

</body>
</html>