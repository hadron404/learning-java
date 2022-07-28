package com.example.intro8.behaviorparameterization;

import static com.example.intro8.behaviorparameterization.Color.GREEN;

/*
 * Behavior parameterization
 *
 */
interface ApplePredicate {
	boolean test(Apple apple);


}

class AppleGreenColorPredicate implements ApplePredicate {
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
	public boolean test(Apple apple) {
		return apple.weight() > 150; // 4 Selects only heavy apples
	}
}
