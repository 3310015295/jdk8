package com.luo.review.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义方法注解
 * 具有数组和枚举类型的属性
 * @author ljp
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation {
	public enum Season{
		SPRING,AUTUMN,SUMMER,WINTER;
	}
	
	int[] array() default {1,7,9};//数组属性
	
	Season season() default Season.SPRING;//枚举类属性
	
}
