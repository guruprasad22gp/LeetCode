package Maximize_Sum_of_Squares_of_Digits;

public class Solution1 {
	public String maxSumOfSquares(int num, int sum) {
		StringBuilder curr = new StringBuilder();
		while (sum >= 9) {
			curr.append(9);
			sum -= 9;
		}

		if (sum != 0) {
			curr.append(sum);
		}

		while (curr.length() < num) {
			curr.append(0);
		}

		return curr.length() == num ? curr.toString() : "";
	}

	public static void main(String[] args) {
		int num = 2;
		int sum = 17;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxSumOfSquares(num, sum));
	}
}