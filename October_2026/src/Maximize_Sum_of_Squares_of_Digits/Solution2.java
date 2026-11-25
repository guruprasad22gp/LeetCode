package Maximize_Sum_of_Squares_of_Digits;

public class Solution2 {
	public String maxSumOfSquares(int num, int sum) {
		if (sum > 9 * num) {
			return "";
		}
		int nines = sum / 9;
		int rem = sum % 9;

		StringBuilder res = new StringBuilder();
		res.repeat('9', nines);
		if (rem > 0) {
			res.append(rem);
		}

		res.repeat('0', num - res.length());
		return res.toString();
	}

	public static void main(String[] args) {
		int num = 2;
		int sum = 21;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maxSumOfSquares(num, sum));
	}
}