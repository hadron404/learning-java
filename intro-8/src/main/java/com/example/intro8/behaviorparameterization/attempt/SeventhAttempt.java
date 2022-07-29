package com.example.intro8.behaviorparameterization.attempt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SeventhAttempt {

	public static <T> List<T> filter(List<T> list, Predicate<T> p) { // Introduces a type parameter T
		List<T> result = new ArrayList<>();
		for(T e: list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
