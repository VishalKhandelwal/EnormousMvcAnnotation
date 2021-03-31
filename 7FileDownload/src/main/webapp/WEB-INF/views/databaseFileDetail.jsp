<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
</head>
<body>
<table id="example" class="display" style="width:100%">
        <thead>
								<tr>								    
								    <!-- <th>Select</th> -->
								    <th>Id</th>
									<th>File Name</th>
									<th>Content Type or Mime Type</th>
									<th>File Data in Bytes</th>	
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="fileDetailList" items="${fileDetailList}">
								    <tr>
								       <%-- <td><input type="checkbox" id="myCheck" value="${fileDetailList.filePath}"></td> --%>	
								        <td>${fileDetailList.id}</td>						
										<td>${fileDetailList.fileName}</td>							
										<td>${fileDetailList.fileType }</td>
										<td>${fileDetailList.data }</td>
										<td><a href="download-document/${fileDetailList.id}">Download</a></td>
									</tr>
								</c:forEach>

							</tbody>
    </table>
</body>
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</html>