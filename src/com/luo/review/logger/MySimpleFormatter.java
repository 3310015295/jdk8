package com.luo.review.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * ��־��ʽ����
 * @author ljp
 *
 */
public class MySimpleFormatter extends Formatter{

	//�������ص� String ������Ǳ� Handler ��󷵻ظ��ⲿϵͳ�����ս����
	//ͨ�������Լ��� Formatter ����Java����ʦ������ȫ�ؿ�����־��Ϣ��ʽ��
	@Override
	public String format(LogRecord record) {
		System.out.println("����־��¼�������Ϣ:========��\n"+
							"��־��¼�������ƣ�"+record.getLoggerName()
							+"\n��־����"+record.getMessage()
							+"\n��־�ȼ���"+record.getLevel()
							+"\n����෽��"+record.getSourceClassName()+":"+record.getSourceMethodName());
		return record.getLevel()+record.getMessage();
	}

}
