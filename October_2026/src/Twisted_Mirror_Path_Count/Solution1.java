package Twisted_Mirror_Path_Count;

public class Solution1 {
	int MOD = 1_000_000_007;
	int m;
	int n;

	public int uniquePaths(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		return solve(0, 0, 0, grid);
	}

	private int solve(int i, int j, int come, int[][] grid) {
		if (i >= m || j >= n) {
			return 0;
		}

		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		if (grid[i][j] == 1) {
			if (come == 0) {
				return solve(i + 1, j, 1, grid);
			} else {
				return solve(i, j + 1, 0, grid);
			}
		}
		int right = solve(i, j + 1, 0, grid);
		int down = solve(i + 1, j, 1, grid);

		return (right + down) % MOD;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1 }, { 1, 1, 0 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.uniquePaths(grid));
	}
}