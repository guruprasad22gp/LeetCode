package Minimum_Insertions_to_Balance_a_Parentheses_String;

public class Solution1 {
	public int minInsertions(String s) {
		int i = 0;
		int n = s.length();
		int count = 0;
		int result = 0;
		while (i < n) {
			if (s.charAt(i) == '(') {
				count++;
				i++;
			} else {

				if (count > 0) {
					count--;
				} else {
					result++;
				}

				if (i + 1 < n && s.charAt(i + 1) == ')') {
					i += 2;
				} else {
					result++;
					i += 1;
				}
			}
		}

		return result + 2 * count;
	}

	public static void main(String[] args) {
		String s = "(()))";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minInsertions(s));
	}
}
