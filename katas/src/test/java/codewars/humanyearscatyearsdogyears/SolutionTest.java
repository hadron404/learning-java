package codewars.humanyearscatyearsdogyears;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
	@Test
	public void one() {
		assertArrayEquals(new int[]{1, 15, 15}, Solution.humanYearsCatYearsDogYears(1));
	}

	@Test
	public void two() {
		assertArrayEquals(new int[]{2, 24, 24}, Solution.humanYearsCatYearsDogYears(2));
	}

	@Test
	public void ten() {
		assertArrayEquals(new int[]{10, 56, 64}, Solution.humanYearsCatYearsDogYears(10));
	}
}
