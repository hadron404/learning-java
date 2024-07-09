package com.example.features.compleablefuture;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Story 主要说明一个或多个使用特性的用户故事
 */
public class Story {
	private Story() {
	}

	/*
	 * 提供一个函数，接收一个调用集合参数以及一个context（包含每个API的请求参数）的Map，返回一个Map（每个API的结果）。
	 *
	 */
	public static Map<API, String> batchSync(Map<API, String> context) {
		ConcurrentHashMap<API, String> result = new ConcurrentHashMap<>();
		context.forEach((k, v) -> result.put(k, k.execute()));
		return result;
	}

	public static Map<API, CompletableFuture<String>> batchAsync(Map<API, String> context) {
		ConcurrentHashMap<API, CompletableFuture<String>> result = new ConcurrentHashMap<>(context.size());
		context.forEach((k, v) -> result.put(k, CompletableFuture.supplyAsync(k::execute)));
		return result;
	}

	public static Map<API, String> batchAsyncWithResult(Map<API, String> context) {
		ConcurrentHashMap<API, String> result = new ConcurrentHashMap<>();
		Story.batchAsync(context).forEach((k, v) -> {
			try {
				result.put(k, v.get());
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		});
		return result;
	}

	public enum API {
		GET_INFO_ORDER {
			String execute() {
				super.delay(1000);
				return "查询订单信息：";
			}
		},
		GET_INFO_ORDER_AMOUNT {
			String execute() {
				super.delay(1500);
				return "查询订单金额信息：";
			}
		},
		GET_INFO_CUSTOMER {
			String execute() {
				super.delay(500);
				return "查询客户金额信息：";
			}
		};

		String execute() {
			return "";
		}

		void delay(long millis) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

	}
}
