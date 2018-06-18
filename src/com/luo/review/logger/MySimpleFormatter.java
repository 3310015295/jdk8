package com.luo.review.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * 日志格式化器
 * @author ljp
 *
 */
public class MySimpleFormatter extends Formatter{

	//方法返回的 String 对象就是被 Handler 最后返回给外部系统的最终结果。
	//通过创建自己的 Formatter 对象，Java工程师可以完全地控制日志信息格式。
	@Override
	public String format(LogRecord record) {
		System.out.println("（日志记录的相关信息:========）\n"+
							"日志记录器的名称："+record.getLoggerName()
							+"\n日志内容"+record.getMessage()
							+"\n日志等级："+record.getLevel()
							+"\n相关类方法"+record.getSourceClassName()+":"+record.getSourceMethodName());
		return record.getLevel()+record.getMessage();
	}

}
