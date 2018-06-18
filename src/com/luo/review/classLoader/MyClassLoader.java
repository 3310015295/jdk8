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

	//���ܡ����ܣ�ԭ��m^n^n = m;
	public static void cyphe(InputStream ins,OutputStream ous) throws Exception {
		int b = 0;
		while((b=ins.read())!=-1) {
			ous.write(b ^ 0Xff);//���һ�������ܣ��ٴ����ͬһ������ԭ
		}
	}
	
	private String classDir;//�Զ�������������ص�class�ļ�Ŀ¼
	
	public MyClassLoader() {
		// TODO Auto-generated constructor stub
	}
	public MyClassLoader(String classDir) {
		
		this.classDir = classDir;
	}
	
	//����loadClassʱ���ȸ���ί��ģ���ڸ��������м��أ��������ʧ�ܣ������õ�ǰ��������findClass����ɼ���
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classFileName = classDir +"\\"+name.substring(name.lastIndexOf(".")+1)+".class";
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			fis = new FileInputStream(classFileName);
			bos = new ByteArrayOutputStream();
			cyphe(fis, bos);//��class�ļ�д��bos���У�ͬʱ�ٴ�����������ԭ���ܵ�class�ļ�
			byte[] bytes = bos.toByteArray();
			
			//defineClass�������԰Ѷ��������ֽ���ɵ��ļ�ת��Ϊһ��Class  
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
