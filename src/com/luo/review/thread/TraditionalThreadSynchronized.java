package com.luo.review.thread;
/**
 * 演示多线程不安全
 * @author ljp
 *
 */
public class TraditionalThreadSynchronized {
	
	public static void main(String[] args) {
		final OutPut outPut = new OutPut();
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					outPut.out("张三");
				}
			}
		};
		
		thread.start();
		
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				while(true) {
					outPut.out("李四");
				}
			}
		};
		
		thread2.start();
	};

}
class OutPut{
	/*public void out(String name) {
		
		for(int i = 0; i < name.length(); i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==name.length()-1) {
				System.out.println(name.charAt(i));
			}else{
				System.out.print(name.charAt(i));
			}
		}
	}*/
	/*public synchronized void out(String name) {
			
			for(int i = 0; i < name.length(); i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==name.length()-1) {
					System.out.println(name.charAt(i));
				}else{
					System.out.print(name.charAt(i));
				}
			}
		}*/
	public void out(String name) {
			synchronized (OutPut.class) {
				
				for(int i = 0; i < name.length(); i++) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(i==name.length()-1) {
						System.out.println(name.charAt(i));
					}else{
						System.out.print(name.charAt(i));
					}
				}
			}
		}
}
