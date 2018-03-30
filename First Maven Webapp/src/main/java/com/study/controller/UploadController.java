package com.study.controller;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.study.tool.Upload;

@Controller
public class UploadController {
	@RequestMapping(value="upload")
	public String getUpoad(HttpServletRequest request,ServletResponse reponse){
		
		return "upload";
	}
	
	@ResponseBody
	@RequestMapping(value="/upload/image")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {
		Upload upload= new Upload();
		String path = upload.uploadimg(file, request);
		return path;
	}
}
