package com.example.features.compleablefuture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class StoryTest {

	/**
	 * 耗时为提供的调用接口方法的耗时总和
	 */
	@Test
	void batchSync() {
		Assertions.assertDoesNotThrow(() -> {
			long start = System.currentTimeMillis();
			Map<Story.API, String> result = Story.batchSync(
				Map.of(
					Story.API.GET_INFO_CUSTOMER, "",
					Story.API.GET_INFO_ORDER, "",
					Story.API.GET_INFO_ORDER_AMOUNT, ""
				)
			);
			long end = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Executing 3 tasks takes " + (end - start) + "ms");
		});
	}

	/**
	 * 耗时为提供的调用接口方法的耗时最长的一个方法执行时间
	 */
	@Test
	void batchAsync() throws ExecutionException, InterruptedException {
		long start = System.currentTimeMillis();
		Map<Story.API, CompletableFuture<String>> result = Story.batchAsync(
			Map.of(
				Story.API.GET_INFO_CUSTOMER, "",
				Story.API.GET_INFO_ORDER, "",
				Story.API.GET_INFO_ORDER_AMOUNT, ""
			)
		);
		//System.out.println(result.get(Story.API.GET_INFO_CUSTOMER).get());
		//System.out.println(result.get(Story.API.GET_INFO_ORDER).get());
		//System.out.println(result.get(Story.API.GET_INFO_ORDER_AMOUNT).get());
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Executing 3 tasks takes " + (end - start) + "ms");
	}

	/**
	 * 耗时为提供的调用接口方法的耗时最长的一个方法执行时间
	 */
	@Test
	void batchAsyncWithResult() {
		long start = System.currentTimeMillis();
		Map<Story.API, String> result = Story.batchAsyncWithResult(
			Map.of(
				Story.API.GET_INFO_CUSTOMER, "",
				Story.API.GET_INFO_ORDER, "",
				Story.API.GET_INFO_ORDER_AMOUNT, ""
			)
		);
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Executing 3 tasks takes " + (end - start) + "ms");
	}
}
