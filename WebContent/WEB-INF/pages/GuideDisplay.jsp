<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
document.getElementById("btnid").onclick = function() {
    //disable
    this.disabled = true;
	
    //do some validation stuff
}
</script>
</head>
<input type="submit" name="displayguideprofile" value="My Profile"/>
<br>
<body>
<h1> The Following Requests are pending ... Reply asap</h1>
	<table>
		
		<tbody>
		
			<tr>
				<td>Tourist Email</td>
				<td></td>
				<td>Date</td>
				<td></td>
				<td>Slot</td>
			</tr>
			<c:forEach var="listitem" items="${requestsList}">
				<tr>
				
					
					<td><c:out value="${listitem.touristEmail}"/></td><td></td>
					<td><c:out value="${listitem.date}"/></td><td></td>
					<td><c:out value="${listitem.slot}"/></td><td></td>
					
					<td>
						<form action="req_accepted">
							<input type="hidden" name="guideEmail"  value=${listitem.guideEmail }>
							<input type="hidden" name="touristEmail"  value=${listitem.touristEmail }>
							<input type="hidden" name="date"  value=${listitem.date }>
							<input type="hidden" name="slot"  value=${listitem.slot }>
							<button type="submit" id="btnid" >Accept</button>
						</form>
					</td>
					
					<td></td>
					
					<td>
						<form action = "req_declined">
							<input type="hidden" name="guideEmail"  value=${listitem.guideEmail }>
							<input type="hidden" name="touristEmail"  value=${listitem.touristEmail }>
							<input type="hidden" name="date"  value=${listitem.date }>
							<input type="hidden" name="slot"  value=${listitem.slot }>
							<button type="submit" id="btnid">Decline</button>
						</form>
					</td>
					
					
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	                               
	
</body>
</html>