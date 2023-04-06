package org.example.create.thread;

import org.junit.jupiter.api.Test;

class ByImplementsRunnableTest {

	@Test
	void givenRunnableInterface_whenThreadStart_thenRun() {
		Thread t1 = new Thread(new ByImplementsRunnable());
		t1.setName("threadWithMyRunnable");
		t1.start();
	}

	@Test
	void givenRunnableInterface_whenThreadStart_thenRun1() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("The Runner that created by implements Runnable interface with inner class is executing task.");
			}
		});
		t1.setName("threadWithMyRunnableByInnerClass");
		t1.start();
	}

	/**
	 * @since 1.8
	 */
	@Test
	void givenRunnableInterface_whenThreadStart_thenRun2() {
		Thread t1 = new Thread(() -> System.out.println("The Runner that created by implements Runnable interface with lambda is executing task."));
		t1.setName("threadWithMyRunnableByLambdaExpression");
		t1.start();
	}

}
