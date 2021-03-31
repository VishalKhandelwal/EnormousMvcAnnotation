<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:green;">${filesuccess}</h3>  
	<form action="saveMultipleFile" method="post"
		enctype="multipart/form-data">
		Select File: <input type="file" name="files" multiple="multiple"/>
		 <input type="submit" value="Upload File" />
	</form>
</body>
</html>