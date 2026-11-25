package Count_Islands_With_Total_Value_Divisible_by_K;

public class Solution1 {
	int m;
	int n;

	public int countIslands(int[][] grid, int k) {
		m = grid.length;
		n = grid[0].length;

		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0) {
					if (DFS(i, j, grid) % k == 0) {
						count++;
					}
				}
			}
		}

		return count;
	}

	private int DFS(int i, int j, int[][] grid) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}

		if (grid[i][j] == 0) {
			return 0;
		}

		int totalSum = grid[i][j];
		grid[i][j] = 0;
		totalSum += DFS(i + 1, j, grid) + DFS(i - 1, j, grid) + DFS(i, j - 1, grid) + DFS(i, j + 1, grid);

		return totalSum;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 2, 1, 0, 0 }, { 0, 5, 0, 0, 5 }, { 0, 0, 1, 0, 0 }, { 0, 1, 4, 7, 0 },
				{ 0, 2, 0, 0, 8 } };
		int k = 5;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countIslands(grid, k));
	}
}
