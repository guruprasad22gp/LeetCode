package Minimum_Moves_to_Equal_Array_Elements_III;

public class Solution2 {
	public int minMoves(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
			max = Math.max(max, ele);
		}

		return max * nums.length - sum;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 4, 5 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minMoves(arr));
	}
}
