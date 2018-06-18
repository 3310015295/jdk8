package com.luo.net;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class TestUrl {
	
	
	@Test
	public void test1() throws Exception {
		
		//url�����Э�����ƣ�//���������˿ں�/�ļ���
		URL url = new URL("https://www.baidu.com/index.php");
		
		System.out.println("Э�����ƣ�"+url.getProtocol());
		System.out.println("��������"+url.getHost());
		System.out.println("�˿����ƣ�"+url.getPort());
		System.out.println("�ļ����ƣ�"+url.getFile());
		System.out.println("url�Ĳ�ѯ���ƣ�"+url.getQuery());
		
		URLConnection conn = url.openConnection();
		InputStream ins = conn.getInputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		while((len=ins.read(buff))!=-1) {
			System.out.println(new String(buff));
		}
	}


}
