package Minimum_Add_to_Make_Parentheses_Valid;

public class Solution2 {
	public int minAddToMakeValid(String s) {
		int open = 0;
		int result = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				open++;
			} else {
				if (open > 0) {
					open--;
				} else {
					result++;
				}
			}
		}

		return result + open;
	}

	public static void main(String[] args) {
		String s = "(((";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minAddToMakeValid(s));
	}
}
