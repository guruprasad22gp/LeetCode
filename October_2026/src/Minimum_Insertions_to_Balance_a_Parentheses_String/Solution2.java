package Minimum_Insertions_to_Balance_a_Parentheses_String;

public class Solution2 {
	public int minInsertions(String s) {
		int res = 0;
		int count = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				count += 2;
				if (count % 2 != 0) {
					res++;
					count--;
				}
			} else {
				count--;
				if (count < 0) {
					res++;
					count += 2;
				}
			}
		}

		return count + res;
	}

	public static void main(String[] args) {
		String s = "(()))";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minInsertions(s));
	}
}
