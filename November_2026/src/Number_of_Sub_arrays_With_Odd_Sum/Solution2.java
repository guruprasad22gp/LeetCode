package Number_of_Sub_arrays_With_Odd_Sum;

public class Solution2 {
	public int numOfSubarrays(int[] arr) {
		int n = arr.length;
		long[] prefixSum = new long[n];
		prefixSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		int even = 1;
		int res = 0;
		int odd = 0;
		int MOD = 1_000_000_007;
		for (long ele : prefixSum) {
			if (ele % 2 == 0) {
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

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.numOfSubarrays(nums));
	}
}