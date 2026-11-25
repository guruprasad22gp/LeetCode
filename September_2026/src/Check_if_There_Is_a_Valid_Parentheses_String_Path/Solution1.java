package Check_if_There_Is_a_Valid_Parentheses_String_Path;

public class Solution1 {
	int m;
	int n;

	public boolean hasValidPath(char[][] grid) {
		m = grid.length;
		n = grid[0].length;

		if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(' || (m + n - 1) % 2 == 1) {
			return false;
		}

		return solve(0, 0, 0, grid);
	}

	private boolean solve(int i, int j, int count, char[][] grid) {
		count += (grid[i][j] == '(') ? 1 : -1;

		if (count < 0) {
			return false;
		}

		if (i >= grid.length - 1 && j >= grid[0].length - 1) {
			return count == 0;
		}

		if (i + 1 < grid.length && solve(i + 1, j, count, grid)) {
			return true;
		}

		if (j + 1 < grid[0].length && solve(i, j + 1, count, grid)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] grid = { { '(', '(', '(' }, { ')', '(', ')' }, { '(', '(', ')' }, { '(', '(', ')' } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.hasValidPath(grid));
	}
}
