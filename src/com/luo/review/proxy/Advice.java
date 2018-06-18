package com.luo.review.proxy;

import java.lang.reflect.Method;

public interface Advice {

	void methodBefore(Method method);
	
	void methodAfter(Method method);
}
