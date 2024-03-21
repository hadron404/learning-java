package algorithms;

import java.util.Arrays;

/**
 * <a href="https://zh.wikipedia.org/wiki/%E9%B8%A1%E5%B0%BE%E9%85%92%E6%8E%92%E5%BA%8F">Cocktail shaker sort</a>
 */
public class CocktailShakerSort {

	public static void sort(int[] array, int length) {
		int temp;
		int beginIdx = 0, endIdx = array.length - 1;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = beginIdx; i < endIdx; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
			}
			//	debug message
			System.out.println("pass-through rightward [" + endIdx + "] array:" + Arrays.toString(array));
			endIdx--;
			for (int i = endIdx; i > beginIdx; i--) {
				if (array[i] < array[i - 1]) {
					temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					sorted = false;
				}
			}
			System.out.println("pass-through leftward [" + endIdx + "] array:" + Arrays.toString(array));
		}
	}
}
