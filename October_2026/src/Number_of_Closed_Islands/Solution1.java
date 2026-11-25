package Number_of_Closed_Islands;

public class Solution1 {
	int m;
	int n;

	public int closedIsland(int[][] grid) {
		int count = 0;
		m = grid.length;
		n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					if (DFS(i, j, grid)) {
						count++;
					}
				}
			}
		}

		return count;
	}

	private boolean DFS(int i, int j, int[][] grid) {
		if (i >= m || j >= n || i < 0 || j < 0) {
			return false;
		}
		if (grid[i][j] == 1) {
			return true;
		}
		grid[i][j] = 1;
		boolean up = DFS(i - 1, j, grid);
		boolean right = DFS(i, j + 1, grid);
		boolean down = DFS(i + 1, j, grid);
		boolean left = DFS(i, j - 1, grid);
		return up & right & down & left;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.closedIsland(grid));
	}
}