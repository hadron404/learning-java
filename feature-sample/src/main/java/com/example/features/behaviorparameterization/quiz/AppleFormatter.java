package com.example.features.behaviorparameterization.quiz;

import com.example.features.behaviorparameterization.Apple;

public interface AppleFormatter {
	String accept(Apple a);
}

class AppleFancyFormatter implements AppleFormatter {
	@Override
	public String accept(Apple apple) {
		String characteristic = apple.weight() > 150 ? "heavy" :
			"light";
		return "A " + characteristic + " " + apple.color() + " apple";
	}
}

class AppleSimpleFormatter implements AppleFormatter {
	@Override
	public String accept(Apple apple) {
		return "An apple of " + apple.weight() + "g";
	}
}
