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
	<form action="savejQueryValidation" method="post"
		enctype="multipart/form-data" id="form">
		Select File: <input type="file" name="file"/>
		<input type="submit" value="Upload File" />
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/additional-methods.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	
	$("#form").validate({
		             rules : {
		                	  file : {
									required : true,
									extension: "pdf|html|htm|zip|txt|doc|docx|xls|xlsx|jpg|jpeg|png|gif",
									accept: "application/pdf,text/html,application/zip,application/x-zip-compressed,text/plain,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/jpeg,image/png,image/gif"
								}							
							},
					messages : {
						file : {
							required : "Please Upload File",
							extension:"select only pdf,html,htm,txt,doc,docx,zip,xls,xlsx,jpg,jpeg,png,gif input file format",
							accept:"upload Only pdf,html,htm,txt,doc,docx,zip,xls,xlsx,jpg,jpeg,png,gif file"
						}
					}
	}); 
});
	</script>
</body>
</html>