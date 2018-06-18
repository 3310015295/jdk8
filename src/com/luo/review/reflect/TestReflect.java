package com.luo.review.reflect;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.luo.jdk8.Person;

public class TestReflect {

	Class<?> clazz;
	Person p = new Person();
	@Before
	public void init() throws ClassNotFoundException {
		clazz = Class.forName("com.luo.jdk8.Person");
		
	}
	
	//反射，获取泛型的实际参数
	@Test
	public void testGeneric() throws Exception {
		//public void printColl(Collection<String> coll)
		Method printMethod = TestReflect.class.getMethod("printColl", Collection.class);
		Type[] typesParams = printMethod.getGenericParameterTypes();//获取方法的所有参数
		ParameterizedType paramType = (ParameterizedType) typesParams[0];
		System.out.println(paramType.getRawType());//colletion;获取方法参数的类型
		System.out.println(paramType.getActualTypeArguments()[0]);//string;获取方法参数的具体类型
	}
	
	//5.Method：
	@Test
	public void testMethod() throws Exception{
		Method setAgeMethod = clazz.getMethod("setAge", int.class);
		//调用特定对象p的相应方法
		setAgeMethod.invoke(p,45);
		System.out.println(p);
	}
	
	//4.Field: 获取、赋值、修饰符、声明类型
	@Test
	public void testFiled() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		

		Field field2 = clazz.getField("address");
		Field field3 = clazz.getDeclaredField("age");
		System.out.println(field2);
		System.out.println(field3);
		
		//给特定对象的对应属性赋值
		field2.set(p, "alilialili");
		System.out.println(field2.get(p));
		System.out.println("field2属性声明类型："+field2.getType());
		System.out.println("field2修饰符："+field2.getModifiers());
		//允许对私有属性操作
		field3.setAccessible(true);
		//获取特定对象相应属性的值
		System.out.println(field3.get(p));
		System.out.println("field3属性声明类型："+field3.getType());
		System.out.println("field3修饰符："+field3.getModifiers());
		
		Field[] fields = clazz.getFields();
		for(Field field:fields) {
			System.out.println(field);
		}
	}
	//3.获取构造器
	@Test
	public void testGetContrust() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<?>[] cons = String.class.getConstructors();
		for(Constructor con:cons) {
			System.out.println(con);
		}
		Constructor<?> cost = clazz.getConstructor();
		Person p = (Person)cost.newInstance();
		System.out.println(p);
		
		Constructor<?> cost2 = clazz.getDeclaredConstructor(int.class,String.class);
		Object obj = cost2.newInstance(18,"zhangsan");
		System.out.println(obj);
	}
	//2.直接获取实例对象
	@Test
	public void testInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("com.luo.jdk8.Person");
		
		Person person = (Person)clazz.newInstance();
		
		System.out.println(person);
	}
	//1.获取class对象
	@Test
	public void testClass() throws ClassNotFoundException {
		
		//①根据类的class属性获取
		Class clazz1 = Person.class;
		
		//②根据实例的getclass方法获取
		Person person = new Person();
		
		Class<? extends Person> clazz2 = person.getClass();
		
		
		//③根据全类名获取
		Class<?> clazz3 = Class.forName("com.luo.jdk8.Person");
		
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		
	}
	public void printColl(Collection<String> coll) {
		
	}
	public static void main(String[] args) throws Exception {
		
		//InputStream is = TestReflect.class.getClassLoader().getResourceAsStream("com/luo/review/reflect/config.properties");
		InputStream is = TestReflect.class.getClassLoader().getResourceAsStream("com/luo/jdk8/config.properties");
//		InputStream is = TestReflect.class.getClassLoader().getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(is);
		String className = props.getProperty("key");
		System.out.println(className);
		Class<?> clazz = Class.forName(className);
		Collection coll = (Collection)clazz.newInstance();
		
		coll.add("123");
		coll.add("123");
		coll.add("1");
		coll.add("3");
		System.out.println(coll.size());
	}
}
