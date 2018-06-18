package com.luo.jdk8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestTime {
	
	//5.ʱ����api����ZoneDate��ZonedTime��ZoneDateTime
	@Test
	public void test7() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
		System.out.println(now);
	}
	
	//4.DateTimeFormatterʱ������ڵĸ�ʽ��
	@Test
	public void test6() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy��MM��dd��HHʱmm��ss��");
		LocalDateTime now = LocalDateTime.now();
		String format = dtf.format(now);
		System.out.println(format);
	}
	//3.ʱ��У����TemporaAdjuster: ��ʱ���������һ�������յȲ���
	//TemporalAdjusters:����ͨ����̬�����ṩ�˴����ĳ���TemporalAdjusterʵ��
	@Test
	public void testJsut() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime nextMoth = now.withMonth(1);//��һ��
		System.out.println(nextMoth);
		
		//ʱ�������
		LocalDateTime nextWeekSun = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));//����һ
		System.out.println("����һ: "+nextWeekSun);
		
		//�Զ��� ��һ��������
		LocalDateTime ldt5 = now.with((l) -> {
			LocalDateTime ldt = (LocalDateTime)l;
			DayOfWeek week = ldt.getDayOfWeek();
			if(week.equals(DayOfWeek.SUNDAY)) {
				return ldt.plusDays(1);
			}else if(week.equals(DayOfWeek.SATURDAY)){
				return ldt.plusDays(2);
			}else {
				return ldt.plusDays(3);
			}
		});
		System.out.println(ldt5);
	}
	//duration����������ʱ��֮��ļ��
	//Period���������������ڡ�֮��ļ��

	//2.Instant:ʱ�������unix Ԫ�꣺1970��1��1�� 00��00��00 ��ĳ��ʱ��֮��ĺ���ֵ��
	@Test
	public void test1() {
		Instant ins1 = Instant.now();//��ȡutcʱ��
		System.out.println(ins1);
		
		OffsetDateTime atOffset = ins1.atOffset(ZoneOffset.ofHours(8));//ƫ����
		System.out.println(atOffset);
		
		System.out.println(ins1.toEpochMilli());//ת��Ϊ����ֵ
		
		Instant off = Instant.ofEpochMilli(60);//Ԫ��ƫ��6����
		System.out.println(off);
	}
	
	//1.LocalTime  LocalDate  LocalDateTime
	@Test
	public void testtIME() {
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime dat = LocalDateTime.of(2001, 12, 12, 8, 0,9);
		System.out.println(dat.getHour());
	}
}
