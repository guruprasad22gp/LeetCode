package Minimum_Positive_Sum_Subarray;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public int minimumSumSubarray(List<Integer> nums, int l, int r) {
		int maxSum = Integer.MAX_VALUE;
		int n = nums.size();
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n && j - i + 1 <= r; j++) {
				sum += nums.get(j);
				int len = j - i + 1;
				if (len >= l && sum > 0) {
					maxSum = Math.min(maxSum, sum);
				}
			}
		}
		return maxSum == Integer.MAX_VALUE ? -1 : maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { -2, 2, -3, 1 };
		List<Integer> nums = new ArrayList<>();
		for (int x : arr) {
			nums.add(x);
		}
		int l = 2;
		int r = 3;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumSumSubarray(nums, l, r));
	}
}
