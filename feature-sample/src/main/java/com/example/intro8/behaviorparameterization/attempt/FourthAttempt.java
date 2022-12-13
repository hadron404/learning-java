package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.behaviorparameterization.Color.GREEN;

/**
 * Fourth Attempt: filtering by abstract criteria
 */
public class FourthAttempt {
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

/*
 * Behavior parameterization
 *
 */
interface ApplePredicate {
	boolean test(Apple apple);
}

class AppleGreenColorPredicate implements ApplePredicate {
	@Override
	public boolean test(Apple apple) {
		return GREEN.equals(apple.color()); // 5 Selects only green apples
	}
}

/**
 * <a href="http://en.wikipedia.org/wiki/Strategy_pattern">Strategy_pattern</a>
 * lets you define a family of algorithms,
 * encapsulate each algorithm (called a strategy), and select an algorithm at run time.
 */
class AppleHeavyWeightPredicate implements ApplePredicate {
	@Override
	public boolean test(Apple apple) {
		return apple.weight() > 150; // 4 Selects only heavy apples
	}
}
