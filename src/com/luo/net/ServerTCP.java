package com.luo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

	public static void main(String[] args) throws IOException {
		
		/* // 监听指定的端口
	    int port = 55533;
	    ServerSocket server = new ServerSocket(port);
	    
	    // server将一直等待连接的到来
	    System.out.println("server将一直等待连接的到来");
	    Socket socket = server.accept();
	    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
	    InputStream inputStream = socket.getInputStream();
	    byte[] bytes = new byte[1024];
	    int len;
	    StringBuilder sb = new StringBuilder();
	    while ((len = inputStream.read(bytes)) != -1) {
	      //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
	      sb.append(new String(bytes, 0, len,"UTF-8"));
	    }
	    System.out.println("get message from client: " + sb);
	    inputStream.close();
	    socket.close();
	    server.close();*/
		//1.创建服务端
		ServerSocket ss = new ServerSocket(10004);
		
		//2.获取客户端
		Socket s = ss.accept();
		InetAddress ip = s.getInetAddress();
		System.out.println(ip.getHostAddress()+"....concented");
		
		//读取客户端的输入流，并装饰
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//读取客户端的输入流，并装饰
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=brIn.readLine())!=null){
			
			System.out.println(ip.getHostAddress()+": "+line);
			
			out.println(line.toUpperCase());
			/*out.write(line.toUpperCase()+"\r\n");
			out.flush();发送对方readline读取需要结束标记，并刷新*/
		};
		s.close();
		ss.close();
	}
}
