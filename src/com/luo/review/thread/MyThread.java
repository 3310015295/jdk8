package com.luo.review.thread;

public class MyThread {
 
	public static void main(String[] args) {
		
		//方式一，继承Thread
		Thread th = new Thread() {
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName());
				}
			};
		};
		th.start();
		
		//方式二：实现runnable接口
		Thread th2 = new Thread( new Runnable(){
			{
		}
			
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		});
		th2.start();
	}
}
