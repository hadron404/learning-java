package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 新造的流概念，类似 Java 的 Stream ，Kotlin 里的 Sequence
 */
@FunctionalInterface
public interface Seq<T> {
	/**
	 * consumer of consumer
	 */
	void consume(Consumer<T> consumer);


	/**
	 * 定义了 Seq 的单位元操作
	 */
	static <T> Seq<T> unit(T t) {
		return c -> c.accept(t);
	}


	/**
	 * 将类型为T的流，转换为类型为E的流
	 * 也即根据函数T -> E得到Seq<T> -> Seq<E>的映射
	 */
	default <E> Seq<E> map(Function<T, E> function) {
		return c -> consume(t -> c.accept(function.apply(t)));
	}


	/**
	 * 将每个元素展开为一个流之后再合并 ：扁平化
	 */
	default <E> Seq<E> flatMap(Function<T, Seq<E>> function) {
		return c -> consume(t -> function.apply(t).consume(c));
	}

	/**
	 * 过滤元素
	 */
	default Seq<T> filter(Predicate<T> predicate) {
		return c -> consume(t -> {
			if (predicate.test(t)) {
				c.accept(t);
			}
		});
	}


	/**
	 * 流的中断控制有很多场景，
	 * take是最常见的场景之一，即获取前n个元素，后面的不要
	 * 等价于Stream.limit
	 */
	default Seq<T> take(int n) {
		return c -> {
			int[] i = {n};
			consumeTillStop(t -> {
				if (i[0]-- > 0) {
					c.accept(t);
				} else {
					stop();
				}
			});
		};
	}


	static <T> T stop() {
		throw StopException.INSTANCE;
	}

	default void consumeTillStop(Consumer<T> consumer) {
		try {
			consume(consumer);
		} catch (StopException ignore) {
		}
	}


	/**
	 * drop是与take对应的概念，丢弃前n个元素——等价于Stream.skip
	 */
	default Seq<T> drop(int n) {
		return c -> {
			int[] a = {n - 1};
			consume(t -> {
				if (a[0] < 0) {
					c.accept(t);
				} else {
					a[0]--;
				}
			});
		};
	}


	/**
	 * 对流的某个元素添加一个操作consumer，但是不执行流
	 * 对应 Stream.peek。
	 */
	default Seq<T> onEach(Consumer<T> consumer) {
		return c -> consume(consumer.andThen(c));
	}


	/**
	 * 流与一个iterable元素两两聚合，然后转换为一个新的流
	 * 在Stream里没有对应，但在Python里有同名实现。
	 */
	default <E, R> Seq<R> zip(Iterable<E> iterable, BiFunction<T, E, R> function) {
		return c -> {
			Iterator<E> iterator = iterable.iterator();
			consumeTillStop(t -> {
				if (iterator.hasNext()) {
					c.accept(function.apply(t, iterator.next()));
				} else {
					stop();
				}
			});
		};
	}


	default String join(String sep) {
		StringJoiner joiner = new StringJoiner(sep);
		consume(t -> joiner.add(t.toString()));
		return joiner.toString();
	}


	default List<T> toList() {
		List<T> list = new ArrayList<>();
		consume(list::add);
		return list;
	}
}
