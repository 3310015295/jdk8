package com.luo.review.generictic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class TestGener {

	public static void main(String[] args) throws Exception{
		//泛型是给编译器使用的
		
		Collection<Integer> coll  = new ArrayList();
		
		coll.add(1);
		
		//coll.addAll("dddd"); 使用泛型，集合只能装入特定类型的数据
		
		//通过反射，可以给集合添加任意类型参数
		Method addMethod = coll.getClass().getMethod("add", Object.class);
		addMethod.invoke(coll, "ddddd");
		System.out.println(coll);//[1, ddddd]
		
		System.out.println("=======参数化类型和原始类型============");
		//参数化类型ArrayList<String>; 原始类型ArrayList（由编译器决定）
		//①参数化类型的引用可以指向原始类型；原始类型的引用也可以指向参数化类型
		Collection<Integer> coll1 = new Vector();//参数化类型引用指向原始类型
		Collection coll2 = new Vector<String>();//
		
		//Collection<Integer> coll3 = new Vector<String>();编译出错
	
		Collection coll3 = new Vector<String>();
		Collection<Integer> coll4 = coll3;//编译通过
		
		//coll4 = new Vector<String>();泛型不存在继承关系
		
		Map<String,Integer> map = new HashMap();
		
		map.put("sss",1);
		map.put("ggg",2);
		map.put("ddd",3);
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for(Entry<String,Integer> entry: entrySet) {
			System.out.println(entry.getKey() +":"+entry.getValue());
		}
	}
	
	public static void printCollection1(Collection<Object> coll) {
		for(Object obj: coll) {
			System.out.println(obj);
		}
	/*	coll.add("add");//正确
		coll = new HashSet<Date>();//报错*/
	}
	
	public static void printCollection2(Collection<?> coll) {
		for(Object obj: coll) {
			System.out.println(obj);
		}
		/*coll.add("dddd");//报错，因为它不知道自己匹配就一定是String
		coll.size();//没错，此方法与类型参数没有关系
		coll = new HashSet<Date>();//不报错*/
		//使用？通配符可以引用其他各种参数化的类型，？通配符定义的变量主要用作引用
		//可以调用与参数无关的方法，不能调用与参数化有关的方法
	}
}
