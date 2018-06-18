package com.luo.review.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

public class TestLogger {

	public static void main(String[] args) {
		
		Logger logger_w = Logger.getLogger("www");
		Logger logger_wl = Logger.getLogger("www.luo");
		Logger logger_wlc = Logger.getLogger("www.luo.com");
		
		//wl设置级别，遏制低于WARNING级别以下的日志
		logger_wl.setLevel(Level.WARNING);
		logger_wlc.setLevel(Level.INFO);
		
		logger_wl.addHandler(new ConsoleHandler());
		logger_wlc.addHandler(new ConsoleHandler());
		
		logger_w.info("msg:www");
		logger_wl.info("msg: www.luo");
		logger_wlc.info("msg:www.luo.com");
		
		System.out.println("w父类日志的级别："+logger_w.getParent().getLevel());
		System.out.println("wl日志的级别："+logger_wl.getLevel());
		System.out.println("wl:的父类是："+logger_wl.getParent().getName());
		System.out.println("wlc的父类是： "+logger_wlc.getParent().getName());
		System.out.println("w的handler是 "+ logger_w.getHandlers().getClass());
	
	}
	@Test
	public void testGlobal() throws SecurityException, IOException {
		//Logger logger_www = Logger.getLogger("www");
		Logger logger = Logger.getLogger("www.myloger");
		System.out.println("日志处理器:"+logger.getHandlers().getClass().getName());
		System.out.println("日志记录器父类："+logger.getParent().getName());//RootLogger
		System.out.println("日志记录器过滤器："+logger.getFilter());//默认null
		System.out.println("日志记录器Leve:"+logger.getLevel());//没有，继承父类
		
		//1.处理器
		//ConsoleHandler handler = new ConsoleHandler();
		FileHandler handler = new FileHandler();
		System.out.println(handler.getFormatter().getHead(handler));
		
		//handler.setFormatter(new MySimpleFormatter());//给日志处理器添加格式化类
		
		logger.setUseParentHandlers(false);//不使用父类默认的handler
		logger.addHandler(handler);//添加处理器
		
		//Filter 过滤器
		/*MyLoggerFilter filter = new MyLoggerFilter();
		logger.setFilter(filter);
		handler.setFilter(filter);*/
		logger.info("msg：日志消息");
		logger.warning("sss");
		logger.entering(TestLogger.class.getName(), "testGlobal");
		
	}
	//2日志记录器
	@Test
	public void testLogger() {
		
		//1.创建日志记录器
		Logger logger = Logger.getLogger(TestLogger.class.getName());
		
		System.out.println(logger.toString());
		System.out.println(logger.getParent().toString());
		
		/**
		 * 2.日志级别
		 *   用来过滤日志信息和提高程序性能。
		 * 	 Level的对应类为java.util.logging.Level,该类使用字符串常量来对应
		 * 不同的级别。（SERVER、WARNING、INFO、CONFIG、FINE、FINER、FINEST）
		 * 	 该机制共有三种对象可以具有Level(日志信息、Logger对象、Handler对象)
		 * 这三种对象的LEVEL之间的相对大小关系决定了具体日志信息最终能否被输出
		 * 注意：每个Logger对象必须具有确定的logger,如果没有明确的LEVEL,就会使用
		 * 继承机制获取祖先Logger对象的Level作为自己的Level
		 */
		//2.1设置日志信息的Level
		logger.log(Level.SEVERE, "sssss");
		
		//2.2不仅日志信息本身具有 Level ，Logger 对象也同样具有 Level 。
		//通过设置 Logger 对象的 Level ，使得 Logger 对象可以传播或者遏制
		//某些具有特定 Level 的日志信息
		logger.setLevel(Level.WARNING);
		
		//2.3Handler 对象也可以具有  Level 并根据日志信息的 Level 来过滤。
		//Handler 对象操作 Level 的方式与 Logger 对象操作 Level 的方式基本相同
	}
	
	//1.创建日志管理器
	@Test
	public void testLoggerMannager() {
				LogManager logManager = LogManager.getLogManager();
				System.out.println(logManager.toString());
	}
}
