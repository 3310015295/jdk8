package com.luo.review.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解的元注解，规定注解使用的范围，声明周期
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyClassAnnotation {

	//设置注解的属性
	String desc();
	
	int num() default 1;//注解设置默认值
	
}
