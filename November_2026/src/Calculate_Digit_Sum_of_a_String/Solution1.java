package Calculate_Digit_Sum_of_a_String;

public class Solution1 {
	public String digitSum(String s, int k) {
		while (s.length() > k) {
			String arr = "";
			int n = s.length();
			for (int i = 0; i < n; i += k) {
				int sum = 0;
				for (int j = i; j < Math.min(n, i + k); j++) {
					sum += (s.charAt(j) - '0');
				}
				arr += sum;
			}
			s = new String(arr);
		}

		return s;
	}

	public static void main(String[] args) {
		String s = "11111222223";
		int k = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.digitSum(s, k));
	}
}
