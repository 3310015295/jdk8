package com.luo.review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;
/**
 * 获取数据库连接、关闭资源
 * statment和prepareStatment的增删改查
 * @author ljp
 *
 */
public class StatementTest {
	private static ThreadLocal<Connection> th = new ThreadLocal<Connection>();
	public static void main(String[] args) throws Exception {
		//statmentGet();
		//System.out.println(statmentupdate());
//		preparedStatmentGet();
		//System.out.println(prepareStatementUpdate());
		String str = "";
		Scanner scanner = new Scanner(System.in);
		Connection conn = getConn();
		th.set(conn);
		while(true) {
			
			str = scanner.next();
			System.out.println("threadLocal上的conn取出来的"+(conn==th.get()));
			if("remove".equals(str)) {
				th.remove();
				System.out.println("去除th上的conn,使用coon直接的查询"+th.get());
				statmentGet(conn);
				continue;
			}
			if("close".equals(str)) {
				conn.close();
				System.out.println("关闭conn,使用th上的查询"+th.get());
				statmentGet(th.get());
				continue;
			}
			if("stop".equals(str)) {
				System.out.println("程序停止");
				break;
			}
			System.out.println("您输入的是"+str+";继续输入");
		}
	}
	
	public static int prepareStatementUpdate() throws Exception{
		Connection conn = getConn();
		
		String sql = "update student set username = ? where uuid = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "jkjklex");
		statement.setInt(2, 17);
		
		int num = statement.executeUpdate();
		 return num;
	}
	//二、preparedStatement 查询(预编译，占位符）
	public static void preparedStatmentGet() throws Exception {
		
		Connection conn = getConn();
		
		//1.通过连接获取执行器(预编译）
		String sql = "select * from student where uuid > ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		
		//2.填充占位符(占位符角标1开始）
		statement.setObject(1, 10);;
		
		//2.发送sql语句，查询操作executeQuery()，获取结果集
		ResultSet rs = statement.executeQuery();
		
		//查询结果的元数据
		ResultSetMetaData rmd = rs.getMetaData();
		//查询结果的列数
		int columnCount = rmd.getColumnCount();
		
		//3.对查询结果操作
		while (rs.next()) {
			for(int i = 0; i < columnCount; i++) {
				//查询结果的列名
				String columnLabel = rmd.getColumnLabel(i+1);
				//通过列名获取值
				Object columnValue = rs.getObject(columnLabel);
				System.out.println(columnLabel+"："+columnValue);
			}
			System.out.println();
		}
		
	}
	
	//二、statement 增删改
	public static int statmentupdate() throws Exception {
		
		Connection conn = getConn();
		
		//1.通过连接获取执行器
		Statement statement = conn.createStatement();
		
		String sql = "insert into student(username,birthDay) values('wangwu','1997-1-9')";
		
		//2.发送sql语句，更新executeQuery(sql)，返回影响的行数
		int num = statement.executeUpdate(sql);
		
		return num;
		
	}
	//二、statement 查询操作
	public static void statmentGet(Connection conn) throws Exception {
		
		//Connection conn = getConn();
		
		//1.通过连接获取执行器
		Statement statement = conn.createStatement();
		
		String sql = "select * from student";
		
		//2.发送sql语句，查询操作executeQuery(sql)，获取结果集
		ResultSet rs = statement.executeQuery(sql);
		//查询结果的元数据
		ResultSetMetaData rmd = rs.getMetaData();
		//查询结果的列数
		int columnCount = rmd.getColumnCount();
		
		//3.对查询结果操作
		while (rs.next()) {
			for(int i = 0; i < columnCount; i++) {
				//查询结果的列名
				String columnLabel = rmd.getColumnLabel(i+1);
				//通过列名获取值
				Object columnValue = rs.getObject(columnLabel);
				System.out.println(columnLabel+"："+columnValue);
			}
			System.out.println();
		}
		
	}
	//一、关闭资源
	public static void release(Connection conn, Statement state, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(state!=null) {
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//一、获取连接
	public static Connection getConn() throws Exception {
		 String url = "jdbc:mysql://localhost:3306/myjdbc";
		 String user = "root";
		 String password = "123456";
		 
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接
		Connection conn = DriverManager.getConnection(url,user,password);
		
		//System.out.println(conn);
		return conn;
	}
	

}
