package Climbing_Stairs_II;

public class Solution1 {
	public int climbStairs(int n, int[] costs) {
		return solve(0, n, costs);
	}

	private int solve(int i, int n, int[] costs) {
		if (i > n) {
			return 0;
		}
		int result = 0;
		if (i + 1 <= n) {
			int j = i + 1;
			result = costs[j - 1] + (j - i) * (j - i) + solve(j, n, costs);
		}
		if (i + 2 <= n) {
			int j = i + 2;
			result = Math.min(result, costs[j - 1] + (j - i) * (j - i) + solve(j, n, costs));
		}
		if (i + 3 <= n) {
			int j = i + 3;
			result = Math.min(result, costs[j - 1] + (j - i) * (j - i) + solve(j, n, costs));
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 4;
		int[] costs = { 1, 2, 3, 4 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.climbStairs(n, costs));
	}
}