package Minimum_Changes_to_Make_K_Semi_palindromes;

public class Solution1 {
	int n;

	public int minimumChanges(String s, int k) {
		n = s.length();
		return solve(s, 0, k);
	}

	private int solve(String s, int start, int k) {
		if (k == 0) {
			return start == n ? 0 : Integer.MAX_VALUE;
		}

		if (start + 2 * k > n) {
			return Integer.MAX_VALUE;
		}

		int minCost = Integer.MAX_VALUE;
		for (int end = start + 1; end < n; end++) {
			int remainCost = solve(s, end + 1, k - 1);
			if (remainCost == Integer.MAX_VALUE) {
				continue;
			}

			minCost = Math.min(minCost, getCost(start, end, s) + remainCost);
		}

		return minCost;
	}

	private int getCost(int left, int right, String str) {
		int len = right - left + 1;
		int minCost = Integer.MAX_VALUE;

		for (int d = 1; d < len; d++) {
			if (len % d != 0) {
				continue;
			}
			int cost = 0;
			for (int group = 0; group < d; group++) {
				int l = left + group;
				int r = l + (len / d - 1) * d;
				while (l < r) {
					if (str.charAt(l) != str.charAt(r)) {
						cost++;
					}

					l += d;
					r -= d;
				}
			}

			minCost = Math.min(minCost, cost);
		}

		return minCost;
	}

	public static void main(String[] args) {
		String s = "abcac";
		int k = 2;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumChanges(s, k));
	}
}