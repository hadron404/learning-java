package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.behaviorparameterization.Color.GREEN;
import static com.example.intro8.behaviorparameterization.Color.RED;

class SecondAttemptTest {
	private static final List<Apple> inventory = new ArrayList<>();

	@Test
	void filterApplesByColor_GreenApples() {
		List<Apple> greenApples = SecondAttempt.filterApplesByColor(inventory, GREEN);
		Assertions.assertEquals(0, greenApples.size());
	}

	@Test
	void filterApplesByColor_RedApples() {
		List<Apple> redApples = SecondAttempt.filterApplesByColor(inventory, RED);
		Assertions.assertEquals(0, redApples.size());

	}
}
