package cn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {
	/*public static void main(String[] args) throws Exception {
		Template t = new Template(null,new StringReader("用户名：--${user};URL：${url};姓名：${name}"),null);
		//创建插值的Map
		Map map = new HashMap();
		map.put("user", "komi");
		map.put("url", "http://www.baidu.com/");
		map.put("name", "百度");
		//执行插值，并输出到指定的输出流中
		t.process(map, new OutputStreamWriter(System.out));
	}*/
	
	public static void main(String[] args) {  
        try {
        	//文件路径
        	String filePath = "C:\\JavaProgram\\First Maven Webapp\\src\\main\\webapp\\WEB-INF\\template";
            //创建一个合适的Configration对象  
            Configuration configuration = new Configuration();  
            configuration.setDirectoryForTemplateLoading(new File(filePath));  
            configuration.setObjectWrapper(new DefaultObjectWrapper());  
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码  
            //获取或创建一个模版。  
            Template template = configuration.getTemplate("static.ftl");  
            Map<String, Object> paramMap = new HashMap<String, Object>();  
            paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");  
              
            List<String> nameList = new ArrayList<String>();  
            nameList.add("陈靖仇");  
            nameList.add("玉儿");  
            nameList.add("宇文拓");  
            paramMap.put("nameList", nameList);  
              
            Map<String, Object> weaponMap = new HashMap<String, Object>();  
            weaponMap.put("first", "轩辕剑");  
            weaponMap.put("second", "崆峒印");  
            weaponMap.put("third", "女娲石");  
            weaponMap.put("fourth", "神农鼎");  
            weaponMap.put("fifth", "伏羲琴");  
            weaponMap.put("sixth", "昆仑镜");  
            weaponMap.put("seventh", null);  
            paramMap.put("weaponMap", weaponMap);  
              
            Writer writer  = new OutputStreamWriter(new FileOutputStream(filePath+"\\success.html"),"UTF-8");  
            template.process(paramMap, writer);  
              
            System.out.println("恭喜，生成成功~~");  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        }  
          
    }
}
