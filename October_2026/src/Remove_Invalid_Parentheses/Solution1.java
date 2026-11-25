package Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {
	Set<String> result;
	int maxLen;

	public List<String> removeInvalidParentheses(String s) {
		result = new TreeSet<>();
		maxLen = 0;

		solve(0, 0, new StringBuilder(), s);

		return new ArrayList<>(result);
	}

	private void solve(int i, int count, StringBuilder curr, String s) {
		if (count < 0) {
			return;
		}

		if (i == s.length()) {
			if (count == 0) {
				if (curr.length() > maxLen) {
					maxLen = curr.length();
					result.clear();
				}

				if (curr.length() == maxLen) {
					result.add(new StringBuilder(curr).toString());
				}
			}
			return;
		}

		if (s.charAt(i) != '(' && s.charAt(i) != ')') {
			curr.append(s.charAt(i));
			solve(i + 1, count, curr, s);
			curr.deleteCharAt(curr.length() - 1);
			return;
		}

		curr.append(s.charAt(i));
		solve(i + 1, count + (s.charAt(i) == '(' ? 1 : -1), curr, s);
		curr.deleteCharAt(curr.length() - 1);
		solve(i + 1, count, curr, s);

	}

	public static void main(String[] args) {
		String s = "((((((((((((((((()(((aaaaa)";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.removeInvalidParentheses(s));
	}
}
