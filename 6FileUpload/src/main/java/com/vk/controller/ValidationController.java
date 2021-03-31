package com.vk.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vk.model.FileManager;
import com.vk.service.FileManagerService;

@Controller
public class ValidationController {
	private static final String UPLOAD_DIRECTORY ="/Upload";
	
	
	//********************************************HTML Validation*******************
	@RequestMapping("htmlValidation")  
    public ModelAndView singleFileUpload(){  
        return new ModelAndView("htmlValidation");    
    }  
	
	
	
	@RequestMapping(value = "/savehtmlValidation", method = RequestMethod.POST)
	public ModelAndView saveSingleFile(@RequestParam CommonsMultipartFile file,HttpSession session) throws Exception
	{
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY+File.separator+"AllTypeFile");  
	    System.out.println("path");
	    String filename = file.getOriginalFilename();  
	  
	    File dir = new File(path);
	    if(!dir.exists())
	    {
	    	boolean bool = dir.mkdirs();
	        if(bool){
	           System.out.println("Directory created successfully");
	        }else{
	           System.out.println("Sorry couldn’t create specified directory");
	        }
	    }
	    
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return new ModelAndView("htmlValidation","filesuccess","File successfully saved!");  
	}
	
	//*********************************JQUERY Validation*******************
	@RequestMapping("jQueryValidation")  
    public ModelAndView jQueryValidation(){  
        return new ModelAndView("jQueryValidation");    
    }  
	
	
	
	@RequestMapping(value = "/savejQueryValidation", method = RequestMethod.POST)
	public ModelAndView jQueryValidation(@RequestParam CommonsMultipartFile file,HttpSession session) throws Exception
	{
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY+File.separator+"AllTypeFile");  
	    System.out.println("path");
	    String filename = file.getOriginalFilename();  
	  
	    File dir = new File(path);
	    if(!dir.exists())
	    {
	    	boolean bool = dir.mkdirs();
	        if(bool){
	           System.out.println("Directory created successfully");
	        }else{
	           System.out.println("Sorry couldn’t create specified directory");
	        }
	    }
	    
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return new ModelAndView("jQueryValidation","filesuccess","File successfully saved!");  
	}
	
	//*********************************Server Side Validation*******************
	@Autowired
	FileManagerService fileManagerService;
	
	@RequestMapping(value = "/addFileManager", method = RequestMethod.GET)
	public ModelAndView addFileManager(Model model, HttpServletRequest req, HttpServletResponse response) {	
		
			model.addAttribute("fileManagerObj", new FileManager());			
			return new ModelAndView("fileIntoDbWithValidation");
		

	}
	
	@RequestMapping(value = "saveFileManager", method = RequestMethod.POST)
	public ModelAndView saveFileManager(@ModelAttribute("fileManagerObj") FileManager fileManagerObject,Model model, HttpSession session,RedirectAttributes redirectAttributes)
			throws Exception {

		System.out.println(!fileManagerObject.getFile().isEmpty() + " " + (fileManagerObject.getFile().getSize() > 0));
		if ((!(fileManagerObject.getFile().isEmpty())) && (fileManagerObject.getFile().getSize() > 0)) {			
				
				String contentType = fileManagerObject.getFile().getContentType();
				System.out.println(contentType);
				// ==============================================================//

				if (contentType.equals("application/pdf") | contentType.equals("text/html") | contentType.equals("application/x-zip-compressed")
						| contentType.equals("text/plain") | contentType.equals("application/msword") | contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
						| contentType.equals("application/vnd.ms-excel") | contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")| contentType.equals("image/jpeg")
						| contentType.equals("image/png") | contentType.equals("image/gif")) {

				/*
				 * String rootPath = System.getProperty("catalina.home"); String originalPath =
				 * rootPath + "\\webapps\\srldc\\UploadFiles\\FileManager\\";
				 */
					ServletContext context = session.getServletContext();  
					String originalPath = context.getRealPath(UPLOAD_DIRECTORY+File.separator+"AllTypeFile"); 

					File dir = new File(originalPath);
					if (!dir.exists()) {
						dir.mkdirs();
					}

					Random rand = new Random();
					int num = rand.nextInt(9000000) + 1000000;

					String filename = num + "-" + fileManagerObject.getFile().getOriginalFilename();
					System.out.println(originalPath + " " + filename);
					String filePath = "Upload" + File.separator + "AllTypeFile" + File.separator + filename;

					Float fileSize = Float.valueOf(fileManagerObject.getFile().getSize());

					byte[] bytes = fileManagerObject.getFile().getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(originalPath + File.separator + filename)));
					stream.write(bytes);
					stream.flush();
					stream.close();

					// ***************************************************************************************************//

					fileManagerObject.setFilePath(filePath);
					fileManagerObject.setContentType(contentType);
					fileManagerObject.setFileSize(fileSize);

					 int save = fileManagerService.save(fileManagerObject);

					redirectAttributes.addFlashAttribute("filesuccess", "File Upload Successfully");
					 //model.addAttribute("filesuccess", "Save File Successfully");

					return new ModelAndView("redirect:/addFileManager");
				} else {					
					model.addAttribute("fileManagerObj", fileManagerObject);					
					return new ModelAndView("fileIntoDbWithValidation", "filesuccess",
							"select only pdf,html,htm,txt,doc,docx,zip,xls,xlsx,jpg,jpeg,png,gif input file format.");
				}
			
		} else {			
			model.addAttribute("fileManagerObj", fileManagerObject);			
			return new ModelAndView("fileIntoDbWithValidation", "filesuccess", "Please Upload file");
		}

	}

	
}
