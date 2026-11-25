package Maximum_K_to_Sort_a_Permutation;

public class Solution1 {
	public int sortPermutation(int[] nums) {
		int k = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				k = (k & nums[i]);
			}
		}

		return k == -1 ? 0 : k;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 4, 5, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.sortPermutation(nums));
	}
}