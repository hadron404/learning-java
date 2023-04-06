package org.example.create.thread;

public class ByImplementsRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("The Runner that created by implements Runnable interface is executing task.");
	}
}
