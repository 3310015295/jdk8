package com.luo.review.reflect;

public class NetCard implements CardInterface{

	@Override
	public void open() {
		System.out.println("Íø¿¨¿ªÆô");
		
	}

	@Override
	public void close() {

		System.out.println("Íø¿¨¹Ø±Õ");
	}

}
