package Minimum_Swaps_to_Sort_by_Digit_Sum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
	public int minSwaps(int[] nums) {
		int n = nums.length;
		Integer[] temp = Arrays.stream(nums).boxed().toArray(Integer[]::new);

		Arrays.sort(temp, (a, b) -> {
			int n1 = getDigit(a);
			int n2 = getDigit(b);

			if (n1 == n2) {
				return a - b;
			}

			return Integer.compare(n1, n2);
		});

		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < n; i++) {
			int expectedVal = temp[i];
			int currVal = nums[i];

			if (currVal == expectedVal) {
				continue;
			}

			int eIdx = map.get(expectedVal);
			nums[i] = expectedVal;
			nums[eIdx] = currVal;

			map.put(nums[i], i);
			map.put(nums[eIdx], eIdx);
			count++;
		}

		return count;
	}

	private int getDigit(int num) {
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 18, 43, 34, 16 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minSwaps(nums));
	}
}