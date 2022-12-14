package com.example.features.behaviorparameterization.attempt;

import com.example.features.behaviorparameterization.Color;
import com.example.features.behaviorparameterization.Apple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SixthAttemptTest {
	private static final List<Apple> inventory = new ArrayList<>();

	@Test
	void filterApples() {
		List<Apple> redApples = FifthAttempt.filterApples(inventory, apple -> Color.RED.equals(apple.color()));
		Assertions.assertEquals(0, redApples.size());
	}
}
