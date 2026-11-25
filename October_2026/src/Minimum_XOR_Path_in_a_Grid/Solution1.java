package Minimum_XOR_Path_in_a_Grid;

import java.util.BitSet;

public class Solution1 {
	public int minCost(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		BitSet[][] dp = new BitSet[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = new BitSet(1024);
			}
		}

		dp[0][0].set(grid[0][0]);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				BitSet up = new BitSet(1024);
				BitSet left = new BitSet(1024);
				if (i > 0) {
					up = dp[i - 1][j];
				}

				if (j > 0) {
					left = dp[i][j - 1];
				}

				BitSet combined = new BitSet(1024);
				combined.or(left);
				combined.or(up);

				for (int xor = 0; xor < 1024; xor++) {
					if (combined.get(xor)) {
						int resXor = xor ^ grid[i][j];
						dp[i][j].set(resXor);
					}
				}
			}
		}

		for (int i = 0; i < 1024; i++) {
			if (dp[m - 1][n - 1].get(i)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 6, 7 }, { 5, 8 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minCost(grid));
	}
}