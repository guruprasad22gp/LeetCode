package Valid_Parenthesis_String;

public class Solution5 {
	public static void main(String[] args) {
		String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.checkValidString(s));
	}

	public boolean checkValidString(String s) {
		int open = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '*') {
				open++;
			} else {
				open--;
			}

			if (open < 0) {
				return false;
			}
		}

		int close = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')' || s.charAt(i) == '*') {
				close++;
			} else {
				close--;
			}

			if (close < 0) {
				return false;
			}
		}

		return true;
	}
}