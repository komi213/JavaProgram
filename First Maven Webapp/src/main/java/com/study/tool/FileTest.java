package com.study.tool;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		String path = "e/a/b.html";
		File f = new File(path);
		File parentFile = f.getParentFile();
		if(!parentFile.exists()){
			parentFile.mkdirs();
			System.out.println("创建父级目录成功(e/a/),文件所有上级目录");
		}
	}
}
