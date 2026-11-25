package Check_if_There_Is_a_Valid_Parentheses_String_Path;

import java.util.Arrays;

public class Solution2 {
	int m;
	int n;
	int[][][] dp;

	public boolean hasValidPath(char[][] grid) {
		m = grid.length;
		n = grid[0].length;

		if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(' || (m + n - 1) % 2 == 1) {
			return false;
		}

		dp = new int[101][101][201];
		for (int[][] x : dp) {
			for (int[] y : x) {
				Arrays.fill(y, -1);
			}
		}

		return solve(0, 0, 0, grid);
	}

	private boolean solve(int i, int j, int count, char[][] grid) {
		count += grid[i][j] == '(' ? 1 : -1;
		if (count < 0) {
			return false;
		}

		if (dp[i][j][count] != -1) {
			return dp[i][j][count] == 0 ? true : false;
		}

		if (i == m - 1 && j == n - 1) {
			dp[i][j][count] = count == 0 ? 1 : 0;
			return count == 0;
		}

		if (i + 1 < m && solve(i + 1, j, count, grid)) {
			dp[i][j][count] = 1;
			return true;
		}

		if (j + 1 < n && solve(i, j + 1, count, grid)) {
			dp[i][j][count] = 1;
			return true;
		}

		dp[i][j][count] = 0;
		return false;
	}

	public static void main(String[] args) {
		char[][] grid = { { '(', '(', '(' }, { ')', '(', ')' }, { '(', '(', ')' }, { '(', '(', ')' } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.hasValidPath(grid));
	}
}
