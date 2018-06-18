package com.luo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {

	public static void main(String[] args) throws UnknownHostException, IOException {
/*		 // 要连接的服务端IP地址和端口
	    String host = "127.0.0.1"; 
	    int port = 55533;
	    // 与服务端建立连接
	    Socket socket = new Socket(host, port);
	    // 建立连接后获得输出流
	    OutputStream outputStream = socket.getOutputStream();
	    String message="你好  yiwangzhibujian";
	    socket.getOutputStream().write(message.getBytes("UTF-8"));
	    outputStream.close();
	    socket.close();*/
	    
		//创建客户端
		Socket s = new Socket("127.0.0.1", 10004);
		//scoket获取输出流
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//socket输入流:读取服务端返回的数据
		BufferedReader buffIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//获取键盘录入
		BufferedReader  fr =  new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=fr.readLine())!=null) {
			if("over".equals(line)) {
				break;
			}
			out.println(line);
			/*out.print(line+"\r\n");
			out.flush();*/
			
			//告诉服务端,客户端数据发送完毕
			//s.shutdownOutput();
			
			//读取服务器发回的数据
			System.out.println(buffIn.readLine());
		}
		
		s.close();
	}
	
}
