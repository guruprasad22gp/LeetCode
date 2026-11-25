package Score_of_Parentheses;

import java.util.Stack;

// ((()))()
public class Solution1 {
	public int scoreOfParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int score = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.add(score);
				score = 0;
			} else {
				if (s.charAt(i - 1) == '(') {
					score = stack.pop() + 1;
				} else {
					score = stack.pop() + 2 * score;
				}
			}
		}

		return score;
	}

	public static void main(String[] args) {
		String s = "(()(()))";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.scoreOfParentheses(s));
	}
}
