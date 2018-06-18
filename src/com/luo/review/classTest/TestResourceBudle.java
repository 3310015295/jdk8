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
		//ResourceBundle���������ȡ�����ļ����������ļ�������
		//��ȥclasspah·���� ʹ�������ļ���ȫ�޶�����������·�����������ļ�
		//���������ļ�������ڰ���
		ResourceBundle bundle = ResourceBundle.getBundle("com.luo.config.ResourceBulde");
		ResourceBundle bundle2 = ResourceBundle.getBundle("ResourceBulde2");
		String str = bundle.getString("jdbc.driver");
		System.out.println(str);
		System.out.println(bundle2.getString("jdbc.driver"));
		
		//������ֵ��
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key+" = "+bundle.getString(key));
		}
		
		
		//1.1ʹ�����·��
		InputStream ins = TestResourceBudle.class.getResourceAsStream("classResource.properties");
		//�á�.."��ʾ��һ��Ŀ¼
		ins = TestResourceBudle.class.getResourceAsStream("../ResourceBulde3.properties");
		ins = TestResourceBudle.class.getResourceAsStream("../../config/ResourceBulde.properties");
		ins = TestResourceBudle.class.getResourceAsStream("test/classResource4.properties");
		
		//1.2ʹ�þ���·��
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
		 * �������һ��GERMAN��Ӧ�û�ȥʹ��res.properties�����Դ���ɣ���ôʹ����res_zh_CH.properties��
             ԭ��ResourceBundleΪ�����ṩ��һ��fallback��Ҳ����һ�����÷�������
             ������÷������Ǹ��ݵ�ǰϵͳ�����Ի������õ��ı��ػ���Ϣ��
              ���������Ҳ���GERMAN�ģ�֮��ͻ�ȥ��CHINA�ˣ������ҵ���res_zh_CH.properties�����Դ��
		 */
		resBundle = ResourceBundle.getBundle("com.luo.config.res",Locale.GERMAN);
		System.out.println(resBundle.getString("canclekey"));
		
		String info = resBundle.getString("info");
		System.out.println(info);//���,{0}
		System.out.println(MessageFormat.format(info, "lluooo"));//���,lluooo
	}
	@Test
	//Locale�����ʾ���ض��ĵ������κ��Ļ�������
	//��ҪLocale��ִ��������Ĳ�����Ϊ���Ի������еĲ�����
	//��ʹ��LocaleΪ�û���������Ϣ��
	public void testLocal() {
		Locale local = new Locale("zh","CN");
		System.out.println("���ԣ�"+local.getDisplayLanguage());
		System.out.println("���ң�"+local.getDisplayCountry());
	}
}




