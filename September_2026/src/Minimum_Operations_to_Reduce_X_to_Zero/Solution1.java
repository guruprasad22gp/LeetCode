package Minimum_Operations_to_Reduce_X_to_Zero;

public class Solution1 {
	public int minOperations(int[] nums, int x) {
		int result = solve(0, nums.length - 1, nums, x);
		return result >= 10000 ? -1 : result;
	}

	private int solve(int i, int j, int[] nums, int x) {
		if (i > j || x < 0) {
			return 10000;
		}

		if (x == 0) {
			return 0;
		}

		int skipI = 1 + solve(i, j - 1, nums, x - nums[j]);
		int skipJ = 1 + solve(i + 1, j, nums, x - nums[i]);

		return Math.min(skipI, skipJ);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 4, 2, 3 };
		int x = 5;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperations(nums, x));
	}
}
