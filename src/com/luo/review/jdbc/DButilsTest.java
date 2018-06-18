package com.luo.review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DButilsTest {

	@Test
	public void testSelect2() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		String sql = "select * from student";
		
		QueryRunner qr = new QueryRunner(dataSource);//用完后会自动关闭
		List<Student> list = (List<Student>) qr.query( sql, new BeanListHandler(Student.class));
		
		//shou手动关闭conne
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String str = scanner.next();
			if("return".equals(str)) {
				System.out.println("手动结束");
				return;
			}
			if("add".equals(str)) {
				for(int i = 0;i <12;i++) {
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							try {
								System.out.println(Thread.currentThread().getName()+": "+dataSource.getConnection());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}).start();
				}
				continue;
			}
			System.out.println("运行"+str);
		}
	}
	
	@Test
	public void testSelect() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		String sql = "select * from student";
		
		QueryRunner qr = new QueryRunner();
		List<Student> list = (List<Student>) qr.query(conn, sql, new BeanListHandler(Student.class));
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String str = scanner.next();
			if("close".equals(str)) {
				System.out.println("手动关闭连接");
				conn.close();
				continue;
			}
			if("return".equals(str)) {
				System.out.println("手动结束");
				return;
			}
			if("add".equals(str)) {
				for(int i = 0;i <12;i++) {
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							try {
								System.out.println(Thread.currentThread().getName()+": "+dataSource.getConnection());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}).start();
				}
				continue;
			}
			System.out.println("运行"+str);
		}
	}
}
