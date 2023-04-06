package org.example.create.thread;
import org.junit.jupiter.api.Test;

class ByExtendsThreadTest {

	@Test
	void givenNewThread_whenThreadStart_thenRunSuccess() {
		ByExtendsThread myThread = new ByExtendsThread();
		myThread.setName("myThread");
		myThread.start();
	}

	@Test
	void givenTwoThread_whenThreadStart_thenRunSuccess() {
		ByExtendsThread t1 = new ByExtendsThread();
		t1.setName("myThread1");
		t1.start();

		ByExtendsThread t2 = new ByExtendsThread();
		t2.setName("myThread2");
		t2.start();
		System.out.println(Thread.currentThread().getName() + "is executing");
	}
}
