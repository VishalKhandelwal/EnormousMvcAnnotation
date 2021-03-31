package com.download.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadRestController {

	//Use for ajax
	@RequestMapping(value="/allFileDownload",method = RequestMethod.POST)
	   public String regulationAndProcedureList( @RequestParam(value="zippath", required=true) String zippath,@RequestParam(value="zipname", required=true) String zipname,HttpServletResponse response,HttpSession session) throws IOException{
		
		String rootPath = session.getServletContext().getRealPath("/");
		//String directoryath = rootPath +"UploadFiles/ftp/WBES_Xml/";
		String directoryath = rootPath;
		String originalZipname = zipname;
		System.out.println(zippath);
		
		PrintWriter out = response.getWriter();			
		/*
		 * String allfile[] = name.split(",");
		 * 
		 * System.out.println(name); System.out.println(Arrays.toString(allfile)); for
		 * (String string : allfile) { System.out.println(string); }
		 */
		//=====================zip====================================//
        //String zipFile = directoryath+originalZipname;
		File dir = new File(directoryath+"UploadFiles/ZipFileData/");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		 String zipFile = directoryath+"UploadFiles/ZipFileData/"+originalZipname;
        String srcFiles[] = zippath.split(",");
		//String[] srcFiles = { "C:\\Users\\user\\Desktop\\XML\\FullSchedule-(76)-15-06-2020.xml", "C:\\Users\\user\\Desktop\\XML\\FullSchedule-(80)-15-06-2020.xml", "C:\\Users\\user\\Desktop\\XML\\FullSchedule-14-06-2020.xml"};
		
		try {
			
			// create byte buffer
			byte[] buffer = new byte[1024];

			FileOutputStream fos = new FileOutputStream(zipFile);

			ZipOutputStream zos = new ZipOutputStream(fos);
			
			for (int i=0; i < srcFiles.length; i++) {
				
				File srcFile = new File(directoryath+srcFiles[i]);

				FileInputStream fis = new FileInputStream(srcFile);

				// begin writing a new ZIP entry, positions the stream to the start of the entry data
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				
				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}

				zos.closeEntry();

				// close the InputStream
				fis.close();
				
			}

			// close the ZipOutputStream
			zos.close();
			
		}
		catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
		}
		
		//download
		String filename = originalZipname;
		String filepath = directoryath+"UploadFiles/ZipFileData/";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");  
		
		File file = new File(filepath + filename);
		FileInputStream fileInputStream = new FileInputStream(file);  
        
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();  
		file.delete();
		out.close();   	
	    return null;
	   }
}
