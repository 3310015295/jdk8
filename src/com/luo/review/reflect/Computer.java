package com.luo.review.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Computer {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Mainland mainland = new Mainland();
		
		
		File cardFile = new File("card.properties");
		System.out.println(cardFile.exists());
		FileInputStream fis = new FileInputStream(cardFile);
		
		Properties prop = new Properties();
		prop.load(fis);
		for(int i = 0; i < prop.size(); i++) {
			String cardName = prop.getProperty("card"+(i+1));
			if(cardName!=null) {
				Class<?> clazz = Class.forName(cardName);
				CardInterface card = (CardInterface)clazz.newInstance();
				mainland.run(card);
			}
		}
	}
}
