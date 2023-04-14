package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class SeqTest {


	@Test
	void test() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Seq<Integer> seq = list::forEach;
		/*
		* 等价于 Lambda Expression
		* Seq<Integer> seq = consumer -> list.forEach(consumer);
		* 亦等价于 匿名内部类
		* Seq<Integer> seq = new Seq<>() { @Override public void consume(Consumer<Integer> consumer) { list.forEach(consumer); } };
		*
		* */
	}

}
