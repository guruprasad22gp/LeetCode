package Climbing_Stairs_II;

public class Solution3 {
	public int climbStairs(int n, int[] costs) {
		int[] dp = new int[n + 1];
		for (int i = n; i >= 0; i--) {
			int result = 0;
			if (i + 1 <= n) {
				int j = i + 1;
				result = costs[j - 1] + (j - i) * (j - i) + dp[j];
			}
			if (i + 2 <= n) {
				int j = i + 2;
				result = Math.min(result, costs[j - 1] + (j - i) * (j - i) + dp[j]);
			}
			if (i + 3 <= n) {
				int j = i + 3;
				result = Math.min(result, costs[j - 1] + (j - i) * (j - i) + dp[j]);
			}
			dp[i] = result;
		}

		return dp[0];
	}

	public static void main(String[] args) {
		int n = 30;
		int[] costs = { 10, 19, 11, 14, 26, 22, 18, 18, 31, 15, 25, 29, 28, 33, 21, 18, 23, 31, 25, 9, 17, 6, 5, 35, 10,
				29, 25, 5, 26, 8 };
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.climbStairs(n, costs));
	}
}