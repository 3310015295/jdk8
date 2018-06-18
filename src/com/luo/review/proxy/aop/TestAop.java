package com.luo.review.proxy.aop;

import java.io.InputStream;
import java.util.Collection;

public class TestAop {

	public static void main(String[] args) {
		
			InputStream ins = TestAop.class.getResourceAsStream("config.properties");
			BeanFactory beanFactory = new BeanFactory(ins);
			Collection coll = (Collection)beanFactory.getBean("xxx");
			coll.add("sss");
			System.out.println(coll.getClass().getName());
	}
}
