package Number_of_Sub_arrays_With_Odd_Sum;

public class Solution1 {
	public int numOfSubarrays(int[] arr) {
		int count = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum % 2 == 1) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 6 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.numOfSubarrays(nums));
	}
}