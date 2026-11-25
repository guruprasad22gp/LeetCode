package Remove_Outermost_Parentheses;

public class Solution1 {
	public String removeOuterParentheses(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				if (count > 0) {
					sb.append(ch);
				}
				count++;
			} else {
				count--;
				if (count > 0) {
					sb.append(ch);
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "(()())(())(()(()))";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.removeOuterParentheses(s));
	}
}
