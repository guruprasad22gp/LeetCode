package Number_of_Sub_arrays_With_Odd_Sum;

public class Solution3 {
	public int numOfSubarrays(int[] arr) {
		int n = arr.length;
		long sum = 0;
		int even = 1;
		int res = 0;
		int odd = 0;
		int MOD = 1_000_000_007;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum % 2 == 0) {
				res = (res + odd) % MOD;
				even++;
			} else {
				res = (res + even) % MOD;
				odd++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 6 };

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.numOfSubarrays(nums));
	}
}