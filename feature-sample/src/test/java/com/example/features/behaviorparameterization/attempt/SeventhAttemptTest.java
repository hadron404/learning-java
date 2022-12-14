package com.example.features.behaviorparameterization.attempt;

import com.example.features.behaviorparameterization.Apple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.features.behaviorparameterization.Color.RED;

class SeventhAttemptTest {

	private static final List<Apple> inventory = new ArrayList<>();

	@Test
	void filter() {
		List<Apple> redApples = FifthAttempt.filterApples(inventory, apple -> RED.equals(apple.color()));
		Assertions.assertEquals(0, redApples.size());
	}
}
