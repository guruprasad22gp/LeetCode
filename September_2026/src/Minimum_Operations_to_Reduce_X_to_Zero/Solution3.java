package Minimum_Operations_to_Reduce_X_to_Zero;

public class Solution3 {
	public static void main(String[] args) {
		int[] nums = { 5, 6, 7, 8, 9 };
		int x = 4;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperations(nums, x));
	}

	public int minOperations(int[] nums, int x) {
		int n = nums.length;
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		int targetSum = sum - x;

		if (targetSum < 0) {
			return -1;
		}

		if (targetSum == 0) {
			return n;
		}

		int left = 0;
		sum = 0;
		int max = 0;

		for (int right = 0; right < n; right++) {
			sum += nums[right];

			while (sum > targetSum) {
				sum -= nums[left];
				left++;
			}

			if (sum == targetSum) {
				max = Math.max(max, right - left + 1);
			}
		}

		return max == -1 ? -1 : n - max;
	}
}
