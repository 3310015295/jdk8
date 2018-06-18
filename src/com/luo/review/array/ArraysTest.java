package com.luo.review.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArraysTest {

	
	/**
	 * Arrays 数组工具类，对数组操作
	 */
	//将数组变为集合
	
	/**
	 * 这样可以通过集合的操作来操作数组中元素，
　　但是不可以使用增删方法，add，remove。因为数组长度是固定的，会出现UnsupportOperationExcetion。
　　可以使用的方法：contains，indexOf。。。
　　如果数组中存入的基本数据类型，那么asList会将数组实体作为集合中的元素。
　　如果数组中的存入的引用数据类型，那么asList会将数组中的元素作为集合中的元素。
	 */
	@Test
	public void asList() {
		
		int[]  array = {4,90,79,12,3,3};
		//基本数据类型会将数据整体作为一个元素存放入list集合
		List<int[]> list = Arrays.asList(array);
		
		//引用数据类型，那么asList会将数组中的元素作为集合中的元素
		String[] strs = {"7","1","dd"};
		List<String> list2 = Arrays.asList(strs);
		//boolean flag = list2.add("不能添加");//不能进行remove和add操作出现UnsupportOperationExcetion
		list2.set(0, "改变");
		System.out.println(list2.get(0)+":");
	}
	
	//比较两个数组是否相等
	@Test
	public void equals() {
		
		int[]  array = {4,90,79,12,3,3};
		int[] copy1 = Arrays.copyOfRange(array, 1,array.length-1);
		
		System.out.println(Arrays.toString(copy1));
	}
	//复制部分数组
	@Test
	public void copyPart() {
		
		int[]  array = {4,90,79,12,3,3};
		int[]  array2 = {90,79,12,3,3};
		boolean flag = Arrays.equals(array, array2);
		System.out.println(flag);
	}
	
	//4.复制数组
	@Test
	public void copy() {
		
		int[]  array = {4,90,79,12,3,3};
		int[] copy1 = Arrays.copyOf(array, array.length-1);
		int[] copy2 = Arrays.copyOf(array, array.length+1);
		
		System.out.println(Arrays.toString(copy1)+"\n"+Arrays.toString(copy2));
	}
	
	//3.将数组变为字符串
	@Test
	public void getString() {
		int[]  array = {4,90,79,12,3,3};
		
		String str = Arrays.toString(array);//[4, 90, 79, 12, 3, 3]
		System.out.println(str);
	}
	
	//binarySearch（array,key）二分法查找，数组必须有序
	@Test
	public void binarySearch() {
		int[]  array = {4,90,79,12,3,3};
		Arrays.sort(array);
		
		int point = Arrays.binarySearch(array, 12);//必须是有序数组，否则返回-2，表示错误
		
		System.out.println(point);
	}
	//1.sort()排序
	@Test
	public void sort() {
		int[]  array = {4,90,79,12,3,3};
		
		Arrays.sort(array);
		
		System.out.println(Arrays.toString(array));
	}
}
