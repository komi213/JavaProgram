package com.study.tool.SocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * socket客户端
 * @author komi
 *
 */
public class EchoClient {
	public static void main(String[] args) throws Exception {
		try(Socket client = new Socket("localhost", 6789)){
			Scanner sc = new Scanner(System.in);
	        System.out.print("请输入内容: ");
	        String msg = sc.nextLine();
	        sc.close();
	        PrintWriter pw = new PrintWriter(client.getOutputStream());
	        pw.println(msg);
	        pw.flush();
	        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        System.out.println("收到服务器的返回："+br.readLine());
		}
        //client.close();用try包裹，会自动close
	}
}
