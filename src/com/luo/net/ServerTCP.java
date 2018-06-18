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
		
		/* // ����ָ���Ķ˿�
	    int port = 55533;
	    ServerSocket server = new ServerSocket(port);
	    
	    // server��һֱ�ȴ����ӵĵ���
	    System.out.println("server��һֱ�ȴ����ӵĵ���");
	    Socket socket = server.accept();
	    // ���������Ӻ󣬴�socket�л�ȡ�����������������������ж�ȡ
	    InputStream inputStream = socket.getInputStream();
	    byte[] bytes = new byte[1024];
	    int len;
	    StringBuilder sb = new StringBuilder();
	    while ((len = inputStream.read(bytes)) != -1) {
	      //ע��ָ�������ʽ�����ͷ��ͽ��շ�һ��Ҫͳһ������ʹ��UTF-8
	      sb.append(new String(bytes, 0, len,"UTF-8"));
	    }
	    System.out.println("get message from client: " + sb);
	    inputStream.close();
	    socket.close();
	    server.close();*/
		//1.���������
		ServerSocket ss = new ServerSocket(10004);
		
		//2.��ȡ�ͻ���
		Socket s = ss.accept();
		InetAddress ip = s.getInetAddress();
		System.out.println(ip.getHostAddress()+"....concented");
		
		//��ȡ�ͻ��˵�����������װ��
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//��ȡ�ͻ��˵�����������װ��
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=brIn.readLine())!=null){
			
			System.out.println(ip.getHostAddress()+": "+line);
			
			out.println(line.toUpperCase());
			/*out.write(line.toUpperCase()+"\r\n");
			out.flush();���ͶԷ�readline��ȡ��Ҫ������ǣ���ˢ��*/
		};
		s.close();
		ss.close();
	}
}
