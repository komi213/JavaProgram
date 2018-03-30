package jersey;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 发送图片到另外一台Tomcat服务器
 * @author komi
 *
 */
public class JerseyDemo {
	public static void main(String[] args) throws IOException {
		//实例化一个Jersey
		Client client = new Client();
		//另外一台服务器的请求路径
		String url = "http://localhost:8088/image-web/upload/1.jpg";
		//设置请求路径
		WebResource resource = client.resource(url);
		String path = "C:\\Users\\Public\\Pictures\\Sample Pictures\\t1.jpg";
		//读取图片到内存中
		byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));	
		//发送开始POST,GET,PUT
		resource.put(String.class, readFileToByteArray);
		System.out.println("发送图片到另外一台服务器完毕!");
	}
}
