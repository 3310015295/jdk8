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
		
		//1.���������
		ServerSocket s = new ServerSocket(4399);
		
		//2.��ȡ�ͻ���
		Socket ss = s.accept();
		System.out.println(ss.getInetAddress().getHostAddress()+"...׼���ϴ��ļ�");
		//��ȡ�ͻ�������������װ��
		BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
		//��ȡ�ͻ��������������װ��
		PrintWriter pw = new PrintWriter(ss.getOutputStream(),true);
		
		//3.������д���ļ�
		BufferedWriter buffOut = new BufferedWriter(new FileWriter("XXX.properties"));
		String line = null;
		while((line=br.readLine())!=null) {
			buffOut.write(line);
			buffOut.newLine();
			buffOut.flush();
		}
				
		pw.println("�ϴ��ɹ�");
		
		//4.�ر���Դ
		buffOut.close();
		ss.close();
		s.close();
	}
}
