package Valid_Parenthesis_String;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.checkValidString(s));
	}

	int[][] dp;

	public boolean checkValidString(String s) {
		int n = s.length();
		dp = new int[n + 1][n + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return solve(0, 0, s);
	}

	private boolean solve(int i, int open, String s) {
		if (i == s.length()) {
			return open == 0;
		}

		if (dp[i][open] != -1) {
			return dp[i][open] == 1;
		}

		boolean ans = false;
		if (s.charAt(i) == '(') {
			ans |= solve(i + 1, open + 1, s);
		} else if (s.charAt(i) == ')') {
			if (open > 0) {
				ans |= solve(i + 1, open - 1, s);
			} else {
				ans |= false;
			}
		} else {
			boolean o1 = solve(i + 1, open + 1, s);
			boolean o2 = solve(i + 1, open, s);
			boolean o3 = false;

			if (open > 0) {
				o3 = solve(i + 1, open - 1, s);
			}
			ans = o1 || o2 || o3;
		}

		dp[i][open] = ans ? 1 : 0;
		return ans;
	}
}