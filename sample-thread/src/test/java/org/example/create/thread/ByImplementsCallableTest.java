package org.example.create.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ByImplementsCallableTest {

	@Test
	void givenCallable_whenThreadStart_thenGetReturnValue() {
		FutureTask<String> stringFutureTask =
			new FutureTask<>(new ByImplementsCallable());
		new Thread(stringFutureTask).start();

		try {
			String value = stringFutureTask.get();
			Assertions.assertTrue(value.isBlank());
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
