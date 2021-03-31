package com.vk.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final String UPLOAD_DIRECTORY ="/Upload";

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//***************************************************Single File**********************************************************************//
	@RequestMapping("singleFileUpload")  
    public ModelAndView singleFileUpload(){  
        return new ModelAndView("singleFileUpload");    
    }  
	
	
	
	@RequestMapping(value = "/saveSingleFile", method = RequestMethod.POST)
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
	           
	    return new ModelAndView("singleFileUpload","filesuccess","File successfully saved!");  
	}
	
	@RequestMapping("singleFileUpload2")  
    public ModelAndView singleFileUpload2(){  
        return new ModelAndView("singleFileUpload2");    
    }  
	
	@RequestMapping(value = "/saveSingleFileSecondMethod", method = RequestMethod.POST)
	public ModelAndView saveSingleFileSecondMethod(@RequestParam CommonsMultipartFile file,HttpServletRequest servletRequest) 
	{
		 
	    String path = servletRequest.getServletContext().getRealPath(UPLOAD_DIRECTORY+File.separator+"AllTypeFile");  
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
	  
	    File imageFile = new File(path, filename);
        try
        {
        	file.transferTo(imageFile);
        } catch (IOException e) 
        {
            e.printStackTrace();
        } 
	           
	    return new ModelAndView("singleFileUpload2","filesuccess","File successfully saved!");  
	}
	//*************************************************************************************************************************//
	
	
	@RequestMapping("multipleFileUpload")  
    public ModelAndView multipleFileUpload(){  
        return new ModelAndView("multipleFileUpload");    
    }  
	
	@RequestMapping(value = "/saveMultipleFile", method = RequestMethod.POST)
	public ModelAndView saveMultipleFile(@RequestParam List<MultipartFile> files,HttpServletRequest servletRequest) 
	{
		 
	    String path = servletRequest.getServletContext().getRealPath(UPLOAD_DIRECTORY+File.separator+"AllTypeFile");  
	    System.out.println("path");     
	  
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
	    
	    System.out.println(path);  
	    
        
        if (null != files && files.size() > 0) 
        {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();                
 
                File imageFile = new File(path, fileName);
                try
                {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
	    return new ModelAndView("multipleFileUpload","filesuccess","File successfully saved!");  
	}
	
	@RequestMapping("multipleFileUpload2")  
    public ModelAndView multipleFileUpload2(){  
        return new ModelAndView("multipleFileUpload2");    
    }  
	
	@RequestMapping(value = "/saveMultipleFileSecond", method = RequestMethod.POST)
	public ModelAndView saveMultipleFileSecond(@RequestParam List<MultipartFile> files,HttpServletRequest servletRequest) 
	{
		 
	    String path = servletRequest.getServletContext().getRealPath(UPLOAD_DIRECTORY+File.separator+"AllTypeFile");  
	    System.out.println("path");     
	  
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
	    
	    System.out.println(path);  
	    
	   
	    
        if (null != files && files.size() > 0) 
        {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();  
                
                System.out.println(path+" "+fileName);        
      		  
        	    byte[] bytes;
				try {
					bytes = multipartFile.getBytes();
				
        	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
        	         new File(path + File.separator + fileName)));  
        	    stream.write(bytes);  
        	    stream.flush();  
        	    stream.close(); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                
            }
        }
	    return new ModelAndView("multipleFileUpload2","filesuccess","File successfully saved!");  
	}
}
