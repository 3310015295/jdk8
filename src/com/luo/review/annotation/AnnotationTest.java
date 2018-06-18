package com.luo.review.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.luo.review.annotation.MyMethodAnnotation.Season;

@MyClassAnnotation(desc="自定义类注解")
public class AnnotationTest {

	@MyMethodAnnotation(season=Season.SPRING)
	public void method() {
		
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//获取class的三种方法
		//1.类.class 2 实例.getClass() 3 Class.forName("全类名"）4 this.getClass().getClassloader().loadClass("全类名")
		
		//1.获取类上注解的属性值
		MyClassAnnotation annotation = AnnotationTest.class.getAnnotation(MyClassAnnotation.class);
		String desc = annotation.desc();
		System.out.println("获取注解的属性的值："+annotation.desc()+":"+annotation.num());
		
		//2.获取方法上的属性
		Method method = AnnotationTest.class.getMethod("method", null);
		MyMethodAnnotation methodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
		System.out.println("方法上注解的属性值："+Arrays.toString(methodAnnotation.array())
							+";\n"+methodAnnotation.season());
	}
}
