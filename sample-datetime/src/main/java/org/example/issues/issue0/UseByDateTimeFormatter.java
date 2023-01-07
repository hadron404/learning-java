package org.example.issues.issue0;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseByDateTimeFormatter {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		String dateStr = "2023-01-06 18:00:00";
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable task = () -> parseDate(dateStr);
		for (int i = 0; i < 1000; i++) {
			executorService.submit(task);
		}
		executorService.shutdown();
	}

	private static void parseDate(String dateStr) {
		try {
			LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
			System.out.println("Successfully Parsed Date " + date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
