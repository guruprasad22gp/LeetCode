package Count_Servers_that_Communicate;

public class Solution2 {
	public int countServers(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] row = new int[m];
		int[] col = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					row[i]++;
					col[j]++;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countServers(grid));
	}
}