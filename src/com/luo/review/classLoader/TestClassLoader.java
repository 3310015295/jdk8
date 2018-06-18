package com.luo.review.classLoader;

import java.io.File;

public class TestClassLoader {

	public static void main(String[] args)  throws Exception{
		ClassLoader loader = TestClassLoader.class.getClassLoader();
		while(loader!=null) {
			System.out.println(loader);
			loader = loader.getParent();
		}
		//System.out.println(new ClassLoaderAttach().toString());
		Class<?> clazz = new MyClassLoader("mylib").loadClass("com.luo.review.classLoader.ClassLoaderAttach");
		System.out.println("查看类加载名称："+ clazz.getClassLoader());//com.luo.review.classLoader.MyClassLoader@75b84c92
		Object obj = clazz.newInstance();
		System.out.println(obj);
	}
	
}
