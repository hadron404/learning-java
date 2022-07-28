package com.example.intro8.behaviorparameterization;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.behaviorparameterization.Color.GREEN;
import static com.example.intro8.behaviorparameterization.Color.RED;


public class Test {
	private static final List<Apple> inventory = new ArrayList<>();

	public static void main(String[] args) {
		List<Apple> greenApplesByFirstAttempt = FirstAttempt.filterGreenApples(inventory);
		List<Apple> greenApplesBySecondAttempt = SecondAttempt.filterApplesByColor(inventory, GREEN);
		List<Apple> redApplesBySecondAttempt = SecondAttempt.filterApplesByColor(inventory, RED);
	}

}

/**
 * First attempt: filtering green apples.
 *
 * @author zhouqiang
 * @since 2022/7/22
 */

class FirstAttempt {

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();   // 1 An accumulator list for apples
		for (Apple apple : inventory) {
			if (GREEN.equals(apple.color())) {  // 2 Selects only green apples
				result.add(apple);
			}
		}
		return result;
	}
}

/**
 * Second attempt: parameterizing the color
 */
class SecondAttempt {
	public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.color().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
}


/**
 * ThirdAttempt: filtering with every attribute you can think of
 */
class ThirdAttempt {
	public static List<Apple> filterApples(List<Apple> inventory, Color color,
		int weight, boolean flag) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ((flag && apple.color().equals(color)) ||
				(!flag && apple.weight() > weight)) { // 3 An ugly way to select color or weight
				result.add(apple);
			}
		}
		return result;
	}
}

// @formatter:off

/**
 * Fourth Attempt: filtering by abstract criteria
 */
class FourthAttempt {
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

// @formatter:on



