<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
							<thead>
								<tr>								    
								    <th>Select</th>
									<th>File Name</th>
									<th>Creation Date</th>
									<th>File Size</th>	
								</tr>
							</thead>
							<tbody>
								<c:forEach var="fileDatalist" items="${fileDatalist}">
								    <tr>
								    <td><input type="checkbox" id="myCheck" value="${folderName }${fileDatalist.fileName }"></td>							
										<td><a href="${folderName }${fileDatalist.fileName }" download>${fileDatalist.fileName }</a></td>							
										<td>${fileDatalist.creationTime }</td>
										<td>${fileDatalist.fileSize }</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
</body>
</html>