package Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import java.util.Stack;

public class Solution1 {
	public String reverseParentheses(String s) {
		StringBuilder current = new StringBuilder();
		Stack<StringBuilder> stack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				stack.add(current);
				current = new StringBuilder();
			} else if (s.charAt(i) == ')') {
				current.reverse();
				current = stack.pop().append(current);
			} else {
				current.append(s.charAt(i));
			}
			i++;
		}

		return current.toString();
	}

	public static void main(String[] args) {
		String s = "(u(love)i)";
		Solution1 sol1 = new Solution1();

		System.out.println("Output: " + sol1.reverseParentheses(s));
	}
}
