package com.study.tool;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
	public String uploadimg(MultipartFile avata , HttpServletRequest request) {
		String fileurl="";
		
		if (avata == null) {
			System.out.println("null");
			return "";
		}else if(avata.isEmpty()){
			System.out.println("empty");
			return "";
		}else{
			System.out.println("文件长度: " + avata.getSize());
			System.out.println("文件类型: " + avata.getContentType());
			System.out.println("文件名称: " + avata.getName());
			System.out.println("文件原名: " + avata.getOriginalFilename());
			System.out.println("========================================");
//          //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  
           //String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
          //使用自定义文件资源库
			String realPath = "C:/upload";
			//tomcat 配置文件server.xml </Host>结束的位置加上以下代码
			/*其中，Context表示上下文，代表的就是一个JavaWeb应用，Context元素有两个属性，
			　　Ⅰ.path：用来配置虚似目录，必须以"/"开头。
			　　Ⅱ.docBase：配置此虚似目录对应着硬盘上的Web应用所在目录。*/
			/*<!--配置虚拟目录-->  
			<Context path="/" docBase="C:/upload" debug="0" reloadable="false"/> */
			File targetFile = new File(realPath);
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			System.out.println("物理路径："+realPath);
			int i = avata.getOriginalFilename().lastIndexOf(".");// 返回最后一个点的位置
			String extension = avata.getOriginalFilename().substring(i + 1);// 取出扩展名
			String filename =UUID.randomUUID().toString()+"."+extension;
			
			//配置图片tomcat启动ip地址访问路径					
			String ip = "http://localhost:8080/";
			fileurl = ip+filename;
			System.out.println("ip地址访问："+fileurl);
			try {
				avata.transferTo( new File(realPath, filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fileurl;
		}	
	}

}
