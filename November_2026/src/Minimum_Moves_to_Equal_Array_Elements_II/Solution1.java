package Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

public class Solution1 {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int mid = nums[nums.length / 2];
		int op = 0;
		for (int ele : nums) {
			op += Math.abs(mid - ele);
		}
		return op;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 10, 2, 9 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minMoves2(arr));
	}
}
