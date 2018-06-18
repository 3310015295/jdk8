package com.luo.review.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接池
 * ①从c3p0
 * @author ljp
 *
 */
public class ConnPool {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static void main(String[] args) throws Exception {
//		 System.out.println(getC3p01());
		//System.out.println(getdbcp());
		Scanner scanner = new Scanner(System.in);
		String str ="";
		while(true) {
			//创建五个线程，开启连接
			for(int i = 0;i <12;i++) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							System.out.println(Thread.currentThread().getName()+": "+getC3p01());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}).start();
				System.out.println(i+"次");
			}
			str = scanner.next();
			if("stop".equals(str)) {
				System.out.println("程序停止");
				break;
			}
		}
	}
	
	//dbcp
	/*public static Connection getdbcp() throws Exception {
		InputStream ins  = ConnPool.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		Properties prop = new Properties();
		prop.load(ins);
		
		BasicDataSourceFactory basicDataSourceFactory = new BasicDataSourceFactory();
		DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
		Connection conn = dataSource.getConnection();
		return conn;
	}*/
	//C3P0
	public static Connection getC3p01() throws Exception {
		
        //方式一：通过代码创建C3P0数据库连接池
        /*ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcstudy");
        ds.setUser("root");
        ds.setPassword("XDP");
        ds.setInitialPoolSize(10);
        ds.setMinPoolSize(5);
        ds.setMaxPoolSize(20);*/
		
		//方式二：通过读取C3P0的xml配置文件创建数据源，C3P0的xml配置文件c3p0-config.xml必须放在src目录下
		//①使用C3P0的默认配置来创建数据源
		//ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//②使用C3P0的命名配置来创建数据源
		//dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		
		return conn;
	}
}
