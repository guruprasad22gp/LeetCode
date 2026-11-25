package Maximize_Consecutive_Elements_in_an_Array_After_Modification;

import java.util.Arrays;

public class Solution2 {
	int n;
	int[][] dp;

	public int maxSelectedElements(int[] nums) {
		n = nums.length;
		dp = new int[n + 1][2];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		Arrays.sort(nums);
		int res = 1;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
		}
		return res;
	}

	private int solve(int i, int incr, int[] nums) {
		if (dp[i][incr] != -1) {
			return dp[i][incr];
		}
		int len = 1;
		int currVal = nums[i] + incr;

		int j = lowerBound(i + 1, currVal + 1, nums);
		if (j != -1) {
			len = Math.max(len, 1 + solve(j, 0, nums));
		}

		j = lowerBound(i + 1, currVal, nums);
		if (j != -1) {
			len = Math.max(len, 1 + solve(j, 1, nums));
		}

		return dp[i][incr] = len;
	}

	private int lowerBound(int low, int key, int[] arr) {
		int high = n;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return (low < n && arr[low] == key) ? low : -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 1, 1, 8, 10, 11, 23, 21, 22, 25, 22, 26, 26, 28, 3, 5, 6, 8 };
//1,1,1,2,3,5,5,6,8,8,10,11,21,22,22,23,25,26,26,28
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maxSelectedElements(nums));
	}
}