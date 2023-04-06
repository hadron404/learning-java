package org.example.create.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阿里开发规范不允许使用 Executors 去创建线程池，主要原因：
 * 1. 线程池的运行规则应该更加明确，使用 ThreadPoolExecutor 方式
 * 2. fixedThreadPool and singleThreadPool 允许的请求队列长度为 Integer.MAX_VALUE，可能为堆积大量请求，从而导致 OOM
 * 3. cachedThreadPool 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM
 * 注：Executors 使用了 静态工厂方法 模式，在 Java 中可以看见大量的类似使用，如 Collections，主要是提供一些可能常见的相关类的使用方法
 * 如阿里规范所说，可能会引发OOM事故，我感觉主要是以下原因：
 * 1 使用者对其提供的方法不熟悉
 * 2 使用者未在合适的场景考虑使用合适的方法
 * 3 未经大量测试
 * 4 使用者编写的代码健壮性较差
 * 完全不允许的做法应该是基于以下几种考虑，减少测试、减少使用者对其封装的理解、减少线上不可知问题的产生、减少开发成本
 */
public class ByExecutors {

	/**
	 * 创建一个固定大小的线程池
	 * ATTENTIONS: 因为该方法未对其执行任务数限制，则可能会引发 OOM
	 */
	public ExecutorService newFixedThreadPool() {
		return Executors.newFixedThreadPool(5);
	}

	public ExecutorService newSingleThreadExecutor() {
		return Executors.newSingleThreadExecutor();
	}

	/**
	 * 创建带缓存的线程池线程，数量随任务量而定
	 * 任务需要即创建新线程，但是已创建的线程可用时会复用线程
	 * 大量短期异步任务场景可提升性能
	 * ATTENTIONS: 因为该方法未对其线程数限制，则可能会引发 OOM
	 */
	public ExecutorService newCachedThreadPool() {
		return Executors.newCachedThreadPool();
	}

	/**
	 * 创建执行定时任务的线程池
	 */
	public ExecutorService newScheduledThreadPool() {
		return Executors.newScheduledThreadPool(5);
	}

	/**
	 * 根据当前设备的配置自动生成线程池
	 * */
	public ExecutorService newWorkStealingPool() {
		return Executors.newWorkStealingPool();
	}
}
