package Longest_Valid_Parentheses;

public class Solution1 {
	public static void main(String[] args) {
		String s = "()(()";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestValidParentheses(s));
	}

	public int longestValidParentheses(String s) {
		int open = 0;
		int close = 0;
		int result = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				open++;
			} else {
				close++;
			}

			System.out.println(open + " - " + close);

			if (open == close) {
				result = Math.max(open + close, result);
			} else if (close > open) {
				close = open = 0;
			}
		}

		open = close = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')') {
				close++;
			} else {
				open++;
			}

			if (close == open) {
				result = Math.max(result, close + open);
			} else if (open > close) {
				open = close = 0;
			}
		}

		return result;
	}
}
