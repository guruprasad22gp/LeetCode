package Count_Non_Decreasing_Subarrays_After_K_Operations;

public class Solution1 {
	public long countNonDecreasingSubarrays(int[] nums, int k) {
		long op = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int operations = k;
			int max = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < max) {
					operations -= (max - nums[j]);
					if (operations < 0) {
						break;
					}
				} else {
					max = Math.max(max, nums[j]);
				}
				op++;
			}
		}

		return op + nums.length;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 3, 1, 2, 4, 4 };
		int k = 7;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countNonDecreasingSubarrays(nums, k));
	}
}