package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;
import com.example.intro8.behaviorparameterization.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * ThirdAttempt: filtering with every attribute you can think of
 */
public class ThirdAttempt {
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
