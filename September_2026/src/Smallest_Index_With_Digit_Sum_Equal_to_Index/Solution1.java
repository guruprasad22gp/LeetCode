package Smallest_Index_With_Digit_Sum_Equal_to_Index;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 2 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.smallestIndex(nums));
	}

	public int smallestIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int index = find(nums[i]);
			if (index == i) {
				return i;
			}
		}

		return -1;
	}

	private int find(int num) {
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}
}
