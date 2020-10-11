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
</body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.5.0/jszip.js">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.8/FileSaver.js"></script>
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
            message += "   " + row.cells[1].innerHTML;
            message += "\n";
          filesForDownload.push( { path: $(this).val(), name: row.cells[1].innerHTML } );
        });

        //Display selected Row data in Alert Box.
      //  alert(message);
      //  alert(filesForDownload);
      console.log(filesForDownload);
      if (filesForDownload.length>0){
        var temporaryDownloadLink = document.createElement("a");
	    temporaryDownloadLink.style.display = 'none';

	    document.body.appendChild( temporaryDownloadLink );
	    var zip = new JSZip();
	    var folder = zip.folder("webrevision");
	    for( var n = 0; n < filesForDownload.length; n++ )
	    {
	        var download = filesForDownload[n];
	        var promise = $.get(download.path);
	        folder.file(download.name, promise);
	       // temporaryDownloadLink.setAttribute( 'href', download.path );
	      //  temporaryDownloadLink.setAttribute( 'download', download.name );

	        temporaryDownloadLink.click();
	    }
	    zip.generateAsync({type:"blob"})
        .then(function(content) {
         //see FileSaver.js
         saveAs(content, "webrevision.zip");
});
	    document.body.removeChild( temporaryDownloadLink );
        return false;
      }
    });
    <%--------------------end download ---------------------------------------%>
} );
</script>
</html>