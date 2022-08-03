package prefectnumber;

import java.util.stream.IntStream;

public class NumberClassifierByLambda {
	public static IntStream factorsOf(int number) {
		return IntStream.range(1, number + 1)
			.filter(potential -> (number % potential) == 0);
	}

	public static int aliquotSum(int number) {
		return factorsOf(number).sum() - number;
	}

	public boolean isPrefect(final int number) {
		return aliquotSum(number) == number;
	}

	public boolean isAbundant(final int number) {
		return aliquotSum(number) > number;
	}

	public boolean isDeficient(final int number) {
		return aliquotSum(number) < number;
	}

}
