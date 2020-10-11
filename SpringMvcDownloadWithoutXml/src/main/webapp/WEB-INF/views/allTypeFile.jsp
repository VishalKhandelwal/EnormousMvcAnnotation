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
<button id="download">Download</button>
<table id="example" class="display" style="width:100%">
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
										<td>${fileDatalist.fileName }</td>							
										<td>${fileDatalist.creationTime }</td>
										<td>${fileDatalist.fileSize }</td>
									</tr>
								</c:forEach>

							</tbody>
    </table>
<form method="post" id="downloadThis">
	<input type="hidden" name="zippath" id="zippath" />
	<input type="hidden" name="zipname" id="zipname" />
</form>
</body>
<script>
$(document).ready(function() {
    $('#example').DataTable();

     <%-------------------- use for download ---------------------------------------%>
		//Assign Click event to Button.
        $("#download").click(function () {
            var message = " ";
            var filesForDownload = [];
            //Loop through all checked CheckBoxes in GridView.
            $("#example input[type=checkbox]:checked").each(function () {
            	var row = $(this).closest("tr")[0];
                message += $(this).val();
                message += "   " + row.cells[0].innerHTML;
                message += "\n";
              filesForDownload.push($(this).val());
              $(this).prop('checked', false);
            });
 
            if (filesForDownload.length>0){
                $("#zippath").val(filesForDownload);
                $("#zipname").val("allType.zip");
            	document.getElementById("downloadThis").action = "allFileDownload";
            	document.getElementById("downloadThis").method = "post";
            	document.getElementById("downloadThis").submit();
                }
                
              
            });
       <%--------------------end download ---------------------------------------%>
} );
</script>
</html>