package com.example.intro8.behaviorparameterization.quiz;

import com.example.intro8.behaviorparameterization.Apple;

import java.util.List;

public class PrettyPrintApple {
	public static void print(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
}
