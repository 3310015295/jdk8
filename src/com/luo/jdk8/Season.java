package com.luo.jdk8;

public enum Season {

	SPRING("��"),SUMMER("��"),AUTUMN("��"),WINTER("��");
	
	public String lable;
	
	private Season(String ji) {
		this.lable = ji;
	}
	
	public  String getJi() {
		
		return lable;
	}
}
