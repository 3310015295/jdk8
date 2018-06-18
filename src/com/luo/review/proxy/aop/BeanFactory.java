package com.luo.review.proxy.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.luo.review.proxy.Advice;

public class BeanFactory {

	Properties prop = new Properties();
	
	public BeanFactory(InputStream ins) {
	
		try {
			prop.load(ins);
		} catch (IOException e) {
			System.out.println("工厂bean加载文件失败");
		}
	}
	
	public Object getBean(String name) {
		String className = prop.getProperty(name);
		Class<?> clazz = null;
		Object bean = null;
		Advice advice = null;
		Object target = null;
		try {
			clazz = Class.forName(className);
			bean = clazz.newInstance();
			
			advice = (Advice)Class.forName(prop.getProperty(name+".advice")).newInstance();
			
			target = Class.forName(prop.getProperty(name+".target")).newInstance();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("读取反射文件出错");
		}
		if(bean instanceof ProxyFactoryBean) {
			ProxyFactoryBean proxyfactoryBean = (ProxyFactoryBean)bean;
			proxyfactoryBean.setAdvice(advice);
			proxyfactoryBean.setTarget(target);
			Object proxyObj = proxyfactoryBean.getProxyObj();
			return proxyObj;
		}
		return bean;
	}
}
