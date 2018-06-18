package com.luo.review.logger;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
/**
 * 日志过滤器：实现java.util.logging.Filter接口
 * 通过将Filter对象设置给Logger对象，可以实现精确控制日志信息的遏制与
 * 传播。
 * @author ljp
 *
 */
public class MyLoggerFilter implements Filter {

	/**
	 * 通过检查record的属性，决定是否过滤
	 * 返回false，表示该LogRecord对应的日志信息会被该Logger遏制
	 * 返回true，表示该LogRecord对应的日志信息会被该logger传播给对应的
	 * Handler对象
	 */
	@Override
	public boolean isLoggable(LogRecord record) {
		System.out.println("（日志记录的相关信息:========）\n"+
				"日志记录器的名称："+record.getLoggerName()
				+"\n日志内容"+record.getMessage()
				+"\n日志等级："+record.getLevel()
				+"\n相关类方法"+record.getSourceClassName()+":"+record.getSourceMethodName());
		
		return false;
	}

}
