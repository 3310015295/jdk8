package com.luo.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TxtServer {

	public static void main(String[] args) throws Exception {
		
		//1.创建服务端
		ServerSocket s = new ServerSocket(4399);
		
		//2.获取客户端
		Socket ss = s.accept();
		System.out.println(ss.getInetAddress().getHostAddress()+"...准备上传文件");
		//获取客户端输入流，并装饰
		BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
		//获取客户端输入出流，并装饰
		PrintWriter pw = new PrintWriter(ss.getOutputStream(),true);
		
		//3.将数据写入文件
		BufferedWriter buffOut = new BufferedWriter(new FileWriter("XXX.properties"));
		String line = null;
		while((line=br.readLine())!=null) {
			buffOut.write(line);
			buffOut.newLine();
			buffOut.flush();
		}
				
		pw.println("上传成功");
		
		//4.关闭资源
		buffOut.close();
		ss.close();
		s.close();
	}
}
