package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class SeqTest {


	@Test
	void test() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		// 方法引用 / 方法推导
		Seq<Integer> seq = list::forEach;
		/*
		 * 等价于 Lambda 函数
		 * Seq<Integer> seq = consumer -> list.forEach(consumer);
		 *
		 * 等价于 匿名内部类
		 * Seq<Integer> seq = new Seq<>() {
		 * 	@Override
		 * 	public void consume(Consumer<Integer> consumer) {
		 * 		list.forEach(consumer);
		 * 	}
		 * };
		 *
		 * 等价于 传统的 for 循环
		 * Seq<Integer> seq = c -> {
		 * 	for (Integer i : list) {
		 * 		c.accept(i);
		 * 	}
		 * };
		 *
		 * */

		/*
		 * 由于 list 已知 为[1,2,3]
		 * 等价于
		 * Seq<Integer> seq = c -> {
		 * 	c.accept(1);
		 * 	c.accept(2);
		 * 	c.accept(3);
		 * };
		 * */
	}


	@Test
	void test_underscoreToCamel() {
		SeqTest.underscoreToCamel("");
	}


	static String underscoreToCamel(String str) {
		// Java没有首字母大写方法，随便现写一个
		UnaryOperator<String> capitalize = s ->
			s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
		// 利用生成器构造一个方法的流
		Seq<UnaryOperator<String>> seq = c -> {
			// yield第一个小写函数
			c.accept(String::toLowerCase);
			// 这里IDEA会告警，提示死循环风险，无视即可
			//noinspection InfiniteLoopStatement
			while (true) {
				// 按需yield首字母大写函数
				c.accept(capitalize);
			}
		};
		List<String> split = Arrays.asList(str.split("_"));
		// 这里的zip和join都在上文给出了实现
		return seq.zip(split, Function::apply).join("");
	}
}
