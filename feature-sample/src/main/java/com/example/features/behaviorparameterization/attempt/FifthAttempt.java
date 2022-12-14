package com.example.features.behaviorparameterization.attempt;

import com.example.features.behaviorparameterization.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Using an Anonymous classes
 */
public class FifthAttempt {

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) { // (1) Predicate p encapsulates the condition to test on an apple.
				result.add(apple);
			}
		}
		return result;
	}
}
