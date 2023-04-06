package org.example.create.threadpool;

import java.util.concurrent.*;

/**
 * 通过 ThreadPoolExecutor 创建线程池具备更加灵活的适用场景，可根据使用场景创建更适合的线程池
 * 核心参数：
 * corePoolSize
 * maximumPoolSize
 * keepAliveTime
 * keepAliveTimeUnit
 * capacity: number of workBlockingQueue's max tasks
 * RejectedExecutionHandler: 拒绝策略， 已定义的拒绝策略：AbortPolicy DiscardPolicy DiscardOldestPolicy CallerRunsPolicy
 * */
public class ByThreadPoolExecutor {

	public ExecutorService manualCreatePool() {
		return new ThreadPoolExecutor(
			5,
			5,
			5,
			TimeUnit.HOURS,
			new LinkedBlockingQueue<>(10)
		);
	}
}
