package org.example.create.thread;

import java.time.LocalDateTime;

/**
 * Create Thread by extends {@link java.lang.Thread}
 */
public class ByExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println(LocalDateTime.now() +" The thread [" + super.getName() + "] that created by extends Thread class is executing task.");
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				System.out.println(super.getName() + " is printing : " + i);
			}
		}
	}
}
