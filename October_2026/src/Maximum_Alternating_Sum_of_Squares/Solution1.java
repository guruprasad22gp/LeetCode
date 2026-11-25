package Maximum_Alternating_Sum_of_Squares;

import java.util.Arrays;

public class Solution1 {
	public long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			nums[i] = (nums[i] * nums[i]);
		}

		Arrays.sort(nums);

		long result = 0;
		for (int i = 0; i < n / 2; i++) {
			result -= nums[i];
		}

		for (int i = n / 2; i < n; i++) {
			result += nums[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxAlternatingSum(nums));
	}
}
