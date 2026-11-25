package Minimum_Score_by_Changing_Two_Elements;

import java.util.Arrays;

public class Solution1 {
	public int minimizeSum(int[] nums) {
		Arrays.sort(nums);
		int max = Integer.MAX_VALUE;
		int n = nums.length;
		max = Math.min(nums[n - 2] - nums[1], max);
		max = Math.min(nums[n - 1] - nums[2], max);
		max = Math.min(nums[n - 3] - nums[0], max);
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 7, 8, 5 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimizeSum(nums));
	}
}