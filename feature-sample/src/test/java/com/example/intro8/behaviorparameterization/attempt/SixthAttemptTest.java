package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.behaviorparameterization.Color.RED;

class SixthAttemptTest {
	private static final List<Apple> inventory = new ArrayList<>();

	@Test
	void filterApples() {
		List<Apple> redApples = FifthAttempt.filterApples(inventory, apple -> RED.equals(apple.color()));
		Assertions.assertEquals(0, redApples.size());
	}
}
