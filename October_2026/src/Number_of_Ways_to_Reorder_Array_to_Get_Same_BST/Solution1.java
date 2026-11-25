package Number_of_Ways_to_Reorder_Array_to_Get_Same_BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution1 {
	int MOD = 1_000_000_007;

	int[][] traingle;

	void pascalTraingle() {
		for (int i = 2; i < traingle.length; i++) {
			for (int j = 1; j < i; j++) {
				traingle[i][j] = (traingle[i - 1][j] + traingle[i - 1][j - 1]) % MOD;
			}
		}
	}

	public int numOfWays(int[] nums) {
		int n = nums.length;
		traingle = new int[n + 1][n + 1];
		for (int[] x : traingle) {
			Arrays.fill(x, 1);
		}
		pascalTraingle();
		ArrayList<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
		return (solve(arr) - 1 + MOD) % MOD;
	}

	private int solve(ArrayList<Integer> num) {
		int n = num.size();
		if (n <= 2) {
			return 1;
		}
		ArrayList<Integer> leftArr = new ArrayList<>();
		ArrayList<Integer> rightArr = new ArrayList<>();
		int root = num.get(0);
		for (int i = 1; i < n; i++) {
			if (num.get(i) < root) {
				leftArr.add(num.get(i));
			} else {
				rightArr.add(num.get(i));
			}
		}

		long x = solve(leftArr);
		long y = solve(rightArr);

		long z = traingle[n - 1][leftArr.size()];

		return (int) ((x * y % MOD * z) % MOD);
	}

	public static void main(String[] args) {
		int[] nums = { 9, 4, 2, 1, 3, 6, 5, 7, 8, 14, 11, 10, 12, 13, 16, 15, 17, 18 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.numOfWays(nums));
	}
}