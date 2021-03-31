package com.download.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.download.model.FileDetail;
import com.download.service.FileDetailService;

@Controller
public class FileDetailController {

	@Autowired
	FileDetailService fileDetailService;
	
	@RequestMapping(value = "/DisplayFileDetailBlob", method = RequestMethod.GET)
	public ModelAndView displayFileDetail(Model model, HttpServletRequest req, HttpServletResponse response) {
		
			List<FileDetail> list = fileDetailService.getListOfFileDetail();
			System.out.println(list);
			model.addAttribute("fileDetailList", list);
			return new ModelAndView("databaseFileDetail");
		

	}
	
	@RequestMapping(value = { "/download-document/{id}" }, method = RequestMethod.GET)
    public String downloadDocument(@PathVariable int id, HttpServletResponse response) throws IOException {
		FileDetail document = fileDetailService.getFileDetailById(id);
        response.setContentType(document.getFileType());
        response.setContentLength(document.getData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getFileName() +"\"");
  
        FileCopyUtils.copy(document.getData(), response.getOutputStream());
  
        return null;
    }
}
