package org.example;

import java.util.function.Consumer;

/**
 *
 * 新造的流概念，类似 Java 的 Stream ，Kotlin 里的 Sequence
 * */
public interface Seq<T> {
	void consume(Consumer<T> consumer);
}
