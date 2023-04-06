package org.example.create.threadpool;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ByExecutorsTest {

	@Test
	void givenFixedThreadPool_whenSubmitTask_thenSubmitSuccess() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(() -> {
			System.out.println("a task that can not return value is executing by " + Thread.currentThread().getName());
		});
	}

	@Test
	void givenScheduledThreadPool_whenSubmitTask_thenRunOnce() throws InterruptedException {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		System.out.println("添加任务：" + LocalDateTime.now());
		executorService.schedule(() -> {
			System.out.println("执行任务：" + LocalDateTime.now());
			System.out.println("a task that can not return value is executing by " + Thread.currentThread().getName());
		}, 3, TimeUnit.SECONDS);
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
	}

	@Test
	void givenScheduledThreadPool_whenSubmitTask_thenRunMany() throws InterruptedException {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		System.out.println("添加任务：" + LocalDateTime.now());
		executorService.scheduleAtFixedRate(() -> {
			System.out.println("执行任务：" + LocalDateTime.now());
			System.out.println("a task that can not return value is executing by " + Thread.currentThread().getName());
		}, 3, 2, TimeUnit.SECONDS);
		Thread.sleep(TimeUnit.SECONDS.toMillis(10));
	}
}
