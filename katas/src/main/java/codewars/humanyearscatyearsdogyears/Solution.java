package codewars.humanyearscatyearsdogyears;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int[] humanYearsCatYearsDogYears_0(final int y) {
		return new int[]{y, y == 1 ? 15 : 16 + 4 * y, y == 1 ? 15 : 14 + 5 * y};
	}

	public static int[] humanYearsCatYearsDogYears(final int humanYears) {
		Map<Integer, Integer> catYearsMap = new HashMap<>();
		catYearsMap.put(1, 15);
		catYearsMap.put(2, 24);

		Map<Integer, Integer> dogYearsMap = new HashMap<>();
		dogYearsMap.put(1, 15);
		dogYearsMap.put(2, 24);
		switch (humanYears) {
			case 1, 2 -> {
				return new int[]{humanYears, catYearsMap.get(humanYears), dogYearsMap.get(humanYears)};
			}
			default -> {
				int baseYears = 2;
				int n = humanYears - baseYears;
				return new int[]{humanYears, catYearsMap.get(baseYears) + n * 4, dogYearsMap.get(baseYears) + n * 5};
			}
		}
	}

	public static int[] humanYearsCatYearsDogYears_2(final int humanYears) {
		switch (humanYears) {
			case 1 -> {
				return new int[]{1, 15, 15};
			}
			case 2 -> {
				return new int[]{1, 24, 24};
			}
			default -> {
				int baseYears = 2;
				int n = humanYears - baseYears;
				return new int[]{humanYears, 24 + n * 4, 24 + n * 3};
			}
		}
	}

	public static int[] humanYearsCatYearsDogYears2_1(final int humanYears) {
		int catYears = 0, dogYears = 0;
		switch (humanYears) {
			default:
				catYears = 4 * (humanYears - 2);
				dogYears = 5 * (humanYears - 2);
			case 2:
				catYears += 9;
				dogYears += 9;
			case 1:
				catYears += 15;
				dogYears += 15;
		}
		return new int[]{humanYears, catYears, dogYears};
	}

}
