package com.luo.review.logger;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
/**
 * ��־��������ʵ��java.util.logging.Filter�ӿ�
 * ͨ����Filter�������ø�Logger���󣬿���ʵ�־�ȷ������־��Ϣ�Ķ�����
 * ������
 * @author ljp
 *
 */
public class MyLoggerFilter implements Filter {

	/**
	 * ͨ�����record�����ԣ������Ƿ����
	 * ����false����ʾ��LogRecord��Ӧ����־��Ϣ�ᱻ��Logger����
	 * ����true����ʾ��LogRecord��Ӧ����־��Ϣ�ᱻ��logger��������Ӧ��
	 * Handler����
	 */
	@Override
	public boolean isLoggable(LogRecord record) {
		System.out.println("����־��¼�������Ϣ:========��\n"+
				"��־��¼�������ƣ�"+record.getLoggerName()
				+"\n��־����"+record.getMessage()
				+"\n��־�ȼ���"+record.getLevel()
				+"\n����෽��"+record.getSourceClassName()+":"+record.getSourceMethodName());
		
		return false;
	}

}
