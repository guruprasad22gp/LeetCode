package Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful;

public class Solution1 {
	public int minChanges(String s) {
		int cost = 0;
		for (int i = 1; i < s.length(); i += 2) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				cost++;
			}
		}

		return cost;
	}

	public static void main(String[] args) {
		String s = "010100";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minChanges(s));
	}
}