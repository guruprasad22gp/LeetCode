package Minimum_Moves_to_Equal_Array_Elements;

public class Solution2 {
	public int minMoves(int[] nums) {
		int minEle = Integer.MAX_VALUE;
		int sum = 0;
		for (int ele : nums) {
			minEle = Math.min(ele, minEle);
			sum += ele;
		}

		return sum - nums.length * minEle;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minMoves(arr));
	}
}
