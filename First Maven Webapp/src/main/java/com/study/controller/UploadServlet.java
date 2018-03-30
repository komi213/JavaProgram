package com.study.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

/**
 * Servlet图片上传
 * @author komi
 *
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		// 可以用request.getPart()方法获得名为photo的上传附件
        // 也可以用request.getParts()获得所有上传附件（多文件上传）
        // 然后通过循环分别处理每一个上传的文件
		Part part = request.getPart("photo");
		if (part!=null&&part.getContentType().contains("image")) { // 简单判断下，是不是图片类型
			ApplicationPart ap = (ApplicationPart) part;
			// 获取上传的文件名
			String name = ap.getSubmittedFileName();
			System.out.println("文件名称：" + name);
			String savePath = request.getServletContext().getRealPath("/upload");
			// 用ServletContext对象的getRealPath()方法获得上传文件夹的绝对路径
			part.write(savePath + "/" + name);
            request.setAttribute("hint", "Upload Successfully!"+savePath);
		}else{
			request.setAttribute("hint", "文件不是图片类型!");
		}
		// 跳转回到上传页面
		request.getRequestDispatcher("servlet_upload.jsp").forward(request, response);
	}
	
}
