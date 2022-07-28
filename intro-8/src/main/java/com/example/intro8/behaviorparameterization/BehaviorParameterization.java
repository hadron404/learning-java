package com.example.intro8.behaviorparameterization;

import com.example.intro8.behaviorparameterization.attempt.FirstAttempt;
import com.example.intro8.behaviorparameterization.attempt.SecondAttempt;

import java.util.ArrayList;
import java.util.List;

import static com.example.intro8.behaviorparameterization.Color.GREEN;
import static com.example.intro8.behaviorparameterization.Color.RED;


public class BehaviorParameterization {
	private static final List<Apple> inventory = new ArrayList<>();

	public static void main(String[] args) {
		List<Apple> greenApplesByFirstAttempt = FirstAttempt.filterGreenApples(inventory);
		List<Apple> greenApplesBySecondAttempt = SecondAttempt.filterApplesByColor(inventory, GREEN);
		List<Apple> redApplesBySecondAttempt = SecondAttempt.filterApplesByColor(inventory, RED);
	}
}



