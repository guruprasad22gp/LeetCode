package Minimum_Add_to_Make_Parentheses_Valid;

import java.util.Stack;

public class Solution1 {
	public int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.add(ch);
				}
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		String s = "(((";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minAddToMakeValid(s));
	}
}
