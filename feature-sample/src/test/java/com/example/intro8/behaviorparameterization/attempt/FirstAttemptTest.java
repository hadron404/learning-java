package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;
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
