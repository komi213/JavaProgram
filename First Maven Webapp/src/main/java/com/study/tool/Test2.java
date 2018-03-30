package com.study.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test2 {
	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		String filename = "D:"+File.separator+"bb.xml";
		StringBuffer result = new StringBuffer();
        try 
        {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 获取输出流
            OutputStream out = conn.getOutputStream();

            // 读取文件内容到输出流
            FileInputStream reader = new FileInputStream(new File(filename));
            int c;
            while ((c = reader.read()) != -1)
            {
                out.write(c);
            }
            out.close();
            reader.close();

            // 获取响应流并读取响应数据
            InputStream in = conn.getInputStream();
            byte[] bytes = new byte[1024];
            int num;
            while ((num = in.read(bytes)) != -1) 
            {
                result.append(new String(bytes, 0, num));
            }
            in.close();
            System.out.println(result.toString());
          } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
}
