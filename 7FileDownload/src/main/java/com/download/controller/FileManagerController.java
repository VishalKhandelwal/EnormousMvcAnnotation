package com.download.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.download.model.FileManager;
import com.download.service.FileManagerService;

@Controller
public class FileManagerController {

	@Autowired
	FileManagerService fileManagerService;
	
	@RequestMapping(value = "/DisplayFileManager", method = RequestMethod.GET)
	public ModelAndView displayFileManager(Model model, HttpServletRequest req, HttpServletResponse response) {
		
			List<FileManager> list = fileManagerService.getListOfFileManager();
			System.out.println(list);
			model.addAttribute("fileManagerList", list);
			return new ModelAndView("displayFileManager");
		

	}
	
	@RequestMapping(value = "/DisplayFileManager2", method = RequestMethod.GET)
	public ModelAndView displayFileManager2(Model model, HttpServletRequest req, HttpServletResponse response) {
		
			List<FileManager> list = fileManagerService.getListOfFileManager();
			System.out.println(list);
			model.addAttribute("fileManagerList", list);
			return new ModelAndView("displayFileManager2");
		

	}
}
