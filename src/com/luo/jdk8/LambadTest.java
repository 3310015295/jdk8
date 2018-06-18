package com.luo.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

public class LambadTest {

	public static void main(String[] args) {
		Integer i1 = LambadTest.opertion(9, x->(x*x));
		Integer i2 = LambadTest.opertion(9, x->(x-1));
		System.out.println(i1);
		System.out.println(i2);
		getOp(23, 45,(x,y) -> x+y);
		getOp(23, 45,(x,y) -> x*y);
	}
	
	//函数四大接口
	public void test5() {
		
	}
	public static Integer opertion(Integer num,MyFun mf) {
		return mf.getValue(num);
	}
	@Test
	public void test4(){
		
	}
	public static void getOp(Integer i1,Integer i2,MyFun2<Integer,Integer> mf) {
         
		System.out.println(mf.getresult(i1, i2));
	}
	@Test
	public void test3() {
		Comparator<Person> com =(x,y) -> {
			if(x.getAge()==y.getAge()) {
				return x.getName().compareTo(y.getName());
			}
			else {
				return -Integer.compare(x.getAge(), y.getAge());
			}
		};
		List<Person> list = new ArrayList<>();
		
		list.add(new Person(27, "zhangsan"));
		list.add(new Person(25, "zlisi"));
		list.add(new Person(222, "wangwu"));
		list.add(new Person(21, "zhaoliu"));
//		Collections.sort(list);
		Collections.sort(list,com);
		for(Person p: list) {
			System.out.println(p);
		}
		
	}
	//有参数有返回值
	@Test
	public void test2() {
		Consumer<String> con = x ->System.out.println(x);
		con.accept("dddd");
	}
	//无参数无返回值
	@Test
	public void test1() {
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("普通匿名内部类");
				
			}
		};
		
		r1.run();
		
		Runnable r2 = () ->System.out.println("lamdab表达式");
		r2.run();
	}
}
