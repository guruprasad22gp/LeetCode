package Minimum_Moves_to_Equal_Array_Elements_III;

public class Solution1 {
	public int minMoves(int[] nums) {
		int max = Integer.MIN_VALUE;
		int op = 0;
		for (int ele : nums) {
			max = Math.max(max, ele);
		}

		for (int ele : nums) {
			op += max - ele;
		}

		return op;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 4, 5 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minMoves(arr));
	}
}
