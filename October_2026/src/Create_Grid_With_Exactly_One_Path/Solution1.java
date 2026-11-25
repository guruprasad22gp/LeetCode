package Create_Grid_With_Exactly_One_Path;

public class Solution1 {
	public String[] createGrid(int m, int n) {
		String[] result = new String[m];
		String topRow = ".".repeat(n);
		String remaining = "#".repeat(n - 1) + ".";
		result[0] = topRow;
		for (int i = 1; i < m; i++) {
			result[i] = remaining;
		}
		return result;

	}

	public static void main(String[] args) {
		int m = 4;
		int n = 4;
		Solution1 sol1 = new Solution1();
		String[] ans = sol1.createGrid(m, n);
		for (String s : ans) {
			System.out.println(s);
		}
	}
}
