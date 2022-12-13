package com.practice.aop;

/**
 * .
 *
 * @author zhouqiang
 */
public class HelloInterceptor implements Interceptor {
	@Override
	public void invoke(Invoke invoke) {
		System.out.println("执行前");
		try {
			invoke.invoke();
		} catch (Exception e) {
			System.out.println("假如出现错误");
		}
		System.out.println("执行后");
	}
}
