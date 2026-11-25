package Valid_Parenthesis_String;

import java.util.Stack;

public class Solution4 {
	public static void main(String[] args) {
		String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.checkValidString(s));
	}

	public boolean checkValidString(String s) {
		Stack<Integer> brackets = new Stack<>();
		Stack<Integer> star = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				brackets.add(i);
			} else if (s.charAt(i) == '*') {
				star.add(i);
			} else {
				if (!brackets.isEmpty()) {
					brackets.pop();
				} else if (!star.isEmpty()) {
					star.pop();
				} else {
					return false;
				}
			}
		}

		while (!brackets.isEmpty() && !star.isEmpty()) {
			if (brackets.peek() > star.peek()) {
				return false;
			}
			brackets.pop();
			star.pop();
		}

		return brackets.isEmpty();

	}
}