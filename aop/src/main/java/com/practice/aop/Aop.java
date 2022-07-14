package com.practice.aop;

/**
 * .
 *
 * @author zhouqiang
 */
public class Aop {
	public static <T> T get(Class<T> clazz) {
		try {
			return clazz.getConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("获取实例化对象失败");
		}
	}

	public static void invoke(Interceptor interceptor, Invoke invoke) {
		interceptor.invoke(invoke);
	}
}
