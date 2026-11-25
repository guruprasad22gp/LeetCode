package Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums = { 1, 4, 3, 3, 2 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestMonotonicSubarray(nums));
	}

	public int longestMonotonicSubarray(int[] nums) {
		int max = 1;
		int inc = 1;
		int decr = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				decr++;
				inc = 1;
			} else if (nums[i] > nums[i - 1]) {
				inc++;
				decr = 1;
			} else {
				decr = 1;
				inc = 1;
			}
			max = Math.max(max, Math.max(inc, decr));
		}
		return max;
	}
}
