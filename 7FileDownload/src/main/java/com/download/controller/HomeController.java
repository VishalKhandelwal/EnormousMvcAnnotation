package com.download.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.download.model.FileData;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping(value="index")
	public String index(HttpSession session,Model model) throws IOException
	{
		String rootPath = session.getServletContext().getRealPath("/");
		String FolderPath = "UploadFiles/XmlFile/";
		String directoryath = rootPath + FolderPath;
		File file = new File(directoryath);
		List<String> list = Arrays.asList(file.list());
		List<FileData> fileData = new ArrayList<FileData>();
		for (String filedetail : list) {
			// creation date
			Path filePath = new File(directoryath + filedetail).toPath();
			BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
			Date creationDate = new Date(attr.creationTime().to(TimeUnit.MILLISECONDS));
			LocalDateTime cdt = LocalDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String creationformatDateTime = cdt.format(format);

			Long fileSize = new File(directoryath + filedetail).length();
			fileData.add(new FileData(filedetail, creationformatDateTime, fileSize, directoryath));
		}
		
		fileData.forEach(System.out::println);
		model.addAttribute("fileDatalist", fileData);
		model.addAttribute("folderName", FolderPath);	
		return "index";
	}
	
	@RequestMapping(value="datatableExample")
	public String dataTable(HttpSession session,Model model) throws IOException {
		String rootPath = session.getServletContext().getRealPath("/");
		String FolderPath = "UploadFiles/XmlFile/";
		String directoryath = rootPath + FolderPath;
		File file = new File(directoryath);
		List<String> list = Arrays.asList(file.list());
		List<FileData> fileData = new ArrayList<FileData>();
		for (String filedetail : list) {
			// creation date
			Path filePath = new File(directoryath + filedetail).toPath();
			BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
			Date creationDate = new Date(attr.creationTime().to(TimeUnit.MILLISECONDS));
			LocalDateTime cdt = LocalDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String creationformatDateTime = cdt.format(format);

			Long fileSize = new File(directoryath + filedetail).length();
			fileData.add(new FileData(filedetail, creationformatDateTime, fileSize, directoryath));
		}
		
		fileData.forEach(System.out::println);
		model.addAttribute("fileDatalist", fileData);
		model.addAttribute("folderName", FolderPath);	
		return "datatableExample";
	}
	
	@RequestMapping(value="csvFileExample")
	public String csvFileExample(HttpSession session,Model model) throws IOException {
		String rootPath = session.getServletContext().getRealPath("/");
		String FolderPath = "UploadFiles/CsvFile/";
		String directoryath = rootPath + FolderPath;
		File file = new File(directoryath);
		List<String> list = Arrays.asList(file.list());
		List<FileData> fileData = new ArrayList<FileData>();
		for (String filedetail : list) {
			// creation date
			Path filePath = new File(directoryath + filedetail).toPath();
			BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
			Date creationDate = new Date(attr.creationTime().to(TimeUnit.MILLISECONDS));
			LocalDateTime cdt = LocalDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String creationformatDateTime = cdt.format(format);

			Long fileSize = new File(directoryath + filedetail).length();
			fileData.add(new FileData(filedetail, creationformatDateTime, fileSize, directoryath));
		}
		
		fileData.forEach(System.out::println);
		model.addAttribute("fileDatalist", fileData);
		model.addAttribute("folderName", FolderPath);	
		return "csvFile";
	}
	
	@RequestMapping(value="xmlFileExample")
	public String xmlFileExample(HttpSession session,Model model) throws IOException {
		String rootPath = session.getServletContext().getRealPath("/");
		String FolderPath = "UploadFiles/XmlFile/";
		String directoryath = rootPath + FolderPath;
		File file = new File(directoryath);
		List<String> list = Arrays.asList(file.list());
		List<FileData> fileData = new ArrayList<FileData>();
		for (String filedetail : list) {
			// creation date
			Path filePath = new File(directoryath + filedetail).toPath();
			BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
			Date creationDate = new Date(attr.creationTime().to(TimeUnit.MILLISECONDS));
			LocalDateTime cdt = LocalDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String creationformatDateTime = cdt.format(format);

			Long fileSize = new File(directoryath + filedetail).length();
			fileData.add(new FileData(filedetail, creationformatDateTime, fileSize, directoryath));
		}
		
		fileData.forEach(System.out::println);
		model.addAttribute("fileDatalist", fileData);
		model.addAttribute("folderName", FolderPath);	
		return "xmlFile";
	}
	
	@RequestMapping(value="allTypeFileExample")
	public String allTypeFileExample(HttpSession session,Model model) throws IOException {
		String rootPath = session.getServletContext().getRealPath("/");
		String FolderPath = "UploadFiles/AllType/";
		String directoryath = rootPath + FolderPath;
		File file = new File(directoryath);
		List<String> list = Arrays.asList(file.list());
		List<FileData> fileData = new ArrayList<FileData>();
		for (String filedetail : list) {
			// creation date
			Path filePath = new File(directoryath + filedetail).toPath();
			BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
			Date creationDate = new Date(attr.creationTime().to(TimeUnit.MILLISECONDS));
			LocalDateTime cdt = LocalDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String creationformatDateTime = cdt.format(format);

			Long fileSize = new File(directoryath + filedetail).length();
			fileData.add(new FileData(filedetail, creationformatDateTime, fileSize, directoryath));
		}
		
		fileData.forEach(System.out::println);
		model.addAttribute("fileDatalist", fileData);
		model.addAttribute("folderName", FolderPath);	
		return "allTypeFile";
	}
	
	@RequestMapping(value = "/javaDownloadExample", method = RequestMethod.GET)
	public String futureTransaction(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	    try {
	    	String rootPath = session.getServletContext().getRealPath("/");
			  
			 
			 String filepath =	"UploadFiles/AllType/020620rev.txt";
		     File file = new File(rootPath+filepath);	
		     
		     if(file.exists()) {
	        
	        InputStream in = new BufferedInputStream(new FileInputStream(file));

	        response.setContentType("APPLICATION/OCTET-STREAM");
	        response.setHeader("Content-Disposition", "attachment; filename="+ file.getName()); 


	        ServletOutputStream out = response.getOutputStream();
	        IOUtils.copy(in, out);
	        response.flushBuffer();
	        return null;
		     }
		     else {
		    	 return "redirect:/";
		     }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/";
	    }
	}
	
	
}
