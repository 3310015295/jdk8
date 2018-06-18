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
		
		//url的组成协议名称：//主机名：端口号/文件名
		URL url = new URL("https://www.baidu.com/index.php");
		
		System.out.println("协议名称："+url.getProtocol());
		System.out.println("主机名："+url.getHost());
		System.out.println("端口名称："+url.getPort());
		System.out.println("文件名称："+url.getFile());
		System.out.println("url的查询名称："+url.getQuery());
		
		URLConnection conn = url.openConnection();
		InputStream ins = conn.getInputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		while((len=ins.read(buff))!=-1) {
			System.out.println(new String(buff));
		}
	}


}
