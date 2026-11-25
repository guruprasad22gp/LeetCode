package Minimum_Operations_to_Reduce_X_to_Zero;

import java.util.HashMap;

public class Solution2 {
	public int minOperations(int[] nums, int x) {
		int n = nums.length;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			map.put(sum, i);
		}

		int targetSum = sum - x;
		int longestSubArr = -1;
		sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			int findSum = sum - targetSum;
			if (map.containsKey(findSum)) {
				int index = map.get(findSum);
				longestSubArr = Math.max(i - index, longestSubArr);
			}
		}

		return longestSubArr == -1 ? longestSubArr : n - longestSubArr;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 4, 2, 3 };
		int x = 5;

		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.minOperations(nums, x));
	}
}
