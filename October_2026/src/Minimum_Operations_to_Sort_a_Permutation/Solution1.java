package Minimum_Operations_to_Sort_a_Permutation;

public class Solution1 {
	public int minOperations(int[] nums) {
		int n = nums.length;
		int count_asc = 0;
		int count_desc = 0;
		for (int i = 1; i < n; i++) {
			count_asc += (nums[i] == (nums[i - 1] + 1) % n) ? 1 : 0;
			count_desc += (nums[i - 1] == (nums[i] + 1) % n) ? 1 : 0;
		}

		if (count_asc == n - 1 && nums[0] == 0) {
			return 0;
		}

		if (count_asc == n - 1) {
			int leftRot = n - nums[0];
			int rightRot = 1 + nums[n - 1] + 1 + 1;
			return Math.min(leftRot, rightRot);
		}

		if (count_desc == n - 1) {
			int left = n - nums[n - 1] + 1;
			int right = (nums[0] + 1) % n + 1;
			return Math.min(left, right);
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 2, 1 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperations(nums));
	}
}
