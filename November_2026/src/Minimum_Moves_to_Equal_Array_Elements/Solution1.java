package Minimum_Moves_to_Equal_Array_Elements;

public class Solution1 {
	public int minMoves(int[] nums) {
		int minEle = Integer.MAX_VALUE;
		for (int ele : nums) {
			minEle = Math.min(ele, minEle);
		}

		int op = 0;
		for (int ele : nums) {
			op += ele - minEle;
		}
		return op;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minMoves(arr));
	}
}
