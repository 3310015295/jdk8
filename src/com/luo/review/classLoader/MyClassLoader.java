package com.luo.review.classLoader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader {

	//加密、解密；原理m^n^n = m;
	public static void cyphe(InputStream ins,OutputStream ous) throws Exception {
		int b = 0;
		while((b=ins.read())!=-1) {
			ous.write(b ^ 0Xff);//异或一个数加密，再次异或同一个数还原
		}
	}
	
	private String classDir;//自定义类加载器加载的class文件目录
	
	public MyClassLoader() {
		// TODO Auto-generated constructor stub
	}
	public MyClassLoader(String classDir) {
		
		this.classDir = classDir;
	}
	
	//调用loadClass时会先根据委派模型在父加载器中加载，如果加载失败，则会调用当前加载器的findClass来完成加载
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classFileName = classDir +"\\"+name.substring(name.lastIndexOf(".")+1)+".class";
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			fis = new FileInputStream(classFileName);
			bos = new ByteArrayOutputStream();
			cyphe(fis, bos);//将class文件写入bos流中，同时再次异或运算解密原加密的class文件
			byte[] bytes = bos.toByteArray();
			
			//defineClass方法可以把二进制流字节组成的文件转换为一个Class  
			return this.defineClass(name,bytes, 0, bytes.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return super.findClass(name);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		String srcpath = args[0];
		String destDir = args[1];
		
		String destFileName = srcpath.substring(srcpath.lastIndexOf("\\")+1);
		String destPath = destDir+"\\"+destFileName;
		FileInputStream fis = new FileInputStream(srcpath);
		
		FileOutputStream fos = new FileOutputStream(destPath);
		cyphe(fis,fos);
		fis.close();
		fos.close();
		System.out.println(destPath);
		
	}
	
}
