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
		//1.�����ͻ���
		Socket client = new Socket("127.0.0.1", 4399);
		//��ȡ�ͻ��˵����������װ��
		PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
		//��ȡ�ͻ��˵�����������װ��
		BufferedReader brIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		
		//2.��ȡ�ļ�
		BufferedReader br = new BufferedReader(new FileReader("E:\\workspace8\\jdk8\\src\\ResourceBulde2.properties"));
		String line = null;
		while((line=br.readLine())!=null) {
			pw.println(line);
		}
		//3.����socket����ˣ��ļ��������
		client.shutdownOutput();
		
		//4.��ȡ����˷���
		System.out.println(brIn.readLine());
		
		//5.�ر���Դ
		br.close();
		client.close();
	}
	
}
