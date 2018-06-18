package com.luo.review.reflect.extend;

import java.lang.reflect.Method;

public class Father {
	
	public static void main(String[] args) throws Exception {
		Father fa = new Son();
		fa.show("sonShow");
	}
	public void show(String sonMethodName) throws Exception {
		Class<? extends Father> clazz = this.getClass();
		System.out.println(clazz+":"+this);
		Method method = clazz.getMethod(sonMethodName);
		Object invoke = method.invoke(this, null);
		System.out.println(invoke);
	}
}
class Son extends Father{
	
	public void sonShow() {
		System.out.println("子类方法");
	}
	
	public String sonShow2() {
		System.out.println("子类方法2");
		return "sss";
	}
}