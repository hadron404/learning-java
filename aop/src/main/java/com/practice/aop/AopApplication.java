package com.practice.aop;

public class AopApplication {

	public static void main(String[] args) {
		Hello hello = Aop.get(Hello.class);
		Aop.invoke(new HelloInterceptor(), hello::test);
	}
}
