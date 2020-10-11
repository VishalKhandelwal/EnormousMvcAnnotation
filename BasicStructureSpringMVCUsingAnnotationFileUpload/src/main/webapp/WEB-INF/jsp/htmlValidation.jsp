<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: green;">${filesuccess}</h3>
	<form action="savehtmlValidation" method="post"
		enctype="multipart/form-data">
		Select File: <input type="file" name="file"
			accept="application/pdf,text/html,application/zip,text/plain,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/jpeg,image/png,image/gif" />
		<input type="submit" value="Upload File" />
	</form>
</body>
</html>