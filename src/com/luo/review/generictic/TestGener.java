package com.luo.review.generictic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class TestGener {

	public static void main(String[] args) throws Exception{
		//�����Ǹ�������ʹ�õ�
		
		Collection<Integer> coll  = new ArrayList();
		
		coll.add(1);
		
		//coll.addAll("dddd"); ʹ�÷��ͣ�����ֻ��װ���ض����͵�����
		
		//ͨ�����䣬���Ը���������������Ͳ���
		Method addMethod = coll.getClass().getMethod("add", Object.class);
		addMethod.invoke(coll, "ddddd");
		System.out.println(coll);//[1, ddddd]
		
		System.out.println("=======���������ͺ�ԭʼ����============");
		//����������ArrayList<String>; ԭʼ����ArrayList���ɱ�����������
		//�ٲ��������͵����ÿ���ָ��ԭʼ���ͣ�ԭʼ���͵�����Ҳ����ָ�����������
		Collection<Integer> coll1 = new Vector();//��������������ָ��ԭʼ����
		Collection coll2 = new Vector<String>();//
		
		//Collection<Integer> coll3 = new Vector<String>();�������
	
		Collection coll3 = new Vector<String>();
		Collection<Integer> coll4 = coll3;//����ͨ��
		
		//coll4 = new Vector<String>();���Ͳ����ڼ̳й�ϵ
		
		Map<String,Integer> map = new HashMap();
		
		map.put("sss",1);
		map.put("ggg",2);
		map.put("ddd",3);
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for(Entry<String,Integer> entry: entrySet) {
			System.out.println(entry.getKey() +":"+entry.getValue());
		}
	}
	
	public static void printCollection1(Collection<Object> coll) {
		for(Object obj: coll) {
			System.out.println(obj);
		}
	/*	coll.add("add");//��ȷ
		coll = new HashSet<Date>();//����*/
	}
	
	public static void printCollection2(Collection<?> coll) {
		for(Object obj: coll) {
			System.out.println(obj);
		}
		/*coll.add("dddd");//������Ϊ����֪���Լ�ƥ���һ����String
		coll.size();//û���˷��������Ͳ���û�й�ϵ
		coll = new HashSet<Date>();//������*/
		//ʹ�ã�ͨ������������������ֲ����������ͣ���ͨ�������ı�����Ҫ��������
		//���Ե���������޹صķ��������ܵ�����������йصķ���
	}
}
