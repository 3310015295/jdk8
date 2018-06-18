package com.luo.review.classTest;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestResourceBudle {

	public static void main(String[] args) {
		//ResourceBundle：基于类读取属性文件，将属性文件当做类
		//会去classpah路径下 使用属性文件的全限定型类名而非路径查找属性文件
		//所以属性文件必须放在包中
		ResourceBundle bundle = ResourceBundle.getBundle("com.luo.config.ResourceBulde");
		ResourceBundle bundle2 = ResourceBundle.getBundle("ResourceBulde2");
		String str = bundle.getString("jdbc.driver");
		System.out.println(str);
		System.out.println(bundle2.getString("jdbc.driver"));
		
		//遍历键值对
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key+" = "+bundle.getString(key));
		}
		
		
		//1.1使用相对路径
		InputStream ins = TestResourceBudle.class.getResourceAsStream("classResource.properties");
		//用“.."表示上一级目录
		ins = TestResourceBudle.class.getResourceAsStream("../ResourceBulde3.properties");
		ins = TestResourceBudle.class.getResourceAsStream("../../config/ResourceBulde.properties");
		ins = TestResourceBudle.class.getResourceAsStream("test/classResource4.properties");
		
		//1.2使用绝对路径
		//InputStream ins = TestResourceBudle.class.getResourceAsStream("/com/luo/config/ResourceBulde.properties");
		ins = TestResourceBudle.class.getResourceAsStream("/ResourceBulde2.properties");
		
		InputStream sysIns = ClassLoader.getSystemResourceAsStream("ResourceBulde2.properties");
		sysIns = ClassLoader.getSystemResourceAsStream("com/luo/config/ResourceBulde.properties");
		System.out.println(sysIns==null);
		
		Properties  prop = new Properties();
		try {
			prop.load(ins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ins.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("jdbc.driver"));
		
	}
	
	@Test
	public void testResLocal() {
		ResourceBundle resBundle = ResourceBundle.getBundle("com.luo.config.res",new Locale("zh", "CN"));
		resBundle = ResourceBundle.getBundle("com.luo.config.res",new Locale("en", "US"));
		/**
		 * 但是最后一个GERMAN，应该会去使用res.properties这个资源包吧？怎么使用了res_zh_CH.properties？
             原来ResourceBundle为我们提供了一个fallback（也就是一个备用方案），
             这个备用方案就是根据当前系统的语言环境来得到的本地化信息。
              所以若是找不到GERMAN的，之后就会去找CHINA了，所以找到了res_zh_CH.properties这个资源包
		 */
		resBundle = ResourceBundle.getBundle("com.luo.config.res",Locale.GERMAN);
		System.out.println(resBundle.getString("canclekey"));
		
		String info = resBundle.getString("info");
		System.out.println(info);//你好,{0}
		System.out.println(MessageFormat.format(info, "lluooo"));//你好,lluooo
	}
	@Test
	//Locale对象表示了特定的地理、政治和文化地区。
	//需要Locale来执行其任务的操作称为语言环境敏感的操作，
	//它使用Locale为用户量身定制信息。
	public void testLocal() {
		Locale local = new Locale("zh","CN");
		System.out.println("语言："+local.getDisplayLanguage());
		System.out.println("国家："+local.getDisplayCountry());
	}
}




