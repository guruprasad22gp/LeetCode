package Valid_Parenthesis_String;

public class Solution1 {
	public static void main(String[] args) {
		String s = "************************************************************";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.checkValidString(s));
	}

	int j = 0;

	public boolean checkValidString(String s) {
		return solve(0, 0, s);
	}

	private boolean solve(int openCount, int i, String s) {
		System.out.println(j++);
		if (i == s.length() && openCount == 0) {
			return true;
		} else if (i == s.length()) {
			return false;
		}

		if (openCount < 0) {
			return false;
		}

		if (s.charAt(i) == '(') {
			return solve(openCount + 1, i + 1, s);
		} else if (s.charAt(i) == ')') {
			return solve(openCount - 1, i + 1, s);
		} else {
			return solve(openCount + 1, i + 1, s) | solve(openCount, i + 1, s) | solve(openCount - 1, i + 1, s);
		}

	}
}
