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
		
		//wl���ü��𣬶��Ƶ���WARNING�������µ���־
		logger_wl.setLevel(Level.WARNING);
		logger_wlc.setLevel(Level.INFO);
		
		logger_wl.addHandler(new ConsoleHandler());
		logger_wlc.addHandler(new ConsoleHandler());
		
		logger_w.info("msg:www");
		logger_wl.info("msg: www.luo");
		logger_wlc.info("msg:www.luo.com");
		
		System.out.println("w������־�ļ���"+logger_w.getParent().getLevel());
		System.out.println("wl��־�ļ���"+logger_wl.getLevel());
		System.out.println("wl:�ĸ����ǣ�"+logger_wl.getParent().getName());
		System.out.println("wlc�ĸ����ǣ� "+logger_wlc.getParent().getName());
		System.out.println("w��handler�� "+ logger_w.getHandlers().getClass());
	
	}
	@Test
	public void testGlobal() throws SecurityException, IOException {
		//Logger logger_www = Logger.getLogger("www");
		Logger logger = Logger.getLogger("www.myloger");
		System.out.println("��־������:"+logger.getHandlers().getClass().getName());
		System.out.println("��־��¼�����ࣺ"+logger.getParent().getName());//RootLogger
		System.out.println("��־��¼����������"+logger.getFilter());//Ĭ��null
		System.out.println("��־��¼��Leve:"+logger.getLevel());//û�У��̳и���
		
		//1.������
		//ConsoleHandler handler = new ConsoleHandler();
		FileHandler handler = new FileHandler();
		System.out.println(handler.getFormatter().getHead(handler));
		
		//handler.setFormatter(new MySimpleFormatter());//����־��������Ӹ�ʽ����
		
		logger.setUseParentHandlers(false);//��ʹ�ø���Ĭ�ϵ�handler
		logger.addHandler(handler);//��Ӵ�����
		
		//Filter ������
		/*MyLoggerFilter filter = new MyLoggerFilter();
		logger.setFilter(filter);
		handler.setFilter(filter);*/
		logger.info("msg����־��Ϣ");
		logger.warning("sss");
		logger.entering(TestLogger.class.getName(), "testGlobal");
		
	}
	//2��־��¼��
	@Test
	public void testLogger() {
		
		//1.������־��¼��
		Logger logger = Logger.getLogger(TestLogger.class.getName());
		
		System.out.println(logger.toString());
		System.out.println(logger.getParent().toString());
		
		/**
		 * 2.��־����
		 *   ����������־��Ϣ����߳������ܡ�
		 * 	 Level�Ķ�Ӧ��Ϊjava.util.logging.Level,����ʹ���ַ�����������Ӧ
		 * ��ͬ�ļ��𡣣�SERVER��WARNING��INFO��CONFIG��FINE��FINER��FINEST��
		 * 	 �û��ƹ������ֶ�����Ծ���Level(��־��Ϣ��Logger����Handler����)
		 * �����ֶ����LEVEL֮�����Դ�С��ϵ�����˾�����־��Ϣ�����ܷ����
		 * ע�⣺ÿ��Logger����������ȷ����logger,���û����ȷ��LEVEL,�ͻ�ʹ��
		 * �̳л��ƻ�ȡ����Logger�����Level��Ϊ�Լ���Level
		 */
		//2.1������־��Ϣ��Level
		logger.log(Level.SEVERE, "sssss");
		
		//2.2������־��Ϣ������� Level ��Logger ����Ҳͬ������ Level ��
		//ͨ������ Logger ����� Level ��ʹ�� Logger ������Դ������߶���
		//ĳЩ�����ض� Level ����־��Ϣ
		logger.setLevel(Level.WARNING);
		
		//2.3Handler ����Ҳ���Ծ���  Level ��������־��Ϣ�� Level �����ˡ�
		//Handler ������� Level �ķ�ʽ�� Logger ������� Level �ķ�ʽ������ͬ
	}
	
	//1.������־������
	@Test
	public void testLoggerMannager() {
				LogManager logManager = LogManager.getLogManager();
				System.out.println(logManager.toString());
	}
}
