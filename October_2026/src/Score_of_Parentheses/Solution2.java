package Score_of_Parentheses;

// ((()))()
public class Solution2 {
	public int scoreOfParentheses(String s) {
		int score = 0;
		int depth = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				depth++;
			} else {
				depth--;
				if (s.charAt(i - 1) == '(') {
					score += (1 << depth);
				}
			}
		}
		return score;
	}

	public static void main(String[] args) {
		String s = "(()(()))";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.scoreOfParentheses(s));
	}
}
