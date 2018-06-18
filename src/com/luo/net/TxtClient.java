package com.luo.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TxtClient {

	public static void main(String[] args) throws Exception {
		//1.创建客户端
		Socket client = new Socket("127.0.0.1", 4399);
		//获取客户端的输出流，并装饰
		PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
		//获取客户端的输入流，并装饰
		BufferedReader brIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		
		//2.读取文件
		BufferedReader br = new BufferedReader(new FileReader("E:\\workspace8\\jdk8\\src\\ResourceBulde2.properties"));
		String line = null;
		while((line=br.readLine())!=null) {
			pw.println(line);
		}
		//3.告诉socket服务端，文件传输完毕
		client.shutdownOutput();
		
		//4.获取服务端反馈
		System.out.println(brIn.readLine());
		
		//5.关闭资源
		br.close();
		client.close();
	}
	
}
