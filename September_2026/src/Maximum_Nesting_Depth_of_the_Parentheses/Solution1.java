package Maximum_Nesting_Depth_of_the_Parentheses;

public class Solution1 {
	public int maxDepth(String s) {
		int depth = 0;
		int max = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				depth++;
			} else if (ch == ')') {
				max = Math.max(max, depth);
				depth--;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String s = "(1+(2*3)+((8)/4))+1";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxDepth(s));

	}

}
