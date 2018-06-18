package com.luo.review.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class TestProxy {

	public static void main(String[] args) {
		StringBuilder sb  = new StringBuilder();
		Class<?> clazz = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		
		Method[] methods = clazz.getMethods();
		for(Method method:methods) {
			sb.append(method.getName()+"(");
			 Class<?>[] parameterTypes = method.getParameterTypes();
			for(Class parameterType: parameterTypes ) {
				sb.append(parameterType.getSimpleName()+",");
			}
			if(parameterTypes!=null && parameterTypes.length!=0) {
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(")"+"\n");
		}
		Constructor<?>[] contructors = clazz.getConstructors();
		for(Constructor contructor:contructors) {
			sb.append(contructor.getName()+"(");
			Class[] parameterTypes = contructor.getParameterTypes();
			for(Class parameterType: parameterTypes) {
				sb.append(parameterType.getName()+",");
			}
			if(parameterTypes!=null && parameterTypes.length!=0) {
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(")");
			//打印结果发现，代理对象没有空参构造器，只有一个含有InvocationHandler参数的构造器
		}
		System.out.println(sb.toString());
		
		ArrayList target  = new ArrayList<>();
		Collection coll = (Collection)TestProxy.getProxy(target,new MyAdvice());
		coll.add("dddd");
		coll.add("aaaa");
		System.out.println(coll.size());
	}

	private static Object getProxy(Object target,Advice advice) {
		Object proxyObj  = Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						advice.methodBefore(method);
						
						Object reVal = method.invoke(target, args);
						
						advice.methodAfter(method);
						return reVal;
						
					}
		});
		return proxyObj;
	}
}
