package com.luo.review.reflect;

public class Mainland {

	public Mainland() {
		System.out.println("�������С���������");
	}
	
	public void run(CardInterface card) {
		card.open();
		
		card.close();
	}
}
