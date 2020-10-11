package com.download.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String rootPath = System.getProperty("catalina.home");
		//String directoryath = rootPath + "/webapps/srldc/UploadFiles/ftp/WBES_Xml/";
		
		HttpSession session = request.getSession();
		String rootPath = session.getServletContext().getRealPath("/");
		String directoryath = rootPath + "UploadFiles/XmlFile/";
				
		String originalZipname = "webxml.zip";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		/*
		 * String allfile[] = name.split(",");
		 * 
		 * System.out.println(name); System.out.println(Arrays.toString(allfile)); for
		 * (String string : allfile) { System.out.println(string); }
		 */
		//=====================zip====================================//
        String zipFile = directoryath+originalZipname;
        String srcFiles[] = name.split(",");
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
		String filepath = directoryath;
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
