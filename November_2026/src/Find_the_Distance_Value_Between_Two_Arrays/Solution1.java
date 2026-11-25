package Find_the_Distance_Value_Between_Two_Arrays;

public class Solution1 {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		for (int ele : arr1) {
			boolean isValid = true;
			for (int val : arr2) {
				if (Math.abs(ele - val) <= d) {
					isValid = false;
				}
			}

			if (isValid) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] arr1 = { 4, 5, 8 };
		int[] arr2 = { 10, 9, 1, 8 };
		int d = 2;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findTheDistanceValue(arr1, arr2, d));
	}
}
