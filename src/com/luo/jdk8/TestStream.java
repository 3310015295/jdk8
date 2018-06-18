package com.luo.jdk8;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TestStream {

	public static void main(String[] args) {
		System.out.println(Season.AUTUMN.lable);
		Season season = Season.valueOf("SPRING");
		System.out.println(Season.valueOf("SPRING"));
		for(Season sea: season.values()) {
			System.out.println(sea);
		}
		
		//枚举类的比较
		System.out.println(Season.AUTUMN.equals(Season.AUTUMN));
		System.out.println(Season.AUTUMN==Season.AUTUMN);
	}
	@Test
	public void testMultip() {
		Instant now = Instant.now();
		
		long sum = LongStream.range(0, 10000000L).reduce(0,Long::sum);
		System.out.println(sum);
		
		Instant end = Instant.now();
		System.out.println();
	}
	//分区
	
	//多级分组
	
	//集合
	@Test
	public void  test4() {
		List<Integer> ins = Arrays.asList(1,89,37,28,12);
		Long count = ins.stream().collect(Collectors.counting());
		System.out.println(count);
		
		Optional<Integer> max = ins.stream().collect(Collectors.maxBy((x,y) -> Integer.compare(x, y)));
		
		System.out.println(max.get());
		
	}
	//归约
	@Test
	public void test3() {
		List<Integer> ins = Arrays.asList(1,89,37,28,12);
		
		Integer sum = ins.stream().reduce(0,(x,y) -> x + y);
		System.out.println(sum);
	}
	/**
	 * 映射
	 * map 接收lambda，将元素转化成其他形式或提取信息。接收一个函数作为参数，该函数会被
	 * 应用到每一个元素上，并将其映射成一个新的元素
	 * flatMap 接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有的流连成一个流
	 */
	//刷选切片
	/**
	 * filter--接收 Lambda，从流中排除某些元素
	 * limit--截断流，使其元素不超过给定数量
	 * skip(n)-跳过元素，返回一个扔掉了前n个元素的流，若流中的元素不足n个，则返回一个空元素
	 * distinct-筛选，通过流所生成的元素的hashcode（）和equals去除重复的元素
	 */
	@Test
	public void test2() {
		List<Person> list = new ArrayList<>();
		list.add(new Person(27, "zhangsan"));
		list.add(new Person(25, "zlisi"));
		list.add(new Person(222, "wang"));
		list.add(new Person(21, "zhaoliu"));
		list.add(new Person(222, "wang"));
		list.add(new Person(99, "tianqi"));
		//筛选
		list.stream().distinct().forEach(System.out::println);
		System.out.println("=============");
		
		//skip跳过前n个
		list.stream().skip(5).forEach(System.out::println);
		System.out.println("=============");
		
		//limit限定数量
		list.stream().limit(2).forEach(System.out::println);
		
		//filter(lambad表达式)
		Stream<Person> stream = list.stream().filter((p) -> {
			System.out.println("strem的中间操作");
			return p.getAge() > 35;
				});
		
		//终止操作
		stream.forEach(System.out::println);
	}
	
	@Test
	public void getStream1() {
		//1.通过Collection系列集合提供的stream()或pallelStream（）
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();
		
		//2.通过Arrays中的静态方法stream（）获取数组流
		Person[] persons = new Person[10];
		
		Stream<Person> stream2 = Arrays.stream(persons);
		
		//3.通过stream类的静态方法创建
		Stream<String> stream3 = Stream.of("a","b","c");
		
		//4.创建无线流
		Stream<Integer> stream4 = Stream.iterate(0,(x) -> x +2);
		stream4.limit(10).forEach(System.out::println);
	}
}
