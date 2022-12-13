package com.example.intro8.behaviorparameterization.attempt;

import com.example.intro8.behaviorparameterization.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.behaviorparameterization.Color.GREEN;

/**
 * First attempt: filtering green apples.
 *
 * @author zhouqiang
 * @since 2022/7/22
 */

public class FirstAttempt {

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
