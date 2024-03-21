package algorithms;

import java.util.Arrays;

/**
 * Bubble sort:
 * <a href="https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F">Bubble sort From Wikipedia</a>
 * <p>
 * */
public class BubbleSort {
	public static void sort(int[] array) {
		int temp;
		int beginIdx = 0, endIdx = array.length - 1;
		while (beginIdx < endIdx) {
			for (int i = 0; i < endIdx; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
			}
			//	debug message
			System.out.println("pass-through [" + endIdx + "] array:" + Arrays.toString(array));
			endIdx--;
		}
	}

	public static void sort2(int[] array) {
		int temp;
		int endIdx = array.length - 1;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < endIdx; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					sorted = false;
				}
			}
			endIdx--;
			//	debug message
			System.out.println("pass-through array:" + Arrays.toString(array));
		}
	}
}
