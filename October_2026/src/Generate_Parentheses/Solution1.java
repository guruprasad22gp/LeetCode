package Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	List<String> result;

	public List<String> generateParenthesis(int n) {
		result = new ArrayList<>();
		solve(new StringBuilder(), n);
		return result;
	}

	void solve(StringBuilder sb, int n) {
		if (sb.length() == 2 * n) {
			if (valid(sb.toString())) {
				result.add(sb.toString());
			}
			return;
		}

		sb.append("(");
		solve(sb, n);
		sb.deleteCharAt(sb.length() - 1);

		sb.append(")");
		solve(sb, n);
		sb.deleteCharAt(sb.length() - 1);
	}

	private boolean valid(String s) {
		int depth = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				depth++;
			} else {
				depth--;
				if (depth < 0) {
					return false;
				}
			}
		}

		return depth == 0;
	}

	public static void main(String[] args) {
		int n = 2;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.generateParenthesis(n));
	}
}
