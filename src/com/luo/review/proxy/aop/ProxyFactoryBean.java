package com.luo.review.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.luo.review.proxy.Advice;

public class ProxyFactoryBean {

	private Object target;
	
	private Advice advice;

	public ProxyFactoryBean() {
		// TODO Auto-generated constructor stub
	}
	public ProxyFactoryBean(Object target, Advice advice) {
		super();
		this.target = target;
		this.advice = advice;
	}
	
	public Object getProxyObj() {
		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		Object proxyObj = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				advice.methodBefore(method);
				
				Object retVal = method.invoke(target, args);
				
				advice.methodAfter(method);
				
				return retVal;
			}
		});
		return proxyObj;
	}
	
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public Advice getAdvice() {
		return advice;
	}
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	
}
