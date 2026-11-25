package Find_the_Distance_Value_Between_Two_Arrays;

import java.util.Arrays;

public class Solution2 {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		Arrays.sort(arr2);
		int n = arr2.length;

		for (int ele : arr1) {
			int j = binarySearch(arr2, ele);

			if (j == 0) {
				count += Math.abs(ele - arr2[j]) > d ? 1 : 0;
			} else if (j >= n) {
				count += Math.abs(ele - arr2[n - 1]) > d ? 1 : 0;
			} else {
				count += (Math.abs(ele - arr2[j]) > d && Math.abs(ele - arr2[j - 1]) > d) ? 1 : 0;
			}
		}

		return count;
	}

	private int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] >= key) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		int[] arr1 = { 4, 5, 8 };
		int[] arr2 = { 10, 9, 1, 8 };
		int d = 2;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.findTheDistanceValue(arr1, arr2, d));
	}
}
