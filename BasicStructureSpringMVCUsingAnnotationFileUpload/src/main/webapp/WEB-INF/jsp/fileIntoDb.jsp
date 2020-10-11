<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:green;">${filesuccess}</h3>  
	<form:form method="post" action="saveFileInDb" modelAttribute="fileDetailObj" enctype="multipart/form-data">
		Select File: <input type="file" name="file" />
		 <input type="submit" value="Upload File" />
	</form:form>
</body>
</html>