package com.luo.jdk8;

public enum Season {

	SPRING("´º"),SUMMER("ÏÄ"),AUTUMN("Çï"),WINTER("¶¬");
	
	public String lable;
	
	private Season(String ji) {
		this.lable = ji;
	}
	
	public  String getJi() {
		
		return lable;
	}
}
