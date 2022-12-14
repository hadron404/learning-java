package com.example.features.behaviorparameterization.attempt;

import com.example.features.behaviorparameterization.Apple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FirstAttemptTest {
	private static final List<Apple> inventory = new ArrayList<>();

	@Test
	void filterGreenApples() {
		List<Apple> greenApples = FirstAttempt.filterGreenApples(inventory);
		Assertions.assertEquals(0, greenApples.size());
	}
}
