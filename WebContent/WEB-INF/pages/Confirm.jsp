<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function goBack() {
  window.history.back();
}
</script>
</head>
<body>
<h1>Guide has been requested</h1>
<h3>Date :<c:out value="${date}"/></h3>
<h3>Time :<c:out value="${slot}"/></h3>
<button onclick="goBack()">Go Back</button>
</body>
</html>