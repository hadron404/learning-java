package codewars.prevmultofthree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PrevMultOfThreeTest {

	@Test
	void name() {
		System.out.println(1 / 3);
		System.out.println(9 / 3);
		System.out.println(25 / 3);
		System.out.println(1 % 3);
		System.out.println(4 % 3);
		System.out.println(9999 % 10);
		System.out.println(9999 / 10);
	}

	@Test
	void name2() {
		assertNull(PrevMultOfThree.solution_1(1));
		assertNull(PrevMultOfThree.solution_1(25));
		assertEquals(36, PrevMultOfThree.solution_1(36));
		assertEquals(12, PrevMultOfThree.solution_1(1244));
		assertEquals(9, PrevMultOfThree.solution_1(952406));
	}
}
