package Check_if_All_A_s_Appears_Before_All_B_s;

public class Solution1 {
	public boolean checkString(String s) {
		boolean b = false;

		for (char ch : s.toCharArray()) {
			if (ch == 'b') {
				b = true;
			} else if (ch == 'a') {
				if (b) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "bbb";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.checkString(s));
	}
}