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
		
		//ö����ıȽ�
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
	//����
	
	//�༶����
	
	//����
	@Test
	public void  test4() {
		List<Integer> ins = Arrays.asList(1,89,37,28,12);
		Long count = ins.stream().collect(Collectors.counting());
		System.out.println(count);
		
		Optional<Integer> max = ins.stream().collect(Collectors.maxBy((x,y) -> Integer.compare(x, y)));
		
		System.out.println(max.get());
		
	}
	//��Լ
	@Test
	public void test3() {
		List<Integer> ins = Arrays.asList(1,89,37,28,12);
		
		Integer sum = ins.stream().reduce(0,(x,y) -> x + y);
		System.out.println(sum);
	}
	/**
	 * ӳ��
	 * map ����lambda����Ԫ��ת����������ʽ����ȡ��Ϣ������һ��������Ϊ�������ú����ᱻ
	 * Ӧ�õ�ÿһ��Ԫ���ϣ�������ӳ���һ���µ�Ԫ��
	 * flatMap ����һ��������Ϊ�����������е�ÿһ��ֵ��������һ������Ȼ������е�������һ����
	 */
	//ˢѡ��Ƭ
	/**
	 * filter--���� Lambda���������ų�ĳЩԪ��
	 * limit--�ض�����ʹ��Ԫ�ز�������������
	 * skip(n)-����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص����������е�Ԫ�ز���n�����򷵻�һ����Ԫ��
	 * distinct-ɸѡ��ͨ���������ɵ�Ԫ�ص�hashcode������equalsȥ���ظ���Ԫ��
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
		//ɸѡ
		list.stream().distinct().forEach(System.out::println);
		System.out.println("=============");
		
		//skip����ǰn��
		list.stream().skip(5).forEach(System.out::println);
		System.out.println("=============");
		
		//limit�޶�����
		list.stream().limit(2).forEach(System.out::println);
		
		//filter(lambad���ʽ)
		Stream<Person> stream = list.stream().filter((p) -> {
			System.out.println("strem���м����");
			return p.getAge() > 35;
				});
		
		//��ֹ����
		stream.forEach(System.out::println);
	}
	
	@Test
	public void getStream1() {
		//1.ͨ��Collectionϵ�м����ṩ��stream()��pallelStream����
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();
		
		//2.ͨ��Arrays�еľ�̬����stream������ȡ������
		Person[] persons = new Person[10];
		
		Stream<Person> stream2 = Arrays.stream(persons);
		
		//3.ͨ��stream��ľ�̬��������
		Stream<String> stream3 = Stream.of("a","b","c");
		
		//4.����������
		Stream<Integer> stream4 = Stream.iterate(0,(x) -> x +2);
		stream4.limit(10).forEach(System.out::println);
	}
}
