package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CocktailShakerSortTest {

	@Test
	void sort() {
		int[] array = {4, 2, 7, 1, 3};
		CocktailShakerSort.sort(array,5);
		System.out.println("final array:" + Arrays.toString(array));
	}
}
