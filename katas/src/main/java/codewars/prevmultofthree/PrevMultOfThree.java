package codewars.prevmultofthree;

import java.util.stream.IntStream;

public class PrevMultOfThree {

	/**
	 * use recurrence
	 */
	public static Integer solution_1(int n) {
		if (n % 3 == 0) {
			return n;
		}
		int nAfterCutOneBit = n / 10;
		if (nAfterCutOneBit == 0) {
			return null;
		}
		return solution_1(nAfterCutOneBit);
	}
	public static Integer solution_1_1(int n) {
		return n % 3 == 0 ? Integer.valueOf(n) : n > 0 ? null : solution_1_1(n / 10);
	}

	public static Integer solution2(int n) {
		return IntStream.iterate(n, i -> i > 0, i -> i / 10)
			.filter(i -> i % 3 == 0)
			.boxed()
			.findFirst()
			.orElse(null);
	}
}
