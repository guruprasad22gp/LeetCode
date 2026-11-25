package Sum_of_Squares_of_Special_Elements;

public class Solution1 {
	public int sumOfSquares(int[] nums) {
		int total = 0;
		int n = nums.length;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				total += (nums[i - 1] * nums[i - 1]);
			}
		}

		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 1, 19, 18, 3 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.sumOfSquares(nums));

	}
}
