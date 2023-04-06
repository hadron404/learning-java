package org.example.create.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class ByThreadPoolExecutorTest {

	@Test
	void manualCreatePool() {
		ExecutorService executorService = new ThreadPoolExecutor(
			5,
			5,
			5,
			TimeUnit.HOURS,
			new LinkedBlockingQueue<>(10)
		);
		executorService.execute(()->{
			System.out.println("a task that can not return value is executing by " + Thread.currentThread().getName());
		});


	}
}
