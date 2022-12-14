package com.example.features.behaviorparameterization.quiz;

/*
 * What will the output be when this code is executed: 4, 5, 6, or 42?
 *
 */
public class MeaningOfThis {
	public final int value = 4;

	public void doIt() {
		int value = 6;
		Runnable r = new Runnable() {
			public final int value = 5;

			public void run() {
				int value = 10;
				System.out.println(this.value);
			}
		};
		r.run();
	}

	public static void main(String... args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doIt(); // (1) What's the output of this line?
	}
}
