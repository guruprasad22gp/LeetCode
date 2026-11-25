package Twisted_Mirror_Path_Count;

public class Solution3 {
	public int uniquePaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int MOD = 1_000_000_007;
		int[][][] dp = new int[m + 1][n + 1][2];
		dp[m - 1][n - 1][1] = 1;
		dp[m - 1][n - 1][0] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					continue;
				}

				if (grid[i][j] == 1) {
					dp[i][j][0] = dp[i + 1][j][1];
					dp[i][j][1] = dp[i][j + 1][0];
				} else {
					int ways = (dp[i + 1][j][1] + dp[i][j + 1][0]) % MOD;
					dp[i][j][0] = ways;
					dp[i][j][1] = ways;
				}
			}
		}

		return dp[0][0][0];
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.uniquePaths(grid));
	}
}