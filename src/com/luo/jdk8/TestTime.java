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
	
	//5.时区的api操作ZoneDate、ZonedTime、ZoneDateTime
	@Test
	public void test7() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
		System.out.println(now);
	}
	
	//4.DateTimeFormatter时间和日期的格式化
	@Test
	public void test6() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
		LocalDateTime now = LocalDateTime.now();
		String format = dtf.format(now);
		System.out.println(format);
	}
	//3.时间校正器TemporaAdjuster: 将时间调整到下一个工作日等操作
	//TemporalAdjusters:该类通过静态方法提供了大量的常用TemporalAdjuster实现
	@Test
	public void testJsut() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime nextMoth = now.withMonth(1);//上一月
		System.out.println(nextMoth);
		
		//时间矫正器
		LocalDateTime nextWeekSun = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));//下周一
		System.out.println("下周一: "+nextWeekSun);
		
		//自定义 下一个工作日
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
	//duration：计算两个时间之间的间隔
	//Period：计算两个“日期”之间的间隔

	//2.Instant:时间戳（以unix 元年：1970年1月1日 00：00：00 到某个时间之间的毫秒值）
	@Test
	public void test1() {
		Instant ins1 = Instant.now();//获取utc时间
		System.out.println(ins1);
		
		OffsetDateTime atOffset = ins1.atOffset(ZoneOffset.ofHours(8));//偏移量
		System.out.println(atOffset);
		
		System.out.println(ins1.toEpochMilli());//转化为毫秒值
		
		Instant off = Instant.ofEpochMilli(60);//元年偏离6分钟
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
