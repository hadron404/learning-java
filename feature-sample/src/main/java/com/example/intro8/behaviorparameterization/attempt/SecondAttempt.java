package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;
import com.example.intro8.behaviorparameterization.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Second attempt: parameterizing the color
 */
public class SecondAttempt {
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
