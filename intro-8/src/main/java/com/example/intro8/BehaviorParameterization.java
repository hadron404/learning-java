package com.example.intro8;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.Color.GREEN;
import static com.example.intro8.Color.RED;

/**
 * Java In Action
 */

record Apple(Color color, int weight) {
}

enum Color {
	RED,
	GREEN,
}


public class BehaviorParameterization {
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

/*
 * Behavior parameterization
 *
 */
interface ApplePredicate {
	boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return apple.weight() > 150; // 4 Selects only heavy apples
	}
}

class AppleGreenColorPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return GREEN.equals(apple.color()); // 5 Selects only green apples
	}
}
