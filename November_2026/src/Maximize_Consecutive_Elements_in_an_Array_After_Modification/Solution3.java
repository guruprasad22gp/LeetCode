package Maximize_Consecutive_Elements_in_an_Array_After_Modification;

import java.util.Arrays;

public class Solution3 {
	int n;

	public int maxSelectedElements(int[] nums) {
		n = nums.length;
		Arrays.sort(nums);
		int[][] dp = new int[n + 1][2];
		int res = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int incr = 0; incr <= 1; incr++) {
				int len = 1;
				int currVal = nums[i] + incr;
				int j = lowerBound(i + 1, currVal + 1, nums);
				if (j != -1) {
					len = Math.max(len, 1 + dp[j][0]);
				}

				j = lowerBound(i + 1, currVal, nums);
				if (j != -1) {
					len = Math.max(len, 1 + dp[j][1]);
				}
				dp[i][incr] = len;
				res = Math.max(res, dp[i][incr]);
			}
		}

		return res;
	}

	private int lowerBound(int i, int key, int[] arr) {
		int j = n;

		while (i < j) {
			int mid = i + (j - i) / 2;

			if (arr[mid] < key) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}

		return (i < n && arr[i] == key) ? i : -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 1, 1, 8, 10, 11, 23, 21, 22, 25, 22, 26, 26, 28, 3, 5, 6, 8 };
//1,1,1,2,3,5,5,6,8,8,10,11,21,22,22,23,25,26,26,28
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.maxSelectedElements(nums));
	}
}