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
/*		 // Ҫ���ӵķ����IP��ַ�Ͷ˿�
	    String host = "127.0.0.1"; 
	    int port = 55533;
	    // �����˽�������
	    Socket socket = new Socket(host, port);
	    // �������Ӻ��������
	    OutputStream outputStream = socket.getOutputStream();
	    String message="���  yiwangzhibujian";
	    socket.getOutputStream().write(message.getBytes("UTF-8"));
	    outputStream.close();
	    socket.close();*/
	    
		//�����ͻ���
		Socket s = new Socket("127.0.0.1", 10004);
		//scoket��ȡ�����
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//socket������:��ȡ����˷��ص�����
		BufferedReader buffIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//��ȡ����¼��
		BufferedReader  fr =  new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=fr.readLine())!=null) {
			if("over".equals(line)) {
				break;
			}
			out.println(line);
			/*out.print(line+"\r\n");
			out.flush();*/
			
			//���߷����,�ͻ������ݷ������
			//s.shutdownOutput();
			
			//��ȡ���������ص�����
			System.out.println(buffIn.readLine());
		}
		
		s.close();
	}
	
}
