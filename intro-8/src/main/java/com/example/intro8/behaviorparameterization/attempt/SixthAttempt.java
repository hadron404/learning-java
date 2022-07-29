package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Using a lambda expression
 */
public class SixthAttempt {
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
