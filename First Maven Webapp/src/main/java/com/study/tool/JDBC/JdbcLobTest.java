package com.study.tool.JDBC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcLobTest {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// 1. 加载驱动（Java6以上版本可以省略）
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 建立连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8","root","123456");
			// 3. 创建语句对象
			//插入图片数据
			/*PreparedStatement ps = con.prepareStatement("insert into tb_user (name,photo) values (?, ?)");
			ps.setString(1, "骆昊15");              // 将SQL语句中第一个占位符换成字符串
			try{
				File file = new File("D:\\001.jpg");
				InputStream in = new BufferedInputStream(new FileInputStream(file));
	            ps.setBinaryStream(2, in, (int)file.length());// 将SQL语句中第二个占位符换成二进制流
				System.out.println(ps.executeUpdate()==1?"插入成功":"插入失败");
			}catch(IOException e){
				System.out.println("插入照片失败!");
			}*/
			
			//读取图片数据
			PreparedStatement ps = con.prepareStatement("select * from tb_user where id=?");
			ps.setInt(1, 10);//第一个参数，赋值10;查询id=10的数据
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				try {
					int id = rs.getInt(1);//取id
					String name = rs.getString(2);//取name
					Blob blob = rs.getBlob(3);//取photo图片
	                InputStream in = blob.getBinaryStream();
					File file = new File("D:\\"+id+".jpg");
					OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
					byte[] buff = new byte[1024];
	                for(int i=0;(i=in.read(buff))>0;){
	                    out.write(buff, 0, i);
	                }
	                out.close();
	                in.close();
					System.out.println("读取完成,id:"+id+"name:"+name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {// Java 7的多异常捕获
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{// 释放外部资源的代码都应当放在finally中保证其能够得到执行
			try {
				if(con!=null&&!con.isClosed()){
					con.close();// 5. 释放数据库连接 
					con = null;// 指示垃圾回收器可以回收该对象
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
