package com.study.tool.InputOutputStreamTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		/*FileCopy.fileCopy("D:\\a.txt", "D:\\b.txt");
		FileCopy.fleCopyNIO("D:\\a.txt", "D:\\c.txt");
		int count = FileCopy.countWordInFile("D:\\a.txt", "a");
		System.out.println("成功"+count);
		//NIO展开目录及子目录文件
		Path initPath = Paths.get("D:\\新建文件夹\\");
		Files.walkFileTree(initPath, new SimpleFileVisitor<Path>(){
			@Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                    throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.SKIP_SUBTREE;
                *//**
                 * CONTINUE –继续
					TERMINATE –终止，这次遍历结束了
					SKIP_SUBTREE –子树（当前路径的子目录）不再遍历了
					SKIP_SIBLINGS –兄弟节点（同级别目录）不再访问了。
                 *//*
            }
		});*/
		FileCopy._walkDirectory("D:\\新建文件夹\\", 0);
	}
	//工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
	private FileCopy() {
        throw new AssertionError();
    }
	//第一种，文件复制
	public static void fileCopy(String source,String target) throws IOException{
		//上面用到Java 7的TWR，使用TWR后可以不用在finally中释放外部资源 ，从而让代码更加优雅。
		try(InputStream in = new FileInputStream(source)){
			try(OutputStream out = new FileOutputStream(target)){
				byte[] buffer = new byte[4];//2字节
				int bytesToRead;
				while((bytesToRead=in.read(buffer))!=-1){
					System.out.println("bytesToRead:"+bytesToRead+";buffer内容："+new String(buffer));
					out.write(buffer, 0, bytesToRead);//从buff中读取0~bytesToRead数据存入OutputStream.
				}
			}
		}
	}
	//FileChannel复制文件的速度比BufferedInputStream/BufferedOutputStream复制文件的速度快了近三分之一。
	//在复制大文件的时候更加体现出FileChannel的速度优势。而且FileChannel是多并发线程安全的。
	//连接两个通道，并且从in通道读取，然后写入out通道
	/*可见Java nio的优势为：
	1. 不需要使用read()或者write()操作就可以处理文件内容了
	2. 修改文件后，修改自动flush到文件
	3. nio方式能很快处理大文件和处理效率很快*/
	//in.transferTo(0, in.size(), out);
	
	//第二种，文件复制(文件通道)
	public static void fleCopyNIO(String source,String target) throws IOException{
		//上面用到Java 7的TWR，使用TWR后可以不用在finally中释放外部资源 ，从而让代码更加优雅。
		try(FileInputStream  in = new FileInputStream(source)){
			try(FileOutputStream  out = new FileOutputStream(target)){
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(4096);//指定字节缓冲的容量
				while(inChannel.read(buffer) != -1) {
                    buffer.flip();//准备从字节缓冲中读取数据
                    outChannel.write(buffer);
                    buffer.clear();
                }
				outChannel.close();
				inChannel.close();
			}
		}
	}
	
	/**
     * 统计给定文件中给定字符串的出现次数(一行一行判断)
     * @param filename  文件名
     * @param word 字符串(不能是中文字符)
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }
	/**
	 * 如果对文件夹继续展开
	 * @param f
	 * @param level
	 */
    private static void _walkDirectory(String path, int level) {
    	File f = new File(path);
        if(f.isDirectory()) {
            for(File temp : f.listFiles()) {
                _walkDirectory(temp.getPath(), level + 1);
            }
        }
        else {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("\t");//tab键
            }
            System.out.println(f.getName());
        }
    }
}
