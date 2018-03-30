package com.study.tool.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.study.tool.abstractTest.Human;

/**
 * Class类工具
 * @author komi
 *
 */
@SuppressWarnings("all")
public class ClassUtils {
	/**
	 * 给一个接口，返回这个接口的所有实现类
	 * @param c
	 * @return
	 */
	public static List<Class> getAllClassByInterface(Class c){
		List<Class> returnClassList = new ArrayList<Class>(); //返回结果
		//如果不是一个接口，则不做处理
		if(c.isInterface()){
			String packageName = c.getPackage().getName(); //获得当前的包名
			try {
				List<Class> allClass = getClasses(packageName); //获得当前包下以及子包下的所有类
				//判断是否是同一个接口
				for(int i=0;i<allClass.size();i++){
					//isAssignableFrom   是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的超类或接口。 
					if(c.isAssignableFrom(allClass.get(i))){ //判断是不是一个接口
						//如果是同一块内存，则object中的equals方法返回true,如果是不同的内存，则返回false
						//类加载：找到需要加载的类并把类的信息加载到jvm的方法区中，然后在堆区中实例化一个java.lang.Class对象
						if(!c.equals(allClass.get(i))){ //本身不加进去
							returnClassList.add(allClass.get(i));
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returnClassList;
	}
	/**
	 * 从一个包中查找出所有的类，在jar包中不能查找
	 * @param packageName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static List<Class> getClasses(String packageName)
			throws ClassNotFoundException, IOException {
		//得到当前的classpath的绝对路径的URI表示法
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace('.', '/');//com.study.tool.abstractTest替换成com/study/tool/abstractTest
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			//file:/D:/First%20Maven%20Webapp/target/classes/com/study/tool/abstractTest
			URL resource = resources.nextElement();
			System.out.println("转码前："+resource.getFile());
			String decodeURL = URLDecoder.decode(resource.getFile(), "utf-8");//URL解码,空格还原  "%20"还原为空格
			System.out.println("转码后："+decodeURL);
			dirs.add(new File(decodeURL));//空格还原
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes;
	}
	private static List<Class> findClasses(File directory, String packageName)
		throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println(file);
				boolean isContains = file.getName().contains(".");
				assert !isContains;//默认关闭断言来功能手动开启,eclipse->Run -> Run Configurations -> VM arguments 加-ea
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				//class com.study.tool.abstractTest.AbstractClassTest
				Class<?> calssName = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
				classes.add(calssName);
			}
		}
		return classes;
	}
	public static void main(String[] args) {
		List<Class> allClassByInterface = ClassUtils.getAllClassByInterface(Human.class);
		for (Class class1 : allClassByInterface) {
			System.out.println(class1);
		}
	}
}

