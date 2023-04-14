package org.example;

import java.util.function.Consumer;

/**
 * 新造的流概念，类似 Java 的 Stream ，Kotlin 里的 Sequence
 */
@FunctionalInterface
public interface Seq<T> {
	void consume(Consumer<T> consumer);


	/**
	 * 定义了 Seq 的单位元操作
	 */
	static <T> Seq<T> unit(T t) {
		return c -> c.accept(t);
	}
}
