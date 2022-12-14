package com.example.features.behaviorparameterization.quiz;

import com.example.features.behaviorparameterization.Apple;

import java.util.List;

public class PrettyPrintApple {
	public static void print(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
}
