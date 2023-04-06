package org.example.create.thread;

import java.util.concurrent.Callable;

/**
 * Create thread by implements {@link java.util.concurrent.Callable} interface
 * @since 1.5
 */
public class ByImplementsCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		return "";
	}
}
