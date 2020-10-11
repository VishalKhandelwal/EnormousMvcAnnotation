<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Enrollment Detail Confirmation</title>
<link rel="stylesheet" type="text/css" href='<c:url value="static/css/MyStyle.css"/>'>
</head>
<body>
<div class="success">
		Confirmation message : ${success}
		<br>
		We have also sent you a confirmation mail to your email address : ${student.email}.
	</div>
</body>
</html>