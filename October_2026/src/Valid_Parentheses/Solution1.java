package Valid_Parentheses;

import java.util.Stack;

public class Solution1 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty() && ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{')
						|| (ch == ']' && stack.peek() == '['))) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "}";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isValid(s));
	}
}
