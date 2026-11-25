package Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	List<String> result;

	public List<String> generateParenthesis(int n) {
		result = new ArrayList<>();
		solve(0, 0, new StringBuilder(), n);
		return result;
	}

	private void solve(int open, int closed, StringBuilder curr, int n) {
		if (curr.length() == 2 * n) {
			result.add(curr.toString());
			return;
		}

		if (open < n) {
			curr.append("(");
			solve(open + 1, closed, curr, n);
			curr.deleteCharAt(curr.length() - 1);
		}

		if (closed < open) {
			curr.append(")");
			solve(open, closed + 1, curr, n);
			curr.deleteCharAt(curr.length() - 1);
		}
	}

	public static void main(String[] args) {
		int n = 2;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.generateParenthesis(n));
	}
}
