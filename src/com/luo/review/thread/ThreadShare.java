package com.luo.review.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程共享数据
 * @author ljp
 *
 */
public class ThreadShare {

	private static int data = 0;
	private static Map<Thread,Integer> threadDate= new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		
		for(int i = 0; i <2; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int data = new Random().nextInt();
					ThreadShare.data = data;
					threadDate.put(Thread.currentThread(), data);
					System.out.println(Thread.currentThread().getName()+":set data = "+ data);
					new A().getData();
					new B().getData();
				}
			}).start();
		}
	}
	
	static class A{
		public void getData() {
			int data = threadDate.get(Thread.currentThread());
			System.out.println("A对象："+ Thread.currentThread().getName() +"数据:"+data);
		}
	}
	
	static class B{
		public void getData() {
			int data = threadDate.get(Thread.currentThread());
			System.out.println("a对象："+ Thread.currentThread().getName() +"数据:"+data);
		}
	}
}
