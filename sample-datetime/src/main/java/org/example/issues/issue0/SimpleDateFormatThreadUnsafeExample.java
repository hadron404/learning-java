package org.example.issues.issue0;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatThreadUnsafeExample {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
			Date date = simpleDateFormat.parse(dateStr);
			System.out.println("Successfully Parsed Date " + date);
		} catch (ParseException e) {
			System.out.println("ParseError " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
