package Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful;

public class Solution2 {
	public int minChanges(String s) {
		int currChar = s.charAt(0);
		int count = 0;
		int cost = 0;

		for (char ch : s.toCharArray()) {
			if (ch == currChar) {
				count++;
				continue;
			}

			if (count % 2 == 0) {
				count = 1;
			} else {
				count = 0;
				cost++;
			}
			currChar = ch;
		}

		return cost;
	}

	public static void main(String[] args) {
		String s = "010100";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minChanges(s));
	}
}