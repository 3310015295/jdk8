package com.luo.review.proxy;

import java.lang.reflect.Method;

public class MyAdvice implements Advice{

	Long starttime = 0L;
	long endtime = 0L;
	@Override
	public void methodBefore(Method method) {
		System.out.println(method.getName()+"������ʼ����");
		starttime = System.currentTimeMillis();
	}

	@Override
	public void methodAfter(Method method) {
		endtime = System.currentTimeMillis();
		System.out.println(endtime-starttime);
		System.out.println(method.getName()+"�����������");
		
	}

}
