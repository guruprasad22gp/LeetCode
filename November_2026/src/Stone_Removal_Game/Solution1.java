package Stone_Removal_Game;

public class Solution1 {
	public boolean canAliceWin(int n) {
		if (n < 10) {
			return false;
		}

		int i = 10;

		while (n > i) {
			n -= i;
			i--;

			if (n < i) {
				return i % 2 == 1 ? true : false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 47;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.canAliceWin(n));
	}
}