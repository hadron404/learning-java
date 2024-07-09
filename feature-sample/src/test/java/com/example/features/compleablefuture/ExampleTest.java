package com.example.features.compleablefuture;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExampleTest {

	@Test
	void completedFutureExample() {
		CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
		assertTrue(cf.isDone());
		assertEquals("message", cf.getNow(null));
	}
}
