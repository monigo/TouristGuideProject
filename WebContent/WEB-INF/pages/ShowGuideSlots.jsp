<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
	
			
</head>
<body>
	
		                                  
	<h2>Guide has these free slots :
    </h2><br>
	
	<c:forEach var="slot" items="${slts} ">
		<c:out value="${slot}"/><br>		                                  
	</c:forEach> 
	
	<br>
	
	
	<form action="handle_booking_and_mail" method="POST">
					<h3>Enter the slot for which you want to request the guide</h3>
					<input type="text" name ="choosenslot" />									
			
					<h2>Contact Me</h2>
					
					<input type="text" name="msg_to_guide"/>
					<br>
					<br>
					<button>Request</button>
	
	</form>
	
	
</body>
</html>