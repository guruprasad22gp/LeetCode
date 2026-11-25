package Maximize_Consecutive_Elements_in_an_Array_After_Modification;

import java.util.Arrays;

public class Solution1 {
	int n;

	public int maxSelectedElements(int[] nums) {
		Arrays.sort(nums);
		n = nums.length;
		int res = 1;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
		}
		return res;
	}

	private int solve(int i, int incr, int[] arr) {
		int len = 1;
		int currVal = arr[i] + incr;
		int j = lowerBound(i + 1, currVal + 1, arr);
		if (j != -1) {
			len = Math.max(len, 1 + solve(j, 0, arr));
		}

		j = lowerBound(i + 1, currVal, arr);
		if (j != -1) {
			len = Math.max(len, 1 + solve(j, 1, arr));
		}

		return len;
	}

	private int lowerBound(int i, int key, int[] arr) {
		int low = i;
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
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxSelectedElements(nums));
	}
}