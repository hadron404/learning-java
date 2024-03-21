package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

	@Test
	void sort() {
		int[] array = {4, 2, 7, 1, 3};
		BubbleSort.sort(array);
		System.out.println("final array:" + Arrays.toString(array));
	}
}
