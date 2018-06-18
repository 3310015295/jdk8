package com.luo.review.ploymorphism;

/**
 * 覆盖父类的方法和属性
 * @author ljp
 *
 */
public class PolyMeth {
	public static void main(String[] args) {
		fu f = new A();
		
		 //System.out.println(f.num);//这里定义的是父类，而成员变量没有多态，所以即使你new的子类，依然指向父类的成员变量。  
		 
		System.out.println(f.fun1());
	}
}
class fu{
	public String num = "父类成员变量";  
	
	public void show() {
		 System.out.println(this.num);//因为成员变量没有多态，所以this指向当前类对象的成员变量。  
	        System.out.println(this.fun1());//因为方法有多态，所以this指向new对象的方法。 
	        System.out.println("1:"+this.getClass().getName());
	}
	
	public String fun1() {  
	        System.out.println(this.num);
	        System.out.println("2:"+this);
	        return "父类调用";  
	 }  
}
class A extends fu{
    public String num = "子类成员变量";  
    
    public String fun1() {  
        System.out.println(this.num);//因为成员变量没有多态，所以this指向当前类对象的成员变量。  
        System.out.println("3:"+this);
        return "子类调用";  
    }  
}