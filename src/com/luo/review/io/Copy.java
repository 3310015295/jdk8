package com.luo.review.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {
	
	public static void main(String[] args) {
		Copy.copyText2("E:\\workspace8\\jdk8\\card.properties","aaa.properties");
	}
	public static void copyText2(String asc,String desc) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(asc);
			fw = new FileWriter(desc);
			char[] buff = new char[1024];
			int len = 0;
			while((len=fr.read(buff))!=-1) {
				fw.write(buff,0,len);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	//文本文件的复制
	public static void copyText(String asc,String desc) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader(asc));
			bw = new BufferedWriter(new FileWriter(desc));
			
			String line = null;
			while((line=br.readLine())!=null) {
				bw.write(line);
				bw.flush(); 
				bw.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
