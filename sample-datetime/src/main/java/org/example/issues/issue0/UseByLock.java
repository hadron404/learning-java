package org.example.issues.issue0;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseByLock {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		String dateStr = "2023-01-06 18:00:00";
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable task = () -> parseDate(dateStr);
		for (int i = 0; i < 100; i++) {
			executorService.submit(task);
		}
		executorService.shutdown();
	}

	private static void parseDate(String dateStr) {
		try {
			lock.lock();
			Date date = simpleDateFormat.parse(dateStr);
			System.out.println("Successfully Parsed Date " + date);
		} catch (ParseException e) {
			System.out.println("ParseError " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 为防止程序抛出异常而导致锁不能被释放，一定要将释放锁的操作放到finally代码块中
			lock.unlock();
		}
	}
}
