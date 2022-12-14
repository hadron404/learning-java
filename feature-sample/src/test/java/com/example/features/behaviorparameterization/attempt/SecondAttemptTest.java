package com.example.features.behaviorparameterization.attempt;

import com.example.features.behaviorparameterization.Apple;
import com.example.features.behaviorparameterization.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SecondAttemptTest {
	private static final List<Apple> inventory = new ArrayList<>();

	@Test
	void filterApplesByColor_GreenApples() {
		List<Apple> greenApples = SecondAttempt.filterApplesByColor(inventory, Color.GREEN);
		Assertions.assertEquals(0, greenApples.size());
	}

	@Test
	void filterApplesByColor_RedApples() {
		List<Apple> redApples = SecondAttempt.filterApplesByColor(inventory, Color.RED);
		Assertions.assertEquals(0, redApples.size());

	}
}
